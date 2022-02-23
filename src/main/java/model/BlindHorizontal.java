package model;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BlindHorizontal extends Blind {

    @CsvBindByName
    private int colorNumber;

    public BlindHorizontal(int width, int height, int colorNumber) {
        super(width, height);
        this.colorNumber = colorNumber;
    }
}
