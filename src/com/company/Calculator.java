package com.company;

import java.util.TreeMap;

public class Calculator
{
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public  void Calculate(int firstOperator, int secondOperator, char _operator,boolean roman) throws Exception
    {
        int result = 0;
        System.out.println("first " + firstOperator );
        System.out.println("second " + secondOperator );
        System.out.println("operator " + _operator );
        switch(_operator)
        {
            case '+':
                result = firstOperator+secondOperator;
                break;
            case '-':
                result = firstOperator - secondOperator;
                break;
            case '*':
                result = firstOperator * secondOperator;
                break;
            case '/':
                result = firstOperator / secondOperator;
                break;

        }
        if(roman)
        {
            if (result < 1)
            {
                throw new Exception("This result < 1");
            }
            System.out.println("calc result = " + DecToRoman(result));
        }

        else System.out.println("calc result = "+ result);
    }

    public  static String DecToRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l )
        {
            return map.get(number);
        }
        return map.get(l) + DecToRoman(number-l);
    }
}
