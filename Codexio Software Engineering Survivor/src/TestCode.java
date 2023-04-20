import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Shop {

  private static Shop instance;
  private final List<Object> workers = new ArrayList<>();

  private Shop() {
  }

  public static Shop getInstance() {
    if (instance == null) {
      instance = new Shop();
    }

    return instance;
  }

  public void addWorker(Object worker) {
    this.workers.add(worker);
  }

  public BigDecimal getTurnover() {
    BigDecimal turnOver = BigDecimal.ZERO;
    for (Object worker : this.workers) {
      if (worker instanceof SalesConsultant) {
        turnOver = turnOver.add(((SalesConsultant) worker).getMoney());
      }

      if (worker instanceof MarketingSpecialist) {
        turnOver = turnOver.add(((MarketingSpecialist) worker).getBudget());
      }
    }

    return turnOver;
  }
}

class SalesConsultant {

  private BigDecimal earnedMoney = BigDecimal.ZERO;

  public SalesConsultant() {
    Shop workingShop = Shop.getInstance();
    workingShop.addWorker(this);
  }

  public void sellProduct(BigDecimal price) {
    this.earnedMoney = this.earnedMoney.add(price);
  }

  public BigDecimal getMoney() {
    return this.earnedMoney;
  }
}

class MarketingSpecialist {

  private BigDecimal budget = new BigDecimal("5000");

  public MarketingSpecialist() {
    Shop workingShop = Shop.getInstance();
    workingShop.addWorker(this);
  }

  public void spendMoney(BigDecimal marketingCampaignCost) {
    this.budget = this.budget.subtract(marketingCampaignCost);
  }

  public BigDecimal getBudget() {
    return this.budget;
  }
}