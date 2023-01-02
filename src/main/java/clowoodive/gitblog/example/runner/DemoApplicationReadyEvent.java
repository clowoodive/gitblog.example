package clowoodive.gitblog.example.runner;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DemoApplicationReadyEvent {
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        System.out.println("DemoApplicationReadyEvent listener");
    }
}
