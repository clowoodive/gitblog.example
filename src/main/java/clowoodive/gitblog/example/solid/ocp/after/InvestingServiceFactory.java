package clowoodive.gitblog.example.solid.ocp.after;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvestingServiceFactory {
    private final FundInvestingService fundInvestingService;
    private final GoldInvestingService goldInvestingService;

    @Autowired
    public InvestingServiceFactory(FundInvestingService fundInvestingService, GoldInvestingService goldInvestingService) {
        this.fundInvestingService = fundInvestingService;
        this.goldInvestingService = goldInvestingService;
    }

    public InvestingService getByType(String productType) {
        InvestingService investingService;

        var type = ProductType.valueOf(productType);

        switch (type) {
            case Gold:
                investingService = goldInvestingService;
                break;
            case Fund:
                investingService = fundInvestingService;
                break;
            default:
                throw new RuntimeException("bad type");
        }

        return investingService;
    }

    public enum ProductType {
        None(0),
        Gold(1),
        Fund(2);

        private final int value;

        ProductType(int value) {
            this.value = value;
        }
    }
}
