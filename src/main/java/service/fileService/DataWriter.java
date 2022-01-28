package service.fileService;

import model.Blind;

public interface DataWriter {

    void writeDataToList(Blind blind);

    void writeDataToFile(String fileName);
}
