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
        Property property = new PropertyImpl();
        ExchangeRate exchangeRate = new ExchangeRateImpl(property);
        PriceCatalogHorizontal priceCatalogHorizontalImpl = new PriceCatalogHorizontalImpl(dataReader, property);
        PriceCatalogVertical priceCatalogVerticalImpl = new PriceCatalogVerticalImpl(dataReader, property);
        HorizontalService horizontalService = new HorizontalServiceImpl(blindHorizontal, priceCatalogHorizontalImpl, exchangeRate);
        VerticalService verticalService = new VerticalServiceImpl(blindVertical, priceCatalogVerticalImpl, exchangeRate);
        UserPage userPageImpl = new UserPageImpl(horizontalService, verticalService);
        userPageImpl.showBlindCost();

    }
}
