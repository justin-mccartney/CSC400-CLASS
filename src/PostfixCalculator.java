import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class PostfixCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word 'file' to enter a file, or 'expression' to enter a single expression: ");
        String choice = scanner.nextLine().trim().toLowerCase();

        if(choice.equals("file")) {
            System.out.println("Enter the name of a file containing postfix expressions: ");
            String filename = scanner.nextLine();
            try {
                processFile(filename);
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if(choice.equals("expression")) {
            System.out.println("Enter a postfix expression (separate each element using a space): ");
            String expression = scanner.nextLine();
            try {
                double result = evaluatePostfix(expression);
                System.out.println("Result: " + result);
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid Input. Please enter the word 'file' for file input, or 'expression' to " +
                    "input a single expression.");
        }
    }

    public static void processFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);

        while(fileScanner.hasNextLine()) {
            String expression = fileScanner.nextLine();
            try {
                double result = evaluatePostfix(expression);
                System.out.println("Expression: " + expression + " ==> Result: " + result);
            } catch(Exception e) {
                System.out.println("Expression: " + expression + " ==> Error: " + e.getMessage());
            }
        }
        fileScanner.close();
    }

    public static double evaluatePostfix(String expression) throws Exception {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for(String token : tokens) {
            if(isOperator(token)) {
                if(stack.size() < 2) {
                    throw new Exception("Error: not enough operands");
                }
                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperator(token, a, b);
                stack.push(result);
            } else {
                try {
                    double number = Double.parseDouble(token);
                    stack.push(number);
                } catch (NumberFormatException e) {
                    throw new Exception("Error: invalid token = " + token);
                }
            }
        }

        if(stack.size() != 1) {
            throw new Exception("Invalid Expression: too many operands");
        }

        return stack.pop();
    }

    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%");
    }

    public static double applyOperator(String operator, double a, double b) throws Exception {
        switch(operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if(b == 0) {
                    throw new Exception("Division by zero");
                }
                return a / b;
            case "%":
                if(b == 0) {
                    throw new Exception("Division by zero");
                }
                return a % b;
            default:
                throw new Exception("Invalid operator: " + operator);
        }
    }
}
