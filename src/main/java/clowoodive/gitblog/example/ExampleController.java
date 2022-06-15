package clowoodive.gitblog.example;

import clowoodive.gitblog.example.dfs.Dfs;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/example", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExampleController {

    @GetMapping(value = "/dfs")
    public void dfs() {
        Dfs dfs = new Dfs();
        dfs.doDfs(1);
    }

}
