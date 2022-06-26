package com.cetc10.hjj.task.cons;

import java.util.HashMap;
import java.util.Map;

public class Rate {
    //设置利率的默认值
    public final static Map CARDRATE = new HashMap<Integer,Double>();
    static {
        CARDRATE.put(1, 1.35);
        CARDRATE.put(2, 1.55);
        CARDRATE.put(3, 1.75);
    }
}
