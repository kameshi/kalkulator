package sample.calculations;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static java.lang.Math.log;

/**
 * Created by Marek on 26.04.2017.
 */
public class Calculations {

    private double result = 0;
    private double firstNumber = 0 ;
    private int character = 0;
    private int iterator = 0;
    private String text = new String();
    DecimalFormat doubleFormat = new DecimalFormat("0");
    private int precision = 0;

    public Calculations()
    {
    }

    public static double pow(double number, int precyzja)
    {
        double number2 = number;
        for(int i = 0; i < precyzja ; i++)
        {
            number2 *= number;
        }
        return  number2;
    }


    public void addNextNumber(double digit)
    {
        if(character == 0 && result != 0 && firstNumber == 0)
        {
            text = "";
            result = 0;
            precision = 0;
        }
        if(precision == 0)
        {
            precision = -1;
        }
        if(precision < 0)
        {
            if(firstNumber >= 0)
            {
                this.firstNumber = firstNumber * 10 + digit;
            }
            else if(firstNumber < 0)
            {
                this.firstNumber = firstNumber * 10 - digit;
            }
        }
        else if(precision > 0)
        {

            if((firstNumber % 1) != 0)
            {
                precision++;
            }
            for(int i = 0; i < precision; i++)
            {
                digit /= 10;
            }
            if(firstNumber >= 0)
            {
                this.firstNumber = firstNumber + digit;
            }
            else if(firstNumber < 0)
            {
                this.firstNumber = firstNumber - digit;
            }
        }
    }

    private  double strong(double n)
    {
        if(n < 1)
        {
            return  1;
        }
        else
            return  n * strong(n - 1);
    }

    public  String strong()
    {
        if(character == 0)
        {
            if(firstNumber == 0 && result != 0)
            {
                if(result < 0 )
                {
                    result = 0;
                    return "Nieprawidłowe dane";
                }
                if((result % 1) == 0)
                {
                    text = "fact( " + doubleFormat.format(result) + ")\n";
                    result = strong(result);
                    text += doubleFormat.format(result);
                }
                else
                {
                    text = "fact( " + Double.toString(result) + ")\n";
                    result = strong(result);
                    text += Double.toString(result);
                }
            }
            else
            {
                if(firstNumber < 0 )
                {
                    firstNumber = 0;
                    result = 0;
                    precision = 0;
                    text = "";
                    return "Nieprawidłowe dane";
                }
                if(precision < 0 )
                {
                    text = "fact( " + doubleFormat.format(firstNumber) + " )\n";
                }
                else
                {
                    text = "fact( " + Double.toString(firstNumber) + " )\n";
                }
                result = strong(firstNumber);
                if((result % 1) == 0)
                {
                    text += doubleFormat.format(result);
                }
                else
                {
                    text += Double.toString(result);
                }
                firstNumber = 0;
                precision = 0;
            }
            return text;
        }
        else
        {
            return text + "\n" + doubleFormat.format(firstNumber);
        }
    }

    public String logarithm()
    {
        if(character == 0) {
            String text2 = new String();
            if (firstNumber == 0 && result != 0) {
                if ((result % 1) == 0) {
                    text2 = "log( " + doubleFormat.format(result) + ")\n";
                    result = log(result);
                    text2 += doubleFormat.format(result);
                    text = doubleFormat.format(result);
                } else {
                    text2 = "log( " + Double.toString(result) + ")\n";
                    result = log(result);
                    text2 += Double.toString(result);
                    text = Double.toString(result);
                }
            } else {
                if (precision < 0) {
                    text2 = "log( " + doubleFormat.format(firstNumber) + " )\n";
                } else {
                    text2 = "log( " + Double.toString(firstNumber) + " )\n";
                }
                result = log(firstNumber);
                if ((result % 1) == 0) {
                    text2 += doubleFormat.format(result);
                    text = doubleFormat.format(result);
                } else {
                    text2 += Double.toString(result);
                    text = Double.toString(result);
                }
                firstNumber = 0;
                precision = 0;
            }
            return text2;
        }
        else
        {
            return text + "\n" + doubleFormat.format(firstNumber);
        }
    }

    public String pasteNumber()
    {
        if(precision <= 0)
        {
            return  text + "\n" + doubleFormat.format(firstNumber);
        }
        return text + "\n" + Double.toString(firstNumber);
    }

    public void delete()
    {
        firstNumber = 0;
    }

    public void deleteAll()
    {
        firstNumber = 0;
        result = 0;
        iterator = 0;
        text = "";
    }

    public void point()
    {
        if(result != 0 && firstNumber == 0)
        {
            result =0;
            text = "";
        }
        if(precision <= 0 )
        {
            precision = 1;
        }
    }

    public void backspace()
    {
        if(precision == 0)
        {
            firstNumber = 0;
        }
        if(precision > 0)
        {
            precision--;
        }
        double number = (new BigDecimal(firstNumber).setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue());
        double pow = 0;
        if( number > firstNumber )
        {
            if(precision > 0)
            {
                pow = pow(0.1,precision-1);
                number -= pow;
            }
            else if(precision < 0)
            {
                pow = pow(10,precision *(-1) -1 );
                number -= pow;
            }
        }
        if(precision < 0)
        {
            pow = pow(10,precision *(-1) -1 );
            number /= pow;
        }
        firstNumber = number;
    }

    public String whatCharacter(int character)
    {
        if(firstNumber != 0) {
            if (this.character == 0) {
                result = firstNumber;
            } else if (this.character == 1) {
                result += firstNumber;
            } else if (this.character == 2) {
                result -= firstNumber;
            } else if (this.character == 3) {
                result *= firstNumber;
            } else if (this.character == 4) {
                result /= firstNumber;
            }
            if(precision <= 0)
            {
                text += doubleFormat.format(firstNumber);
            }
            else
            {
                text += Double.toString(firstNumber);
            }
            if (character == 1) {
                text += " + ";
            } else if (character == 2) {
                text += " - ";
            } else if (character == 3) {
                text += " * ";
            } else if (character == 4) {
                text += " / ";
            }
            this.character = character;
            firstNumber = 0;
            precision = 0;
        }

        if(this.character == 0)
        {
            if (character == 1) {
                text += " + ";
            } else if (character == 2) {
                text += " - ";
            } else if (character == 3) {
                text += " * ";
            } else if (character == 4) {
                text += " / ";
            }
            this.character = character;
        }
        return "\n" + Double.toString(result);
    }

    public void changeSign()
    {
        firstNumber *= -1;
    }

    public String secondPower()
    {
        if(character == 0)
        {
            String text2 = new String();
            if(firstNumber == 0 && result != 0)
            {
                if((result % 1) == 0)
                {
                    text2 = "sqr( " + doubleFormat.format(result) + ")\n";
                    result *= result;
                    text2 += doubleFormat.format(result);
                    text = doubleFormat.format(result);
                }
                else
                {
                    text2 = "sqr( " + Double.toString(result) + ")\n";
                    result *= result;
                    text2 += Double.toString(result);
                    text = Double.toString(result);
                }
            }
            else
            {
                if(precision < 0 )
                {
                    text2 = "sqr( " + doubleFormat.format(firstNumber) + " )\n";
                }
                else
                {
                    text2 = "sqr( " + Double.toString(firstNumber) + " )\n";
                }
                result = firstNumber * firstNumber;
                if((result % 1) == 0)
                {
                    text2 += doubleFormat.format(result);
                    text = doubleFormat.format(result);
                }
                else
                {
                    text2 += Double.toString(result);
                    text = Double.toString(result);
                }
                firstNumber = 0;
                precision = 0;
            }
            return text2;
        }
        else
        {
            return text + "\n" + doubleFormat.format(firstNumber);
        }
    }

    public String amount()
    {
        if(character == 1)
        {
            result += firstNumber;
        }
        else if(character == 2)
        {
            result -= firstNumber;
        }
        else if(character == 3)
        {
            result *= firstNumber;
        }
        else if(character == 4)
        {
            result /= firstNumber;
        }
        if(character == 0)
        {

            if(firstNumber == 0 && result != 0)
            {
                firstNumber = result;
                text = "";
            }
            else if( firstNumber != 0)
            {
                System.out.println(firstNumber);

                if(precision < 0)
                {
                    precision = 1;
                    return "\n" + doubleFormat.format(firstNumber);
                }
                else
                {
                    return "\n" + Double.toString(firstNumber);
                }
            }
        }
        firstNumber = 0;
        precision = 0;
        character = 0;
        if((result % 1) == 0)
        {
            text = doubleFormat.format(result);
        }
        else
        {
            text = Double.toString(result);
        }
        return "\n" + text;
    }

}
