package javabasic.enumprac.serialize;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class City {
    private Distance distance;
}
