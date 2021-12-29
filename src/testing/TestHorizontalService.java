package testing;

import org.junit.jupiter.api.Test;
import model.Blind;
import service.HorizontalServiceImpl;
import service.PriceCatalogImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHorizontalService {

    HorizontalServiceImpl horizontalBlindServiceImpl = new HorizontalServiceImpl();

    @Test
    void testCalculateCostOfBlinds() {
        Blind blind = new Blind();
        PriceCatalogImpl catalog = new PriceCatalogImpl();
        catalog.initDate();
        blind.setWidth(2000);
        blind.setHeight(4000);
        blind.setColor(201);
        Map<Integer, Double> map = new HashMap<>();
        map.put(201, 8.8);
        map.put(202, 10.4);
        assertEquals(1056, horizontalBlindServiceImpl.calculateCost(blind, catalog));

    }
}
