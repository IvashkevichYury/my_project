package service;

import model.Blind;

public interface DataWriter {

    void writeDataToList(Blind blind);

    void writeDataToFile(String fileName);
}
