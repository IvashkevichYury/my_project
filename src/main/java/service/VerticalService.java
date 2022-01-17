package service;

import model.BlindVertical;

public interface VerticalService {

    long calculateCost(BlindVertical blindVertical);

    String getColor(int numberColor);

    String getMountType(int numberMount);
}
