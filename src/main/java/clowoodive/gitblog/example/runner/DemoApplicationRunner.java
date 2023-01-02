package clowoodive.gitblog.example.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DemoApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("========== ApplicationRunner ==========");
        System.out.println("SourceArgs : " + Arrays.toString(args.getSourceArgs()));
        System.out.println("OptionNames : " + args.getOptionNames());
        for (var name : args.getOptionNames()) {
            System.out.println(name + "OptionValue : " + args.getOptionValues(name));
        }
        System.out.println("NonOptionArgs : " + args.getNonOptionArgs());
        System.out.println("=======================================");
    }
}
