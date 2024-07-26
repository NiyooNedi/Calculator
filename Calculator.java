import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    //declaring variables for the outer frame of the calculator and its top field
    JFrame frame;
    JTextField textField;
    JPanel panel;

    //counter variable for the amount of times an operator button is clicked
    int counter = 0;

    //operator variables being declared
    JButton additionButton;
    JButton subtractButton;
    JButton multiplyButton;
    JButton divideButton;
    JButton decimalButton;
    JButton negativeButton;
    JButton equalsButton;
    JButton deleteButton;
    JButton clearButton;

    //creating arrays for the numbers and operators of the calculator
    JButton[] numbers = new JButton [10];
    JButton[] operators = new JButton [9];

    //figure out a different font to use
    Font myFont = new Font("PLAIN", Font.BOLD, 30);

    //variables for the numbers that the user will choose on the calculator and their result
    double firstNumber = 0;
    double secondNumber = 0;
    double result = 0;

    char operatorChar;
    
    //constructor for the calculator
    public Calculator(){

        //creating the frame for the calculator
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);

        //creating the field at the top of the calculator where numbers will appear
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //linking the operators to a button with its respective symbol
        additionButton = new JButton("+");
        subtractButton = new JButton("-");
        divideButton = new JButton("/");
        multiplyButton = new JButton("*");
        decimalButton = new JButton(".");
        negativeButton = new JButton("Neg.");
        deleteButton = new JButton("Delete");
        equalsButton = new JButton("=");
        clearButton = new JButton("Clear");

        //putting the operator buttons in the operator array
        operators[0] = additionButton;
        operators[1] = subtractButton;
        operators[2] = divideButton;
        operators[3] = multiplyButton;
        operators[4] = decimalButton;
        operators[5] = deleteButton;
        operators[6] = equalsButton;
        operators[7] = clearButton;
        operators[8] = negativeButton;

        //for loop that makes the operator buttons usable by the user
        for (int i = 0; i < 9; i++) {
            operators[i].addActionListener(this);
            operators[i].setFont(myFont);
        }

        //for loop that makes number buttons for each number from 0-9 and makes them usable by the user
        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(myFont);
        }

        //setting the position of the clear and delete buttons
        clearButton.setBounds(0, 430, 150, 50);
        deleteButton.setBounds(150, 430, 150, 50);
        negativeButton.setBounds(300, 430, 150, 50);

        //setting a panel for the number buttons
        panel = new JPanel();
        panel.setBounds(50,100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.LIGHT_GRAY);

        //adding the numbers and operators to the calculator
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(multiplyButton);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subtractButton);
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(additionButton);
        panel.add(equalsButton);
        panel.add(numbers[0]);
        panel.add(decimalButton);
        panel.add(divideButton);
        
        //adding all of the buttons and fields to the calculator frame and making it visible
        frame.add(panel);
        frame.add(textField);
        frame.add(negativeButton);
        frame.add(clearButton);
        frame.add(deleteButton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
    }

    //method that actually gives functionality to the buttons
    public void actionPerformed(ActionEvent buttonClicked){

        //making numbers appear in the text field when clicked
        if (buttonClicked.getSource() == numbers[0]) {

            textField.setText(textField.getText().concat("0"));
        }
        if (buttonClicked.getSource() == numbers[1]) {

            textField.setText(textField.getText().concat("1"));
        }
        if (buttonClicked.getSource() == numbers[2]) {

            textField.setText(textField.getText().concat("2"));
        }
        if (buttonClicked.getSource() == numbers[3]) {

            textField.setText(textField.getText().concat("3"));
        }
        if (buttonClicked.getSource() == numbers[4]) {

            textField.setText(textField.getText().concat("4"));
        }
        if (buttonClicked.getSource() == numbers[5]) {

            textField.setText(textField.getText().concat("5"));
        }
        if (buttonClicked.getSource() == numbers[6]) {

            textField.setText(textField.getText().concat("6"));
        }
        if (buttonClicked.getSource() == numbers[7]) {

            textField.setText(textField.getText().concat("7"));
        }
        if (buttonClicked.getSource() == numbers[8]) {

            textField.setText(textField.getText().concat("8"));
        }
        if (buttonClicked.getSource() == numbers[9]) {

            textField.setText(textField.getText().concat("9"));
        }
        

        //making the decimal appear in the textField
        if (buttonClicked.getSource() == decimalButton) {
                
            textField.setText(textField.getText().concat("."));
        }

        //clearing the textField when the clear button is clicked
        if (buttonClicked.getSource() == clearButton) {
                
            textField.setText("");
        }

        //adding the negative sign to the textField when the negative button is clicked
        if (buttonClicked.getSource() == negativeButton) {
                
            textField.setText("-");
        }

        //deleting the last number in the textField when the delete button is clicked
        if (buttonClicked.getSource() == deleteButton) {
                
            String Nums = textField.getText();
            textField.setText(Nums.substring(0, Nums.length() - 1));
        }
        
        //storing the first number inputted when the respective operator buttons are clicked, and then clearing the text field
        if (buttonClicked.getSource() == additionButton) {

            if (counter != 0){

                secondNumber = Double.parseDouble(textField.getText());
                firstNumber = firstNumber + secondNumber;
                textField.setText("");
                
            } else {
                
                firstNumber = Double.parseDouble(textField.getText());
                operatorChar = '+';
                textField.setText("");
                counter++;
            }
        }
        if (buttonClicked.getSource() == subtractButton) {
                
            if (counter != 0){

                secondNumber = Double.parseDouble(textField.getText());
                firstNumber = firstNumber - secondNumber;
                textField.setText("");
                
            } else {
                
                firstNumber = Double.parseDouble(textField.getText());
                operatorChar = '-';
                textField.setText("");
                counter++;
            }
        }
        if (buttonClicked.getSource() == multiplyButton) {
                
            if (counter != 0){

                secondNumber = Double.parseDouble(textField.getText());
                firstNumber = firstNumber * secondNumber;
                textField.setText("");
                
            } else {
                
                firstNumber = Double.parseDouble(textField.getText());
                operatorChar = '*';
                textField.setText("");
                counter++;
            }
        }
        if (buttonClicked.getSource() == divideButton) {
                
            if (counter != 0){

                secondNumber = Double.parseDouble(textField.getText());
                firstNumber = firstNumber / secondNumber;
                textField.setText("");
                
            } else {
                
                firstNumber = Double.parseDouble(textField.getText());
                operatorChar = '/';
                textField.setText("");
                counter++;
            }
        }

        //storing the second number when the equals button is clicked, and then doing the math to find the result of the operations
        if (buttonClicked.getSource() == equalsButton) {
                
            secondNumber = Double.parseDouble(textField.getText());
            
            //if statement determining which operator was clicked and doing the math depending on each one
            if (operatorChar == '+'){

                counter = 0; 
                result = firstNumber + secondNumber;

            } else if (operatorChar == '-') {

                counter = 0; 
                result = firstNumber - secondNumber;

            } else if (operatorChar == '*') {

                counter = 0; 
                result = firstNumber * secondNumber;

            } else if (operatorChar == '/') {

                counter = 0; 
                result = firstNumber / secondNumber;
            }

            //showing the result on the calculator and storing it
            textField.setText(String.valueOf(result));
            firstNumber = result;
       }

        
    }

}
