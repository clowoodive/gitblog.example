package clowoodive.gitblog.example.solid.ocp;

import org.springframework.stereotype.Service;

@Service
public class FundInvestingService {
    public void investing(InvestingController.InvestingReq req) {
        System.out.println("Gold Investing");
    }
}