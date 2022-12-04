package me.jaejoon.circuit_test_server.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.List;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import me.jaejoon.circuit_test_server.config.TempHystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TempServerCallService {

    private final RestTemplate restTemplate;

    public String userName() {
        return getUserNamePrivate();
    }

    // private 메서드는 proxy 를 적용할 수 없기 때문에 Hystrix 가 적용되지 않는다.
    // public method 여도 같은 클래스 메서드를 통해 해당 메서드가 호출되어도 Hystrix 는 적용되지 않는다.
    @HystrixCommand(commandKey = "userName", fallbackMethod = "getPrivateMethodUserFallback")
    public String getPrivateMethodUserName() {
        return restTemplate.getForObject("/username", String.class);
    }

    //이건 상관없다
    private String getUserNamePrivate() {
        return TempHystrix.runHystrix(
                () -> {
                    throw new IllegalArgumentException("IllegalArgumentException 발생은 fallback method 로 가지않는다");
//                    return restTemplate.getForObject("/username", String.class);
                },
                "userName",
                getUserNameFallback(),
                List.of(IllegalArgumentException.class)
        );
    }


    public String userNameSleep() {
        return TempHystrix.runHystrix(
                () -> restTemplate.getForObject("/username/timeout", String.class),
                "userName",
                getUserNameFallback(),
                List.of(IllegalArgumentException.class)
        );
    }

    public String getPrivateMethodUserFallback() {
        return "fallback TEST";
    }

    public Supplier<String> getUserNameFallback() {
        return () -> "fallback TEST";
    }
}
