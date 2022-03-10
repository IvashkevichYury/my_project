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
public abstract class Blind {
    @CsvBindByName
    private int width;
    @CsvBindByName
    private int height;
    @CsvBindByName
    private double area;
    @CsvBindByName
    private long cost;

    public Blind(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
