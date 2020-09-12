package romerical;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import static romerical.RomanValues.*;

public class RomanToNumericConverter {

    private final static LinkedHashMap<String, Integer> arabicRomanMap = new LinkedHashMap<>();

    static {

        arabicRomanMap.put(M, 1000);
        arabicRomanMap.put(CM, 900);
        arabicRomanMap.put(D, 500);
        arabicRomanMap.put(CD, 400);
        arabicRomanMap.put(C, 100);
        arabicRomanMap.put(XC, 90);
        arabicRomanMap.put(L, 50);
        arabicRomanMap.put(XL, 40);
        arabicRomanMap.put(X, 10);
        arabicRomanMap.put(IX, 9);
        arabicRomanMap.put(V, 5);
        arabicRomanMap.put(IV, 4);
        arabicRomanMap.put(I, 1);

    }

    private RomanToNumericConverter(){}

    public static int toNumeric(String romanValue){
        int value = 0;
        for(String k: arabicRomanMap.keySet()){
            validateRomanValue(romanValue, k);
            while((romanValue.length()>=1 && romanValue.substring(0,1).equals(k))
                    || (romanValue.length()>=2 && romanValue.substring(0,2).equals(k))){
                value+=arabicRomanMap.get(k);
                romanValue = romanValue.replaceFirst(k, "");
            }
        }
        if(!romanValue.equals(""))
            throw new NotARomanNumberException();
        return value;
    }

    private static void validateRomanValue(String romanValue, String k) {
        if (k.length() == 2 && StringUtils.countMatches(romanValue, k) > 1)
            throw new NotARomanNumberException();
        if (k.length() == 1 && romanValue.length()>=4 && StringUtils.countMatches(romanValue.substring(0,4), k) > 3)
            throw new NotARomanNumberException();
    }

}
