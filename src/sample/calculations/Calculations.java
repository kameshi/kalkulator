package sample.calculations;

/**
 * Created by Marek on 26.04.2017.
 */
public class Calculations {

    private double firstNumber = 0 ;
    private double secondNumber = 0;
    private double character = 0;
    private double lastNumber = 0;

    public Calculations()
    {
    }

    public void addNextNumber(double digit)
    {
        lastNumber = digit;
        if(firstNumber >= 0)
        {
            this.firstNumber = firstNumber * 10 + digit;
        }
        else if(firstNumber < 0)
        {
            this.firstNumber = firstNumber * 10 - digit;
        }
        System.out.println(digit + "  " + firstNumber);
    }

    public String pasteNumber()
    {
        return Double.toString(firstNumber);
    }

    public void delete()
    {
        firstNumber = 0;
        secondNumber = 0;
    }

    public void backspace()
    {
        firstNumber = (firstNumber - lastNumber) / 10;
    }

    public void whatCharacter(int character)
    {
        if(firstNumber != 0)
        {
            secondNumber = firstNumber;
            firstNumber = 0;
        }
        this.character = character;
    }

    public void changeSign()
    {
        firstNumber *= -1;
    }

    public String amount()
    {
        if(character == 1)
        {
            secondNumber = firstNumber + secondNumber;
        }
        else if(character == 2)
        {
            secondNumber = secondNumber - firstNumber;
        }
        else if(character == 3)
        {
            secondNumber = firstNumber * secondNumber;
        }
        else if(character == 4)
        {
            secondNumber = secondNumber / firstNumber;
        }
        else if(character == 0)
        {
            return Double.toString(firstNumber);
        }
        firstNumber = 0;
        character = 0;
        return Double.toString(secondNumber);
    }

}
