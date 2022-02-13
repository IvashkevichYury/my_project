package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BlindVertical extends Blind{

    public BlindVertical(int width, int height, int type, String mountType) {
        super(width, height, type, mountType);
    }
}
