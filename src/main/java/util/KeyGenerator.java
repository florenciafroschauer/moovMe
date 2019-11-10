package util;

import java.util.Date;

public class KeyGenerator {

    private Long key;

    public Long generateKey() {
        return new Date().getTime();
    }
}
