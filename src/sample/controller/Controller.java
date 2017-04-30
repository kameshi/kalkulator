package sample.controller;

import com.sun.org.apache.xalan.internal.xsltc.dom.CachedNodeListIterator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sample.calculations.Calculations;

public class Controller {

    @FXML
    public TextArea textArea;
    public TextArea text = textArea;
    public String tekst = "vdfvs";
    public String fd = tekst;

    public int number;
    private int i;
    private Calculations calculations = new Calculations();


    @FXML
    public void mouseClicked()
    {
        textArea.setText(calculations.pasteNumber());
    }

    @FXML
    public void logarithmOnA()
    {
        textArea.setText(calculations.logarithm());
    }

    @FXML
    public void deleteOnA()
    {
        calculations.delete();
    }

    @FXML
    public void divisionOnA()
    {
        textArea.setText(calculations.whatCharacter(4));
    }

    @FXML
    public void deleteAllOnA()
    {
        calculations.deleteAll();
    }

    @FXML
    public void backspaceOnA()
    {
        calculations.backspace();
    }

    @FXML
    public void secondPowerOnA()
    {
        textArea.setText(calculations.secondPower());
    }

    @FXML
    public void multiOnA()
    {
        textArea.setText(calculations.whatCharacter(3));
    }

    @FXML
    public void strongOnA()
    {
        textArea.setText(calculations.strong());
    }

    @FXML
    public void minusOnA()
    {
        textArea.setText(calculations.whatCharacter(2));
    }

    @FXML
    public void plusOnA()
    {
        textArea.setText(calculations.whatCharacter(1));
    }

    @FXML
    public void equalOnA()
    {
        textArea.setText(calculations.amount());
    }

    @FXML
    public void negativeOnA()
    {
        calculations.changeSign();
    }

    @FXML
    public void leftBracketOnA()
    {

    }

    @FXML
    public void rightBracketOnA()
    {

    }

    @FXML
    public void pointOnA()
    {
        calculations.point();
    }

    @FXML
    public void zeroOnA()
    {
       calculations.addNextNumber(0);
    }

    @FXML
    public void oneOnA()
    {
        calculations.addNextNumber(1);
    }

    @FXML
    public void twoOnA()
    {
        calculations.addNextNumber(2);
    }

    @FXML
    public void threeOnA()
    {
        calculations.addNextNumber(3);
    }

    @FXML
    public void fourOnA()
    {
        calculations.addNextNumber(4);
    }

    @FXML
    public void fiveOnA()
    {
        calculations.addNextNumber(5);
    }

    @FXML
    public void sixOnA()
    {
        calculations.addNextNumber(6);
    }

    @FXML
    public void sevenOnA()
    {
        calculations.addNextNumber(7);
    }

    @FXML
    public void eightOnA()
    {
        calculations.addNextNumber(8);
    }

    @FXML
    public void nineOnA()
    {
        calculations.addNextNumber(9);
    }
}
