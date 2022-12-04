package me.jaejoon.circuit_test_server.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import java.util.List;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TempHystrix<T> extends HystrixCommand<T> {


    private final Supplier<T> tryMethod;
    private final Supplier<T> fallbackMethod;

    private final List<Class<? extends Exception>> ignoreException;

    private TempHystrix(Setter setter, Supplier<T> tryMethod, Supplier<T> fallbackMethod, List<Class<? extends Exception>> ignoreException) {
        super(setter);
        this.tryMethod = tryMethod;
        this.fallbackMethod = fallbackMethod;
        this.ignoreException = ignoreException;
    }

    @Override
    protected T run() {
        try {
            return tryMethod.get();
        } catch (Exception e) {
            if (ignoreException.contains(e.getClass())) {
                log.warn("error 는 발생했지만 서킷 통계 및 fallback method 는 호출하지 않는다 message ={}", e.getMessage());
                throw new HystrixBadRequestException(e.getMessage(), e);
            }
            throw e;
        }
    }

    @Override
    protected T getFallback() {
        return fallbackMethod.get();
    }

    public static <T> T runHystrix(Supplier<T> supplier, String key, Supplier<T> fallbackMethod, List<Class<? extends Exception>> ignoreException) {
        TempHystrix<T> tTempHystrix = new TempHystrix<>(getSetter(key), supplier, fallbackMethod, ignoreException);
        return tTempHystrix.execute();
    }

    private static HystrixCommand.Setter getSetter(String key) {
        HystrixCommandProperties.Setter properties = HystrixCommandProperties.Setter()
                .withExecutionTimeoutEnabled(true)
                .withExecutionTimeoutInMilliseconds(2000);

        return HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("Test"))
                .andCommandKey(HystrixCommandKey.Factory.asKey(key))
                .andCommandPropertiesDefaults(properties);

    }

}
