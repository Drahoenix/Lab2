import javax.lang.model.util.ElementScanner14;
import javax.naming.ldap.InitialLdapContext;

/**
 * The Calculator class provides functionality for parsing input strings
 * that contain simple expressions and for computing the result of the
 * expression.
 *
 */

public class Calculator {
    public Calculator() {
        // Constructor does nothing
    }

    /**
     * Compute the result of the expression encoded in a sequence of tokens.
     * 
     * Here are the different cases:
     * 0 tokens: IllegalInputException: "Illegal Token Length"
     * 1 token:
     * "quit" (any casing): QuitException
     * All other cases: IllegalInputException: "Illegal Argument"
     * 2 tokens:
     * "-" and any number: return negative of number
     * "-" and not a number: IllegalInputException: "Illegal Argument"
     * other string and any string: IllegalInputException: "Illegal Operator"
     * 3 tokens:
     * number1, "+", number2: return sum of two numbers
     * number1, "/", zero: DivideByZeroException
     * number1, "/", not zero: return number1/number2
     * not a number, anything, anything: IllegalInputException: "Illegal Argument"
     * number1, anything, not a number: IllegalInputException: "Illegal Argument"
     * number1, not an operator, number2: IllegalInputException: "Illegal Operator"
     * 4 or more tokens: IllegalInputException: "Illegal Token Length"
     * 
     * Note: all numbers are integers
     * 
     * @param tokens The array of tokens to evaluate
     * @return int result of evaluating the expression
     * @throws CalculatorException If some form of error has been generated or
     *                             "quit" has been typed. Throws one of the several
     *                             child classes of CalculatorException
     *                             in order to give more information on what the
     *                             error is.
     */
    public static int compute(String[] tokens) throws CalculatorException {
        // Condition on the number of tokens
        switch (tokens.length) {
            case 0:
                // TODO: complete the cases

                throw new IllegalInputException();
            case 1:
                // Only case: quit
                // TODO: complete the cases

                if (tokens[0].equals("quit"))
                    throw new QuitException();
                else
                    throw new IllegalInputException();

            case 2:
                // Only case: unary operator
                // TODO: complete the cases

                int value = Integer.valueOf(tokens[1]);
                if (tokens[0] == "-" && value > 0)
                    return value * -1;

            case 3:
                // Binary operator
                // TODO: complete the cases
                int value1 = Integer.valueOf(tokens[0]);
                int value2 = Integer.valueOf(tokens[2]);
                if (tokens[1].equals("*")) {
                    return value1 * value2;
                } else if (tokens[1].equals("/")) {
                    if (value1 == 0 && value2 == 0)
                        throw new DivideByZeroException();
                    else
                        return value1 / value2;
                } else if (tokens[1].equals("+")) {
                    return value1 + value2;
                } else if (tokens[1].equals("-")) {
                    return value1 - value2;
                } else
                    throw new IllegalInputException();

            default:
                // 4 or more tokens
                // TODO: complete the cases
                throw new IllegalInputException();
        }

    }

    /**
     * Parse the input string as an expression and evaluate it.
     * 
     * If the input is a legal expression, then the result is printed
     * 
     * Otherwise a CalculatorException has occurred. Print a message based on
     * what exception type it is.
     * 
     * Always print out what the input was. Use a finally block for this.
     * 
     * Always prints out two lines, following the rules:
     * 1st line:
     * -No Exception: "The result is: " + result
     * -QuitException: "Quitting"
     * -DivideByZeroException: "Tried to divide by zero"
     * -IllegalInputException: "Illegal input: " + illegalinputtype(given to
     * constructor)
     * -CalculatorException: <should never happen> e.getMessage()
     * 2nd line:
     * "Input was: " + input
     * 
     * @param input A String possibly containing a mathematical expression
     * @return true if the String is equal to "quit"; false otherwise
     */
    public static boolean parseAndCompute(String input) {
        // Pull out the tokens
        String[] tokens = input.split(" ");
        int result;
        try {
            // TODO: complete implementation.
            result = compute(tokens);
            System.out.println("result is " + result);
        } catch (QuitException e) {
            // TODO: complete implementation.
            if (tokens[0] == "Quit")
                return true;
        } catch (IllegalInputException e) {
            // TODO: complete implementation.
            System.out.println("Illegal Token Length");
        } catch (CalculatorException e) {
            // This catches the remaining CalculatorException case: DivideByZeroException
            // TODO: complete implementation.
            System.out.println("Cannot divide by 0!");
        }

        // TODO: complete implementation.
        System.out.println("Input was" + input);
        // Quit has not been specified
        return false;
    }
}
