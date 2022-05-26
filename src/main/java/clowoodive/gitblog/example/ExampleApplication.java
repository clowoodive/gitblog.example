package clowoodive.gitblog.example;

import clowoodive.gitblog.example.zoneddatetime.ZonedDateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;

@SpringBootApplication
public class ExampleApplication {

    @Autowired
    ZonedDateTimeService zonedDateTimeService;

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            int serviceTimeZone = 5;    // UTC+5 몰디브
            LocalDateTime serviceCheckTime = LocalDateTime.parse("2022-05-20T00:00:00");

            var serverLocalDateTime = zonedDateTimeService.convertToServerTimeZonedDateTime(serviceTimeZone, serviceCheckTime);

            System.out.println("service area time(UTC+" + serviceTimeZone + ") : " + serviceCheckTime);
            System.out.println("zoned time by server default timezone(UTC+" + ZoneId.systemDefault() + ") : " + serverLocalDateTime);
        };
    }
}
