package service.fileService;

import model.Blind;

import java.util.List;

public interface DataWriter {

    void writeDataToFile(List<? extends Blind> blind);
}
