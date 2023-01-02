package clowoodive.gitblog.example.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("========== CommandLineRunner ==========");
        for (var arg : args) {
            System.out.println("arg : " + arg);
        }
        System.out.println("=======================================");
    }
}
