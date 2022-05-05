package clowoodive.gitblog.example.solid.ocp;

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
        private short productType;
        private int investingAmount;
    }

    private GoldInvestingService goldInvestingService;
    private FundInvestingService fundInvestingService;

    public InvestingController(GoldInvestingService goldInvestingService, FundInvestingService fundInvestingService) {
        this.goldInvestingService = goldInvestingService;
        this.fundInvestingService = fundInvestingService;
    }

    @PostMapping(value = "/solid/ocp/investing/gold")
    public void investingGold(@RequestBody InvestingReq req) {
        goldInvestingService.investing(req);
    }

    @PostMapping(value = "/solid/ocp/investing/fund")
    public void investingFund(@RequestBody InvestingReq req) {
        fundInvestingService.investing(req);
    }
}
