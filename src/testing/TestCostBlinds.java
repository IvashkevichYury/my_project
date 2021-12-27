package testing;

import org.junit.jupiter.api.Test;
import service.Blind;
import service.CostBlinds;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCostBlinds {

    CostBlinds costBlinds = new CostBlinds();

    @Test
    void testFindAreaBlinds() {
        Blind blind = new Blind();
        blind.setBlindsWidth(2000);
        blind.setBlindsHeight(4000);
        blind.setColor(201);
        Map<Integer, Double> map = new HashMap<>();
        map.put(201, 8.8);
        map.put(202, 10.4);
        assertEquals(1056, costBlinds.calculateCostOfBlinds(blind, map));

    }
}
