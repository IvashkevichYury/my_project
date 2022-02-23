package service.fileService;

import model.BlindHorizontal;
import model.BlindVertical;

import java.util.List;

public interface DataWriter {

    void writeDataToFile(List<BlindHorizontal> blindHorizontalList, List<BlindVertical> blindVerticalList);
}
