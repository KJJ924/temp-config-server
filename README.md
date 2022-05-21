# temp-config-server

reference

- https://cloud.spring.io/spring-cloud-config/multi/multi__spring_cloud_config_server.html
- https://cloud.spring.io/spring-cloud-config/reference/html/


kafka 명령어

- sh kafka-topics.sh --zookeeper {host} --list // topic 목록보기
- sh kafka-console-consumer.sh --bootstrap-server {host} --topic {topic_name} --from-beginning //topic 컨슘





----

## 참고



커스텀 PropertySourceLocator 등록시 `spring.cloud.config.enabled = false` 값을 주지않으면 
PropertySourceLocator 이 2개  
(구현한 custom 과 기존 ConfigServicePropertySourceLocator) 등록되어 config-server 로 부터 property 설정을 두번 가져오게된다.

![image](https://user-images.githubusercontent.com/64793712/169665521-c8beea94-12ce-4a76-b4f6-b0b859054f99.png)



따라서 반드시 기존 등록되는 PropertySourceLocator 를 막기위해서 반드시 설정하고 커스텀을 진행 해야한다.  
(~~왜 레퍼런스에는 없지.. 내가 못찾은거겠지 ㅜ,ㅜ..~~)


![image](https://user-images.githubusercontent.com/64793712/169665559-2b84991e-50cc-40dd-864e-1d39a1f53a19.png)
