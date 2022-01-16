package service;

import model.BlindVertical;

public interface VerticalService {

    long calculateCost(BlindVertical blindVertical);

    String returnColor(int numberColor);

    String returnMountType(int numberMount);
}
