package com.vergilyn.examples.spring.v6x.retry;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.retry.*;
import org.springframework.retry.backoff.BackOffContext;
import org.springframework.retry.backoff.BackOffInterruptedException;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@SuppressWarnings("JavadocReference")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RetryTemplateCodeModeTests {
    private static final AtomicInteger index = new AtomicInteger();

    private static final PrintStream standardOut = System.out;
    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private RetryTemplate retryTemplate = null;

    @BeforeAll
    public void init() {
        System.setOut(new PrintStream(outputStreamCaptor));

        retryTemplate = RetryTemplate.builder()
                                     // .maxAttempts(3)
                                     .customPolicy(new SimpleRetryPolicy(3))
                                     // .fixedBackoff(1000)
                                     .customBackoff(new HelloworldBackOffPolicy())
                                     .withListeners(Lists.newArrayList(new HelloworldRetryListener()))
                                     .retryOn(Lists.newArrayList(ArithmeticException.class))
                                     .build();

        // retryTemplate.setThrowLastExceptionOnExhausted(false);
    }

    @AfterAll
    public void afterAll() {
        System.setOut(standardOut);
    }

    /**
     * 2022-08-16, <a href="https://github.com/spring-projects/spring-retry/pull/289">GH-231: Support Retry Based on Result</a>
     * <br/> see：{@link RetryListener#onSuccess(RetryContext, RetryCallback, Object)}
     *
     * @see RetryTemplate#doExecute(RetryCallback, RecoveryCallback, RetryState)
     */
    @SneakyThrows
    @Test
    public void test() {

        Throwable throwable = catchThrowable(() -> {
            retryTemplate.execute((RetryCallback<Integer, Throwable>) context -> {
                print("[vergilyn][method]-" + index.getAndIncrement(), "method");
                int a = 1, b = 0;
                return a / b;
            });
        });

        assertThat(throwable).isInstanceOf(ArithmeticException.class).hasMessage("/ by zero");

        assertThat(outputStreamCaptor.toString())
                .asString()
                .isNotEmpty()
                .containsSubsequence(
                        "[spring][RetryListener] #open >>>> "
                        , "[spring][BackOffPolicy] #start >>>> "
                        , "[vergilyn][method]-0 #method >>>> "
                        , "[spring][RetryListener] #onError >>>> "
                        , "[spring][BackOffPolicy] #backOff >>>> "
                        , "[vergilyn][method]-1 #method >>>> "
                        , "[spring][RetryListener] #onError >>>> "
                        , "[spring][BackOffPolicy] #backOff >>>> "
                        , "[vergilyn][method]-2 #method >>>> "
                        , "[spring][RetryListener] #onError >>>> "
                        , "[spring][RetryListener] #close >>>> "
                );
    }

    private static void print(String prefix, String method) {
        System.out.printf("%s #%s >>>> \n", prefix, method);
    }

    @Slf4j
    public static class HelloworldBackOffPolicy implements BackOffPolicy {
        private static final String LOG_PREFIX = "[spring][BackOffPolicy]";

        @Override
        public BackOffContext start(RetryContext context) {
            print(LOG_PREFIX, "start");
            return null;
        }

        @Override
        public void backOff(BackOffContext backOffContext) throws BackOffInterruptedException {
            print(LOG_PREFIX, "backOff");
        }
    }

    @Slf4j
    public static class HelloworldRetryListener implements RetryListener {
        private static final String LOG_PREFIX = "[spring][RetryListener]";

        @Override
        public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
            print(LOG_PREFIX, "open");

            // javadoc:
            //   > The whole retry can be vetoed by returning false from this method,
            //   > in which case a TerminatedRetryException will be thrown.
            return true;
        }

        @Override
        public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback,
                                                   Throwable throwable) {
            print(LOG_PREFIX, "close");
        }

        @Override
        public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback,
                                                     Throwable throwable) {
            print(LOG_PREFIX, "onError");
        }

        // `spring-retry: 2.0.0-SNAPSHOT` 新增。
        @Override
        public <T, E extends Throwable> void onSuccess(RetryContext context, RetryCallback<T, E> callback, T result) {
            print(LOG_PREFIX, "onSuccess");
            RetryListener.super.onSuccess(context, callback, result);
        }
    }
}
