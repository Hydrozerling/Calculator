package com.company;

public class StringParser {

    private String operands[];
    private String operators[];
    private int OperandOne = 0;
    private int OperandTwo = 0;
    private char operator;
    private boolean roman = false;
    String[] romanDigits = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    String[] Operators = {"+", "-", "*", "/"};

    public String scanString(String string) throws Exception {

        string = string.replaceAll("\\s+", "");
        operators = string.replaceFirst("^[0-9]+", "").replaceFirst("^[XVI]+", "").split("[0-9XVI]+");
        operands = string.replaceFirst("^[-+*/]+", "").split("[-+*/]+");


        if (operands.length != 2 || operators.length != 1)
        {
            throw new Exception("Input error");
        }
        else if (!checkElements(operands[0], operands[1], operators[0]))
        {
            throw new Exception("Check error");

        }
        else
        {
            Calculator calc = new Calculator();
            try
            {
                calc.Calculate(OperandOne, OperandTwo, operator, roman);
            }
            catch (Exception e)
            {
                throw new Exception(e.getMessage());
            }
        }
        return "Scanned";
    }




    public boolean checkOperator(String operator)
    {
        for (String op : Operators)
        {
            if(op.equals(operator))
                return true;
        }
        return false;
    }




    public  Boolean checkElements(String firstOperand,String secondOperand,String _operator)
    {


        if(!checkOperator(_operator))
        {
            //System.out.println("Check Error for operator");
            return false;
        }
        operator = _operator.charAt(0);
        //System.out.println("operator =  "+operator);
        if(isDigit(firstOperand))
        {
            if(isDigit(firstOperand) && isDigit(secondOperand))
            {
                OperandOne = Integer.parseInt(firstOperand);
                OperandTwo = Integer.parseInt(secondOperand);
                if(OperandOne > 10 ||OperandOne < 1 ||OperandTwo > 10||OperandTwo < 1 )
                    return false;
               // System.out.println("Checked");
                return true;
            }

        }

        if(isRoman(firstOperand))
        {
            if(isRoman(firstOperand) && isRoman(secondOperand))
            {
                roman = true;
                OperandOne = RomanToDec(firstOperand);
                OperandTwo = RomanToDec(secondOperand);
                return true;
            }
        }

        return false;
    }



    private int RomanToDec(String roman)
    {
        int i = 0;
        for (String digit : romanDigits)
        {
            i++;
            if(roman.equals(digit))
            {
                return i;
            }
        }
        return -1;
    }

  


    public  Boolean isRoman(String str) {
        for (String roman_digit : romanDigits)
        {
            if (roman_digit.equals(str))
            {

               // System.out.println("Roman");
                return true;
            }

        }
        return false;
    }




    public Boolean isDigit(String str)
    {
        try
        {
            Integer.parseInt(str);
            return  true;
        }
        catch (NumberFormatException e)
        {
           // System.out.println(e.getMessage());
            return  false;
        }
    }
}
