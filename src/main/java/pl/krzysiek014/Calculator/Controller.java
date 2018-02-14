package pl.krzysiek014.Calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

/**
 * Created by Krzysiek014 on 14.02.2018.
 */
public class Controller{

    @FXML
    private Button one,two,three,four,five,six, seven, eight, nine, zero;
    @FXML
    private Button multiple, add, subtract, divide, percent, sqrt, plusMin, equals, dot, ce;
    @FXML
    private TextField lcd;

    private String operator = "-1";
    private BigDecimal firstNumber = BigDecimal.ZERO;

    public void initialize(){

        // Numbers functionality
        one.setOnMouseClicked(e-> check(1));
        two.setOnMouseClicked(e-> check(2));
        three.setOnMouseClicked(e-> check(3));
        four.setOnMouseClicked(e-> check(4));
        five.setOnMouseClicked(e-> check(5));
        six.setOnMouseClicked(e-> check(6));
        seven.setOnMouseClicked(e-> check(7));
        eight.setOnMouseClicked(e-> check(8));
        nine.setOnMouseClicked(e-> check(9));
        zero.setOnMouseClicked(e-> check(0));


        // Calculator functions
        ce.setOnMouseClicked(e->{
            clear();
            lcd.setText("0");
        });
        dot.setOnMouseClicked(e-> lcd.setText(lcd.getText()+"."));
        plusMin.setOnMouseClicked(e->{
            if(lcd.getText().contains(".")){
                lcd.setText(-Double.valueOf(lcd.getText()) + "");
            }else{
                lcd.setText(-Integer.valueOf(lcd.getText()) + "");
            }
        });
        sqrt.setOnMouseClicked(e->{
            if(Double.valueOf(lcd.getText())<0){
                System.err.println("Number must be bigger than 0");
                lcd.setText("0");
            }else {
                lcd.setText(Math.sqrt(Double.valueOf(lcd.getText())) + "");
            }
            clear();
        });


        // Calculator operations
        add.setOnMouseClicked(e->{
            gitfirst();
            operator = "+";
        });
        divide.setOnMouseClicked(e->{
            gitfirst();
            operator = "/";
        });
        multiple.setOnMouseClicked(e->{
            gitfirst();
            operator = "*";
        });
        subtract.setOnMouseClicked(e->{
            gitfirst();
            operator = "-";
        });
        percent.setOnMouseClicked(e->{
            BigDecimal secondNumber = new BigDecimal(lcd.getText());
            if(operator.equals("*"))
                lcd.setText(firstNumber.multiply(secondNumber).divide(BigDecimal.valueOf(100)).toString());
        });
        equals.setOnMouseClicked(e->{
            BigDecimal secondNumber = new BigDecimal(lcd.getText());
            switch (operator){

                case "+":
                    lcd.setText(firstNumber.add(secondNumber).toString());
                    break;
                case "-":
                    lcd.setText(firstNumber.subtract(secondNumber).toString());
                    break;
                case "/":
                    try {
                        lcd.setText(firstNumber.divide(secondNumber).toString());
                    }catch(ArithmeticException ae){
                        System.err.println("Cannot divide by zero");
                        lcd.setText("0");
                    }
                    break;
                case "*":
                    lcd.setText(firstNumber.multiply(secondNumber).toString());
                    break;
            }
            clear();
        });

    }

    private void check(int num){
        if(!lcd.getText().contains(".")) {
            lcd.setText(Integer.valueOf(lcd.getText() + num) + "");
        }else{
            lcd.setText(Double.valueOf(lcd.getText() + num) + "");
        }
    }

    private void clear(){
        firstNumber = BigDecimal.ZERO;
        operator="-1";
    }

    private void gitfirst(){
        firstNumber = new BigDecimal(lcd.getText());
        lcd.setText("0");
    }
}
