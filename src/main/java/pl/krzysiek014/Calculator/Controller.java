package pl.krzysiek014.Calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Krzysiek014 on 14.02.2018.
 */
public class Controller{

    @FXML
    Button one,two,three,four,five,six, seven, eight, nine, zero;
    @FXML
    Button multiple, add, subtract, divide, percent, sqrt, plusMin, equals, dot, ce;
    @FXML
    TextField lcd;

    String operator = null;

//    Button[] listOfNumbers = new Button[]{one,two,three,four,five,six, seven, eight, nine, zero};
    public void initialize(){
        // Numbers functionality
        one.setOnMouseClicked(e->{
            check(1);
        });
        two.setOnMouseClicked(e->{
            check(2);
        });
        three.setOnMouseClicked(e->{
            check(3);
        });
        four.setOnMouseClicked(e->{
            check(4);
        });
        five.setOnMouseClicked(e->{
            check(5);
        });
        six.setOnMouseClicked(e->{
            check(6);
        });
        seven.setOnMouseClicked(e->{
            check(7);
        });
        eight.setOnMouseClicked(e->{
            check(8);
        });
        nine.setOnMouseClicked(e->{
            check(9);
        });
        zero.setOnMouseClicked(e->{
            check(0);
        });

        // Calculator functions
        ce.setOnMouseClicked(e->{
            lcd.setText("0");
        });
    }

    private void check(int num){
        if(operator!=null){

        }else{
            lcd.setText(Integer.valueOf(lcd.getText()+num)+"");
        }
    }
}
