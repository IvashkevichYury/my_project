import model.BlindHorizontal;
import model.BlindVertical;
import service.blindService.*;
import service.catalog.*;
import service.fileService.*;
import view.UserPage;
import view.UserPageImpl;

public class Main {
    public static void main(String[] args) {

        BlindHorizontal blindHorizontal = new BlindHorizontal();
        BlindVertical blindVertical = new BlindVertical();
        Property property = new Property();
        DataReader dataReader = new DataReaderImpl();
        DataWriter dataWriter = new DataWriterImpl();
        DataSaver saver = new DataSaver();
        Validator validator = new Validator();
        ExchangeRate exchangeRate = new ExchangeRateImpl(property);
        PriceCatalogHorizontal priceCatalogHorizontalImpl = new PriceCatalogHorizontalImpl(dataReader, property);
        PriceCatalogVertical priceCatalogVerticalImpl = new PriceCatalogVerticalImpl(dataReader, property);
        HorizontalService horizontalService = new HorizontalServiceImpl(blindHorizontal, priceCatalogHorizontalImpl, exchangeRate);
        VerticalService verticalService = new VerticalServiceImpl(blindVertical, priceCatalogVerticalImpl, exchangeRate);
        UserPage userPageImpl = new UserPageImpl(horizontalService, verticalService, property, dataWriter, saver, validator);
        userPageImpl.showBlindCost();

    }
}
