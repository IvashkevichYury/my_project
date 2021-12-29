package testing;

import org.junit.jupiter.api.Test;
import model.Blind;
import service.HorizontalBlindServiceImpl;
import service.PriceCatalogImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHorizontalBlindService {

    HorizontalBlindServiceImpl horizontalBlindServiceImpl = new HorizontalBlindServiceImpl();

    @Test
    void testCalculateCostOfBlinds() {
        Blind blind = new Blind();
        PriceCatalogImpl catalog = new PriceCatalogImpl();
        catalog.initDate();
        blind.setBlindsWidth(2000);
        blind.setBlindsHeight(4000);
        blind.setColor(201);
        Map<Integer, Double> map = new HashMap<>();
        map.put(201, 8.8);
        map.put(202, 10.4);
        assertEquals(1056, horizontalBlindServiceImpl.calculateCostOfBlinds(blind, catalog));

    }
}
