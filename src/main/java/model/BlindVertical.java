package model;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BlindVertical extends Blind {

    @CsvBindByName
    private int type;
    @CsvBindByName
    private Color color;
    @CsvBindByName
    private MountType mountType;

    public BlindVertical(int width, int height, int type, MountType mountType) {
        super(width, height);
        this.type = type;
        this.mountType = mountType;
    }
}
