import model.BlindHorizontal;
import model.BlindVertical;
import service.blindService.*;
import service.catalog.*;
import service.fileService.*;
import view.UserPage;
import view.UserPageImpl;

public class Calculator {
    public static void main(String[] args) {

        BlindHorizontal blindHorizontal = new BlindHorizontal();
        BlindVertical blindVertical = new BlindVertical();
        Property property = new Property();
        DataReader dataReader = new DataReaderImpl();
        DataWriter dataHorizontalWriter = new DataHorizontalWriterImpl();
        DataWriter dataVerticalWriter = new DataVerticalWriterImpl();
        DataSaver saver = new DataSaver();
        Validator validator = new Validator();
        ExchangeRate exchangeRate = new ExchangeRateImpl(property);
        PriceCatalogHorizontal priceCatalogHorizontalImpl = new PriceCatalogHorizontalImpl(dataReader, property);
        PriceCatalogVertical priceCatalogVerticalImpl = new PriceCatalogVerticalImpl(dataReader, property);
        HorizontalService horizontalService = new HorizontalServiceImpl(blindHorizontal, priceCatalogHorizontalImpl, exchangeRate, validator);
        VerticalService verticalService = new VerticalServiceImpl(blindVertical, priceCatalogVerticalImpl, exchangeRate, validator);
        UserPage userPageImpl = new UserPageImpl(horizontalService, verticalService, property, dataHorizontalWriter, dataVerticalWriter, saver, validator);
        userPageImpl.showBlindCost();

    }
}