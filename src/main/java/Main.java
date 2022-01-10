import model.BlindHorizontal;
import service.*;
import view.UserPage;
import view.UserPageImpl;

public class Main {
    public static void main(String[] args) {

        BlindHorizontal blindHorizontal = new BlindHorizontal();
        DataReader dataReader = new DataReaderImpl();
        PriceCatalog priceCatalog = new PriceCatalogImpl(dataReader);
        HorizontalService horizontalService = new HorizontalServiceImpl(blindHorizontal, priceCatalog);
        UserPage userPageImpl = new UserPageImpl(horizontalService, priceCatalog);

        userPageImpl.showBlindCost();

    }
}
