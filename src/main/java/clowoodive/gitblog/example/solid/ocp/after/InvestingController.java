package clowoodive.gitblog.example.solid.ocp.after;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class InvestingController {
    @Getter
    @Setter
    public static class InvestingReq {
        private long userId;
        private int productId;
        private String productType;
        private int investingAmount;
    }

    private GoldInvestingService goldInvestingService;
    private FundInvestingService fundInvestingService;
    private InvestingServiceFactory investingServiceFactory;

    public InvestingController(GoldInvestingService goldInvestingService, FundInvestingService fundInvestingService,
                               InvestingServiceFactory investingServiceFactory) {
        this.goldInvestingService = goldInvestingService;
        this.fundInvestingService = fundInvestingService;
        this.investingServiceFactory = investingServiceFactory;
    }

    @PostMapping(value = "/solid/ocp/investing")
    public void investing(@RequestBody InvestingReq req) {
        InvestingService investingService = investingServiceFactory.getByType(req.productType);
        investingService.investing(req);
    }
}
