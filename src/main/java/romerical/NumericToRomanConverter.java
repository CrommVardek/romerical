package romerical;

import static romerical.RomanValues.*;

public class NumericToRomanConverter {

    private NumericToRomanConverter(){}

    public static String toRoman(int numericValue){

        if(numericValue <= 0) throw new IllegalArgumentException("Value must be positive");

        if(numericValue > 4999) throw new IllegalArgumentException("Value must lower than 5000");

        StringBuilder result = new StringBuilder();

        while(numericValue>1000){
            result.append(M);
            numericValue-=1000;
        }
        if(numericValue>899){
            result.append(CM);
            numericValue-=900;
        }
        if(numericValue>=500){
            result.append(D);
            numericValue-=500;
        }
        if(numericValue>399){
            result.append(CD);
            numericValue-=400;
        }
        while(numericValue>99){
            result.append(C);
            numericValue-=100;
        }
        if(numericValue>89){
            result.append(XC);
            numericValue-=90;
        }
        if(numericValue>=50){
            result.append(L);
            numericValue-=50;
        }
        if(numericValue>39){
            result.append(XL);
            numericValue-=40;
        }
        while(numericValue>9){
            result.append(X);
            numericValue-=10;
        }
        if(numericValue==9){
            result.append(IX);
            return result.toString();
        }
        if(numericValue>=5){
            result.append(V);
            numericValue-=5;
        }
        if(numericValue>3){
            result.append(IV);
            numericValue-=4;
        }
        while(numericValue>0){
            result.append(I);
            numericValue-=1;
        }

        return result.toString();
    }


}
