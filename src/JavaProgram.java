import java.awt.*;
import java.awt.event.*;

public class JavaProgram {
    public static void main(String[] args) {

        Frame f = new Frame("Mini calculator");

        f.setVisible(true);
        f.setSize(500,300);
        f.setLocationRelativeTo(null);
        f.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
        TextField tf1, tf2, tf3;

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        LayoutManager layOut = new GridLayout(5, 1);
        f.setLayout(layOut);
        GridBagConstraints c;

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        Label firstNumber = new Label("enter first number");
        f.add(firstNumber);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        tf1 = new TextField("",20);
        tf1.setBackground(Color.lightGray);
        f.add(tf1, c);
        f.add(tf1);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        Label chooseOperation = new Label("choose operation");
        f.add(chooseOperation, c);
        f.add(chooseOperation);


        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        Choice operand = new Choice();
        operand.add("+");
        operand.add("-");
        operand.add("*");
        operand.add("/");
        operand.setBackground(Color.pink);
        operand.setPreferredSize(new Dimension(200,50));
        f.add(operand, c);
        f.add(operand);


        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        Label secondNumber = new Label("enter second number");
        f.add(secondNumber, c);
        f.add(secondNumber);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        tf2 = new TextField("",20);
        tf2.setBackground(Color.lightGray);
        f.add(tf2, c);
        f.add(tf2);


        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        Label free = new Label(" ");
        f.add(free, c);
        f.add(free);


        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 3;
        Button calculate = new Button("Calculate");
        f.add(calculate, c);
        f.add(calculate);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 4;
        Label result = new Label("result is");
        result.setBackground(Color.pink);
        f.add(result, c);
        f.add(result);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 4;
        tf3 = new TextField("",20);
        tf3.setEditable(false);
        f.add(tf3, c);
        f.add(tf3);


        f.setSize(500, 300);
        f.setVisible(true);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String operandString1 = tf1.getText();
                String operandString2 = tf2.getText();
                try {
                    float operand1 = Float.parseFloat(operandString1);
                    float operand2 = Float.parseFloat(operandString2);
                    float result = 0;

                    char operationSymbol = operand.getSelectedItem().charAt(0);
                    if (operationSymbol == '+') {
                        result = operand1 + operand2;
                    } else if (operationSymbol == '-') {
                        result = operand1 - operand2;
                    } else if (operationSymbol == '*') {
                        result = operand1 * operand2;
                    } else if (operationSymbol == '/') {
                        result = operand1 / operand2;
                    }

                    tf3.setText(String.valueOf(result));
                }
                catch(NumberFormatException ex){
                    tf3.setText("Unul din operanzi nu este numar!");
                }
            }
        });
    }


}


