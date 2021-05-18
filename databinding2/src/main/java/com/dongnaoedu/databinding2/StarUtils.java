package com.dongnaoedu.databinding2;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class StarUtils {

    public static String getStar(int star){
        switch (star){
            case 1:
                return "一星";
            case 2:
                return "二星";
            case 3:
                return "三星";
            case 4:
                return "四星";
            case 5:
                return "五星";
        }
        return "";
    }
}
