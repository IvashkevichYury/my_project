package model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Blind {
    @CsvBindByName
    private int width;
    @CsvBindByName
    private int height;
    @CsvBindByName
    private double areaBlinds;
    @CsvBindByName
    private long blindsCost;

    public Blind(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
