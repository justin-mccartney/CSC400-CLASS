import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class PostfixCalculator {
    public static void main(String[] args) {
        // Creating a new scanner, and having the scanner read the coming input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word 'file' to enter a file, or 'expression' to enter a single expression: ");
        String choice = scanner.nextLine().trim().toLowerCase();

        // Options for next steps depending on users first input
        // Deciphering whether the program is to read from a file - or a directly input expression
        if(choice.equals("file")) { // File input route
            System.out.println("Enter the name of a file containing postfix expressions: ");
            String filename = scanner.nextLine();
            try {
                processFile(filename);
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if(choice.equals("expression")) { // Direct expression route
            System.out.println("Enter a postfix expression (separate each element using a space): ");
            String expression = scanner.nextLine();
            try {
                double result = evaluatePostfix(expression);
                System.out.println("Result: " + result);
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else { // Relief case, if the user enters an improper input
            System.out.println("Invalid Input. Please enter the word 'file' for file input, or 'expression' to " +
                    "input a single expression.");
        }
    }

    // Handling the user entering a file of expressions
    // Takes in the filename in order to locate the desired file
    public static void processFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);

        // Reading in from the file in order to solve the given expressions
        while(fileScanner.hasNextLine()) {
            String expression = fileScanner.nextLine();
            try {
                double result = evaluatePostfix(expression); // Calling upon the evaluator functional
                System.out.println("Expression: " + expression + " ==> Result: " + result);
            } catch(Exception e) {
                System.out.println("Expression: " + expression + " ==> Error: " + e.getMessage());
            }
        }
        fileScanner.close();
    }

    // The evaluation function that will be used to solve the expression
    // Takes in the postfix expression to be solved
    // Returns the result of the evaluated expression - of an exception if the token is invalid
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

    // Deciphering which token is being used - taking in the token from the expression at hand
    // Returning true if the token is valid, and false if the token is not among the list
    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%");
    }

    // Applies the operator properly based on the deciphered token
    // Takes in all components of the expression to be solved
    // Returns the solved expression - or an exception if the criteria within the expression are not met
    public static double applyOperator(String operator, double a, double b) throws Exception {
        switch(operator) {
            case "+":
                return a + b; // Addition will be done if the plus symbol is present
            case "-":
                return a - b; // Subtraction will be done if the minus symbol is present
            case "*":
                return a * b; // Multiplication will be done if the asterisk is present
            case "/":
                if(b == 0) {
                    throw new Exception("Division by zero");
                }
                return a / b; // Division will be done if the backslash is present - or exception will be thrown
                                // if 'b = 0'
            case "%":
                if(b == 0) {
                    throw new Exception("Division by zero");
                }
                return a % b; // Modulo division will be done if the percent symbol is present - or exception will
                                // be thrown if 'b = 0'
            default:
                throw new Exception("Invalid operator: " + operator);
        }
    }
}
