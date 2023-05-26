package p1;

import java.util.EmptyStackException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculator myCalc = new Calculator();
        double answer = 0;

        for(;;) {
            System.out.print("Enter you expression here: ");
            String p = input.nextLine();

            answer = myCalc.evaluate(p);
            System.out.println(answer);
            System.out.println(myCalc.isNegative);


            /*try {
                answer = myCalc.evaluate(p);
                if (answer == Double.POSITIVE_INFINITY || answer == Double.NEGATIVE_INFINITY) {
                    throw new ArithmeticException();
                }
                if (!myCalc.operands.isEmpty()) {
                    throw new NumberFormatException();
                }
                System.out.println(answer);
            } catch (NumberFormatException | EmptyStackException nfe) {
                System.out.println("SYNTAX ERROR!");
                System.out.println("Make sure there is no spaces or incorrect characters in your expression!");
            } catch (ArithmeticException ae) {
                System.out.println("This is not a number! Check your expression to make sure you did not break any arithmetic rules");
            }*/
        }
    }
}
