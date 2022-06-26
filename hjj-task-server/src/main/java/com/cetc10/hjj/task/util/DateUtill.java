package com.cetc10.hjj.task.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class DateUtill {
    /**
     * 根据日期类型获取日期范围
     *
     * @param type day:当天  week:本周（默认）  month:本月
     * @return
     */
    public static List<String> getFormatDate(String type) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<String> list = new ArrayList<>();

        if ("day".equals(type)) {
            list.add(sdf.format(calendar.getTime()));
        } else if ("month".equals(type)) {
            int index = calendar.get(Calendar.DAY_OF_MONTH);
            for (int i = 0; i < index; i++) {
                list.add(sdf.format(calendar.getTime()));
                calendar.add(Calendar.DAY_OF_MONTH, -1);
            }

        } else {
            int index = calendar.get(Calendar.DAY_OF_WEEK) == 1 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1;
            for (int i = 0; i < index; i++) {
                list.add(sdf.format(calendar.getTime()));
                calendar.add(Calendar.DAY_OF_MONTH, -1);
            }
        }

        // 日期翻转，本来是从大到小，翻转成从小到大
        Collections.reverse(list);
        return list;
    }
}
