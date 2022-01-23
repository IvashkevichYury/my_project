import model.BlindHorizontal;
import model.BlindVertical;
import service.*;
import view.UserPage;
import view.UserPageImpl;

public class Main {
    public static void main(String[] args) {

        BlindHorizontal blindHorizontal = new BlindHorizontal();
        BlindVertical blindVertical = new BlindVertical();
        DataReader dataReader = new DataReaderImpl();
        ExchangeRate exchangeRate = new ExchangeRateImpl();
        PriceCatalogHorizontal priceCatalogHorizontalImpl = new PriceCatalogHorizontalImpl(dataReader);
        PriceCatalogVertical priceCatalogVerticalImpl = new PriceCatalogVerticalImpl(dataReader);
        HorizontalService horizontalService = new HorizontalServiceImpl(blindHorizontal, priceCatalogHorizontalImpl, exchangeRate);
        VerticalService verticalService = new VerticalServiceImpl(blindVertical, priceCatalogVerticalImpl, exchangeRate);
        UserPage userPageImpl = new UserPageImpl(horizontalService, verticalService);
        userPageImpl.showBlindCost();

    }
}
