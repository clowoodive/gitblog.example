package clowoodive.gitblog.example.solid.ocp.after;

import clowoodive.gitblog.example.solid.ocp.after.InvestingController.InvestingReq;
import org.springframework.stereotype.Service;

@Service
public class GoldInvestingService implements InvestingService {
    @Override
    public void investing(InvestingReq req) {
        System.out.println("Gold Investing");
    }
}
