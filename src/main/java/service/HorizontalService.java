package service;

import model.BlindHorizontal;

public interface HorizontalService {

    long calculateCost(BlindHorizontal blindHorizontal, String fileName, String fileNameExchangeRate);
}
