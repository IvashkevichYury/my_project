import model.BlindHorizontal;
import model.BlindVertical;
import service.calculating.HorizontalService;
import service.calculating.HorizontalServiceImpl;
import service.calculating.VerticalService;
import service.calculating.VerticalServiceImpl;
import service.catalog.*;
import service.fileService.DataReader;
import service.fileService.DataReaderImpl;
import service.fileService.Property;
import view.UserPage;
import view.UserPageImpl;

public class Main {
    public static void main(String[] args) {

        BlindHorizontal blindHorizontal = new BlindHorizontal();
        BlindVertical blindVertical = new BlindVertical();
        Property property = new Property();
        DataReader dataReader = new DataReaderImpl();
        ExchangeRate exchangeRate = new ExchangeRateImpl(property);
        PriceCatalogHorizontal priceCatalogHorizontalImpl = new PriceCatalogHorizontalImpl(dataReader, property);
        PriceCatalogVertical priceCatalogVerticalImpl = new PriceCatalogVerticalImpl(dataReader, property);
        HorizontalService horizontalService = new HorizontalServiceImpl(blindHorizontal, priceCatalogHorizontalImpl, exchangeRate);
        VerticalService verticalService = new VerticalServiceImpl(blindVertical, priceCatalogVerticalImpl, exchangeRate);
        UserPage userPageImpl = new UserPageImpl(horizontalService, verticalService, property);
        userPageImpl.showBlindCost();

    }
}
