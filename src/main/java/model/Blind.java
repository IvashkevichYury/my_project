package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Blind {
    private int width;
    private int height;
    private int type;
    private int colorNumber;
    private Color color;
    private MountType mountType;
    private double areaBlinds;
    private long blindsCost;

    public Blind(int width, int height, int colorNumber) {
        this.width = width;
        this.height = height;
        this.colorNumber = colorNumber;
    }

    public Blind(int width, int height, int type, MountType mountType) {
        this.width = width;
        this.height = height;
        this.type = type;
        this.mountType = mountType;
    }
}
