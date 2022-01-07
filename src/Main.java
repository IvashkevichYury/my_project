import model.BlindHorizontal;
import service.HorizontalService;
import service.HorizontalServiceImpl;
import service.PriceCatalog;
import service.PriceCatalogImpl;
import view.UserPage;
import view.UserPageImpl;

public class Main {
    public static void main(String[] args) {

        BlindHorizontal blindHorizontal = new BlindHorizontal();
        PriceCatalog priceCatalog = new PriceCatalogImpl();
        HorizontalService horizontalService = new HorizontalServiceImpl(blindHorizontal, priceCatalog);
        UserPage userPageImpl = new UserPageImpl(horizontalService, priceCatalog);

        userPageImpl.showBlindCost();

    }
}
