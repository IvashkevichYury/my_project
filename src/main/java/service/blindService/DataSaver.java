package service.blindService;

import model.Blind;

import java.util.ArrayList;
import java.util.List;

public class DataSaver {

    private List<Blind> blinds = new ArrayList<>();

    public void writeDataToList(Blind blind) {
        blinds.add(blind);
    }

    public List<Blind> getBlinds() {
        return blinds;
    }
}
