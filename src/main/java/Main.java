import model.BlindHorizontal;
import model.BlindVertical;
import service.*;
import view.UserPage;
import view.UserPageImpl;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        BlindHorizontal blindHorizontal = new BlindHorizontal();
        BlindVertical blindVertical = new BlindVertical();
        Property property = new Property();
        String verticalCatalog = property.getProperty("verticalCatalog");
        String horizontalCatalog = property.getProperty("horizontalCatalog");
        String outputFile = property.getProperty("outputFile");
        String priceMount = property.getProperty("priceMount");
        String dollarExchangeRate = property.getProperty("dollarExchangeRate");
        DataReader dataReader = new DataReaderImpl();
        ExchangeRate exchangeRate = new ExchangeRateImpl(dollarExchangeRate);
        PriceCatalogHorizontal priceCatalogHorizontalImpl = new PriceCatalogHorizontalImpl(dataReader, horizontalCatalog);
        PriceCatalogVertical priceCatalogVerticalImpl = new PriceCatalogVerticalImpl(dataReader, priceMount, verticalCatalog);
        HorizontalService horizontalService = new HorizontalServiceImpl(blindHorizontal, priceCatalogHorizontalImpl, exchangeRate);
        VerticalService verticalService = new VerticalServiceImpl(blindVertical, priceCatalogVerticalImpl, exchangeRate);
        UserPage userPageImpl = new UserPageImpl(horizontalService, verticalService, outputFile);
        userPageImpl.showBlindCost();

    }
}
