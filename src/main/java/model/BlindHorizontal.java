package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BlindHorizontal extends Blind{

    public BlindHorizontal(int width, int height, int colorNumber) {
        super(width, height, colorNumber);
    }
}
