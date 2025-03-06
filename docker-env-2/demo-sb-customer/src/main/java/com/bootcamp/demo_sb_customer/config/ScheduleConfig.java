package com.bootcamp.demo_sb_customer.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConfig {

    @Scheduled(cron = "0 40 17 * * MON")
    public void testCronJob() {
        System.out.println("Test Cron Job");
    }

    // 相差 9s = 4000 + 5000
    @Scheduled(fixedDelay = 4000) // 4000 ms
    public void sayHello() throws Exception {
        System.out.println(System.currentTimeMillis());
        Thread.sleep(5000);
        System.out.println("Hello World");
    }

    // @Scheduled(fixedDelay = 2000) // 2000 ms
    // public void sayGoodBye() {
    //     System.out.println("Goodbye");
    // }

    // 相差 5s
    // task 既
    // @Scheduled(fixedRate = 4000) // 3000 ms
    // public void sayGoodBye() throws Exception {
    //     System.out.println(System.currentTimeMillis());
    //     Thread.sleep(5000);
    //     System.out.println("abcd");
    // }

}
