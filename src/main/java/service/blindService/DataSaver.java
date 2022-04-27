package service.blindService;

import model.BlindHorizontal;
import model.BlindVertical;

import java.util.ArrayList;
import java.util.List;

public class DataSaver {

    private List<BlindHorizontal> blindHorizontalList = new ArrayList<>();
    private List<BlindVertical> blindVerticalList = new ArrayList<>();

    public void writeBlindHorizontalToList(BlindHorizontal blindHorizontal) {
        blindHorizontalList.add(blindHorizontal);
    }

    public void writeBlindVerticalToList(BlindVertical blindVertical) {
        blindVerticalList.add(blindVertical);
    }

    public List<BlindHorizontal> getBlindHorizontalList() {
        return blindHorizontalList;
    }

    public List<BlindVertical> getBlindVerticalList() {
        return blindVerticalList;
    }
}
