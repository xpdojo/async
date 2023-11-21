package com.example.demo.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
public class AsyncConfig {

    /**
     * ThreadPoolTaskExecutor 를 등록하지 않으면
     * 기본적으로 {@link org.springframework.core.task.SimpleAsyncTaskExecutor} 가 사용된다.
     * 그럼 Thread Pool을 사용하지 않는다.
     * 해당 클래스 주석에도 아래와 같이 적혀 있다.
     *
     * <pre>
     *     NOTE: This implementation does not reuse threads!
     *     Consider a thread-pooling TaskExecutor implementation instead,
     *     in particular for executing a large number of short-lived tasks.
     * </pre>
     */
    @Bean(name = "demo-thread") // 이렇게 이름을 지정하면, @Async("demo-thread") 로 사용할 수 있다.
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(20);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.setThreadNamePrefix("demo-prefix-"); // 이렇게 별도로 지정하면 logging에는 bean name이 아닌 prefix가 사용된다.
        return executor;
    }

}
