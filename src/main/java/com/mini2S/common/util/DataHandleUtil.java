package com.mini2S.common.util;

public class DataHandleUtil {

    /**
     * Object 타입을 Double 로 형변환
     *
     * @param object double 로 변환될 object
     * @return Double
     */
    public static Double objectToDouble(Object object) {
        Double doubleObject = null;
        try {
            doubleObject = Double.parseDouble(object.toString());
        } catch (NumberFormatException | NullPointerException e) {
            e.printStackTrace();
        }
        return doubleObject;
    }
}
