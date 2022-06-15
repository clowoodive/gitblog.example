package clowoodive.gitblog.example;

import clowoodive.gitblog.example.bfs.Bfs;
import clowoodive.gitblog.example.codingtest.CodingTest1;
import clowoodive.gitblog.example.dfs.Dfs;
import clowoodive.gitblog.example.zoneddatetime.ZonedDateTimeService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    //    @Bean
    public ApplicationRunner zonedDateTimeRunner() {
        return args -> {
            ZonedDateTimeService zonedDateTimeService = new ZonedDateTimeService();
            int serviceTimeZone = 5;    // UTC+5 몰디브
            LocalDateTime serviceCheckTime = LocalDateTime.parse("2022-05-20T00:00:00");

            var serverLocalDateTime = zonedDateTimeService.convertToServerTimeZonedDateTime(serviceTimeZone, serviceCheckTime);

            System.out.println("service area time(UTC+" + serviceTimeZone + ") : " + serviceCheckTime);
            System.out.println("zoned time by server default timezone(UTC+" + ZoneId.systemDefault() + ") : " + serverLocalDateTime);
        };
    }

    //    @Bean
    public ApplicationRunner dfsRunner() {
        return args -> {
            Dfs dfs = new Dfs();
            dfs.doDfs(1);
        };
    }

    //    @Bean
    public ApplicationRunner bfsRunner() {
        return args -> {
            Bfs bfs = new Bfs();
            bfs.doBfs(1);
        };
    }

    //    @Bean
    public ApplicationRunner codingTest1Runner() {
        return args -> {
            CodingTest1 text = new CodingTest1();
            var ret = text.solution(1000);
            System.out.println("ret : " + ret);

        };
    }
}
