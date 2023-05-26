package p1;

import java.util.Stack;

public class Calculator{
    Stack<Double> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();
    String problem;
    double num1, num2;
    boolean isNegative = false;

    public void add(){
        operators.pop();
        num1 = operands.pop();
        num2 = operands.pop();
        operands.push(num1 + num2);
    }

    public void multiply(){
        operators.pop();
        num1 = operands.pop();
        num2 = operands.pop();
        operands.push(num1 * num2);
    }

    public void power(){
        operators.pop();
        num1 = operands.pop();
        num2 = operands.pop();
        operands.push(Math.pow(num2,num1));
    }

    public void subtract(){
        operators.pop();
        num1 = operands.pop();
        num2 = operands.pop();
        operands.push(num2 - num1);
    }

    public void divide(){
        operators.pop();
        num1 = operands.pop();
        num2 = operands.pop();
        operands.push(num2 / num1);
    }

    protected double evaluate(String problem){
        this.problem = problem;
        String num = "";
        double number = 0;
        char op;
        int i = 0, negCount = 0;
        
        while(i < problem.length()){
            if(Character.isDigit(problem.charAt(i)) || problem.charAt(i) == '.'){
                num += problem.charAt(i);
            }else{
                if(!num.equals("") && !num.equals("-")){
                number = Double.parseDouble(num);
                operands.push(number);
                }

                if(!num.equals("-")) {
                    num = "";
                }

                op = problem.charAt(i);

                switch(op){
                    case '(':
                        // Keep count of how many negatives there are
                        if(num.equals("-")){
                            isNegative = true;
                            negCount++;
                            num = "";
                        }
                        operators.push(op);
                        break;
                    case ')':
                        while(operators.peek() != '(') {
                            switch (operators.peek()) {
                                case '+':
                                    add();
                                    break;
                                case '*':
                                    multiply();
                                    break;
                                case '^':
                                    power();
                                    break;
                                case '-':
                                    subtract();
                                    break;
                                case '/':
                                    divide();
                                    break;
                            }
                        }
                        operators.pop();
                        if(isNegative){
                            number = operands.pop();
                            number *= -1;
                            operands.push(number);
                            negCount--;
                            if(negCount == 0) {
                                isNegative = false;
                            }
                        }
                        break;

                    case '+':
                        if(operators.isEmpty()){
                            operators.push(op);
                            break;
                        }

                        switch (operators.peek()){
                            case '(':
                                operators.push(op);
                                break;
                            case '^':
                                power();
                                operators.push(op);
                                break;
                            case '*':
                                multiply();
                                operators.push(op);
                                break;
                            case '/':
                                divide();
                                operators.push(op);
                                break;
                            case '+':
                                add();
                                operators.push(op);
                                break;
                            case '-':
                                subtract();
                                operators.push(op);
                                break;
                        }
                        break;

                    case '-':
                        num += '-';
                        if(operands.isEmpty()){
                            break;
                        }else if(num.equals("--")){
                            num="";
                            break;
                        }else if(operators.isEmpty() || problem.charAt(i-1) == ')'){
                            operators.push('+');
                            break;
                        }else if(Character.isDigit(problem.charAt(i-1))){
                            switch (operators.peek()){
                                case '(':
                                    operators.push('+');
                                    break;
                                case '^':
                                    power();
                                    operators.push('+');
                                    break;
                                case '*':
                                    multiply();
                                    operators.push('+');
                                    break;
                                case '/':
                                    divide();
                                    operators.push('+');
                                    break;
                                case '+':
                                    add();
                                    operators.push('+');
                                    break;
                                case '-':
                                    subtract();
                                    operators.push('+');
                                    break;
                            }
                            break;
                        }

                        break;

                    case '*':
                    case '/':
                        if(operators.isEmpty()){
                            operators.push(op);
                            break;
                        }

                        switch (operators.peek()){
                            case '(':
                            case '+':
                            case '-':
                                operators.push(op);
                                break;
                            case '^':
                                power();
                                operators.push(op);
                                break;
                            case '*':
                                multiply();
                                operators.push(op);
                                break;
                            case '/':
                                divide();
                                operators.push(op);
                                break;
                        }
                        break;

                    case '^':
                        if(operators.isEmpty()){
                            operators.push(op);
                            break;
                        }

                        switch (operators.peek()) {
                            case '(':
                            case '+':
                            case '-':
                            case '*':
                            case '/':
                                operators.push(op);
                                break;
                            case '^':
                                power();
                                operators.push(op);
                                break;
                        }
                        break;
                }
            }
            i++;
        }

        if(!num.equals("")){
            number = Double.parseDouble(num);
            operands.push(number);
        }

        while(!operators.isEmpty()) {
            switch (operators.peek()) {
                case '+':
                    add();
                    break;
                case '*':
                    multiply();
                    break;
                case '^':
                    power();
                    break;
                case '-':
                    subtract();
                    break;
                case '/':
                    divide();
                    break;
            }
        }

        return operands.pop();
    }
}
