package java17features.demo;

import java.util.List;

/**
 * Author   : rajgs
 * Date     : 25 Sept 2026
 * Time     : 9:25:50 am
 * Project  : AdvancedJava
 * 
 * ================================================================
 * JAVA 17 - MODERN SYNTAX AND DATA MODELING
 * ================================================================
 *
 * Topics Covered:
 *
 * 1. var - Local Variable Type Inference
 * 2. Text Blocks
 * 3. Records
 * 4. Switch Expressions
 * 5. Pattern Matching for instanceof
 * ================================================================
 */

public class Java17ModernSyntaxDemo {

	public static void main(String[] args) {
		
		System.out.println("==============================================");
		System.out.println(" JAVA 17 - MODERN SYNTAX & DATA MODELING");
		System.out.println("==============================================");

		varDemo();
		textBlockDemo();
		switchExpressionDemo();
		patternMatchingDemo();

	}
	
	// ============================================================
    // 1. var - LOCAL VARIABLE TYPE INFERENCE
    // ============================================================
    /*
     * NOTES:
     *
     * Java 10 introduced 'var'.
     *
     * var allows the compiler to automatically determine the
     * data type of a local variable from its assigned value.
     *
     * IMPORTANT:
     * var does NOT mean Java becomes dynamically typed.
     * Java is still statically typed.
     *
     * Example:
     *     var name = "Raj";
     *
     * Compiler understands:
     *     String name = "Raj";
     *
     * Another example:
     *     var salary = 75000.50;
     *
     * Compiler understands:
     *     double salary = 75000.50;
     *
     * SYNTAX:
     *
     *     var variableName = value;
     *     var can be used for:
     *
     *     - Local variables
     *     - Variables inside loops
     *     - Variables inside methods
     *
     * var cannot be used for:
     *
     *     - Instance variables
     *     - Method parameters
     *     - Method return types
     *
     * ============================================================
     */

    static void varDemo() {
        System.out.println("\n1. var - LOCAL VARIABLE TYPE INFERENCE");
        System.out.println("--------------------------------------");

        var employeeId = 101;
        var employeeName = "Raj";
        var salary = 75000.50;
        var employees =List.of("Raj", "Rahul", "Priya");

        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Salary        : " + salary);
        System.out.println("Employees     : " + employees);
    }
    
 // ============================================================
    // 2. TEXT BLOCKS
    // ============================================================
    /*
     * NOTES:
     *
     * Text Blocks provide a convenient way to represent
     * multi-line String values.
     *
     * They are particularly useful for:
     *
     *     - JSON
     *     - HTML
     *     - XML
     *     - SQL
     *     - Multi-line messages
     *
     * OLD APPROACH:
     *
     * String json =
     *     "{\n" +
     *     "  \"id\": 101,\n" +
     *     "  \"name\": \"Raj\"\n" +
     *     "}";
     *
     * TEXT BLOCK:
     *
     * String json = """
     * {
     *   "id": 101,
     *   "name": "Raj"
     * }
     * """;
     *
     * SYNTAX:
     *
     *     String variable = """
     *     multiple
     *     lines
     *     """;
     * ============================================================
     */

    static void textBlockDemo() {

        System.out.println("\n2. TEXT BLOCKS");
        System.out.println("--------------------------------------");

        String employeeJson = """
                {
                    "employeeId": 101,
                    "name": "Raj",
                    "department": "IT",
                    "salary": 75000
                }
                """;

        System.out.println(employeeJson);

        String sql = """
                SELECT employee_id,
                       employee_name,
                       salary
                FROM employee
                WHERE salary > 50000
                ORDER BY salary DESC
                """;

        System.out.println("SQL:");
        System.out.println(sql);
    }
    
 // ============================================================
    // 4. SWITCH EXPRESSIONS
    // ============================================================
    /*
     * NOTES:
     *
     * Java introduced switch expressions to make switch more
     * concise and allow switch to return a value.
     *
     * Traditional switch:
     *
     * int result;
     *
     * switch (day) {
     *
     *     case 1:
     *         result = 100;
     *         break;
     *
     *     case 2:
     *         result = 200;
     *         break;
     *
     *     default:
     *         result = 0;
     * }
     *
     * Modern switch expression:
     *
     * int result = switch (day) {
     *
     *     case 1 -> 100;
     *     case 2 -> 200;
     *     default -> 0;
     * };
     *
     * Advantages:
     *
     *     - Less code
     *     - No break required
     *     - Can return a value
     *     - Prevents accidental fall-through
     * ============================================================
     */

    static void switchExpressionDemo() {

        System.out.println("\n4. SWITCH EXPRESSIONS");
        System.out.println("--------------------------------------");

        int grade = 2;

        String result = switch (grade) {

            case 1 -> "Excellent";
            case 2 -> "Very Good";
            case 3 -> "Good";
            case 4 -> "Average";
            default -> "Invalid Grade";
        };
        System.out.println("Result: " + result);


        int day = 5;

        String dayName = switch (day) {

            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid Day";
        };

        System.out.println("Day: " + dayName);
    }
    
    // ============================================================
    // 5. PATTERN MATCHING FOR instanceof
    // ============================================================
    /*
     * NOTES:
     *
     * Before pattern matching:
     *
     *     if (obj instanceof String) {
     *
     *         String value = (String) obj;
     *
     *         System.out.println(value.length());
     *     }
     *     
     * Modern syntax:
     *
     *     if (obj instanceof String value) {
     *
     *         System.out.println(value.length());
     *     }
     *
     * Pattern matching combines:
     *
     *     1. Type checking
     *     2. Type casting
     *     3. Variable declaration
     *
     * SYNTAX:
     *
     *     if (object instanceof Type variable) {
     *
     *         // use variable
     *     }
     * ============================================================
     */

    static void patternMatchingDemo() {

        System.out.println("\n5. PATTERN MATCHING - instanceof");
        System.out.println("--------------------------------------");

        Object value = "Java 17 Programming";

        if (value instanceof String text) {
        	System.out.println("String value : " + text);
            System.out.println("Length       : " + text.length());
            System.out.println("Upper Case   : "+ text.toUpperCase());
        }

        Object number = 100;
        if (number instanceof Integer n) {
        	System.out.println("Integer value: " + n);
            System.out.println("Square: " + (n * n));
        }
    }
}
