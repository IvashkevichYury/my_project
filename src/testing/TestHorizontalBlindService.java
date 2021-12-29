package testing;

import org.junit.jupiter.api.Test;
import model.Blind;
import service.HorizontalBlindService;
import service.PriceCatalog;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHorizontalBlindService {

    HorizontalBlindService horizontalBlindService = new HorizontalBlindService();

    @Test
    void testCalculateCostOfBlinds() {
        Blind blind = new Blind();
        PriceCatalog catalog = new PriceCatalog();
        catalog.initDate();
        blind.setBlindsWidth(2000);
        blind.setBlindsHeight(4000);
        blind.setColor(201);
        Map<Integer, Double> map = new HashMap<>();
        map.put(201, 8.8);
        map.put(202, 10.4);
        assertEquals(1056, horizontalBlindService.calculateCostOfBlinds(blind, catalog));

    }
}
