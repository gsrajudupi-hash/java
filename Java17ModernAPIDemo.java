/*
 * ================================================================
 * JAVA 17 - MODERN APIs AND DEVELOPER PRODUCTIVITY
 * ================================================================
 *
 * Topics:
 *
 * 1. Stream.toList()
 * 2. HexFormat
 * 3. RandomGenerator
 * 4. Private Methods in Interfaces
 * 5. Enhanced NullPointerException
 * 6. java.time API
 *
 * ================================================================
 */
package java17features.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;
import java.util.HexFormat;
import java.util.List;
import java.util.random.RandomGenerator;

public class Java17ModernAPIDemo {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println(" JAVA 17 - MODERN APIs");
        System.out.println("==============================================");

        streamToListDemo();

        hexFormatDemo();

        randomGeneratorDemo();

        privateInterfaceMethodDemo();

        dateTimeDemo();

        helpfulNullPointerExceptionDemo();
    }


    // ============================================================
    // 1. Stream.toList()
    // ============================================================

    /*
     * NOTES:
     *
     * Java 16 introduced Stream.toList().
     *
     * It provides a simple way to collect Stream results into
     * a List.
     *
     *
     * OLD APPROACH:
     *
     *     List<String> result =
     *
     *         employees.stream()
     *
     *             .filter(name ->
     *                 name.startsWith("R"))
     *
     *             .collect(Collectors.toList());
     *
     *
     * MODERN:
     *
     *     List<String> result =
     *
     *         employees.stream()
     *
     *             .filter(name ->
     *                 name.startsWith("R"))
     *
     *             .toList();
     *
     *
     * SYNTAX:
     *
     *     stream.toList();
     *
     * ============================================================
     */

    static void streamToListDemo() {

        System.out.println("\n1. STREAM.toList()");
        System.out.println("--------------------------------------");

        List<String> employees =
                List.of(
                        "Raj",
                        "Rahul",
                        "Priya",
                        "Ravi",
                        "Anita"
                );

        List<String> result =
                employees.stream()
                        .filter(name ->name.startsWith("R"))
                        .toList();

        System.out.println("Employees starting with R:");
        System.out.println(result);
    }

    // ============================================================
    // 2. HexFormat
    // ============================================================

    /*
     * NOTES:
     *
     * Java 17 introduced HexFormat.
     * It provides a convenient API for converting between:
     *
     *     byte[] and hexadecimal String
     *
     * Useful for:
     *     - Hash values
     *     - Cryptographic applications
     *     - Network programming
     *     - Binary data
	 * 
     * SYNTAX:
     *
     *     HexFormat hex = HexFormat.of();
     *
     *     String result =hex.formatHex(bytes);
     *
     *     byte[] bytes =hex.parseHex(value);
     *
     * ============================================================
     */

    static void hexFormatDemo() {

        System.out.println("\n2. HEXFORMAT");
        System.out.println("--------------------------------------");

        HexFormat hex =HexFormat.of();

        byte[] data = {

                10,
                20,
                30,
                40,
                50
        };

        String hexadecimal =hex.formatHex(data);


        System.out.println("Hexadecimal: "+ hexadecimal);


        byte[] converted =hex.parseHex(hexadecimal);

        System.out.println(
                "Converted Bytes: "+ Arrays.toString(converted));
    }


    // ============================================================
    // 3. RANDOM GENERATOR
    // ============================================================

    /*
     * NOTES:
     *
     * Java 17 introduced the java.util.random package.
     *
     * RandomGenerator provides a common API for random number
     * generation algorithms.
     *
     * SYNTAX:
     *
     *     RandomGenerator generator =
     *         RandomGenerator.getDefault();
     *
     *     int number =
     *         generator.nextInt(1, 101);
     *
     * Useful for:
     *
     *     - Random numbers
     *     - OTP generation
     *     - Test data
     *     - Simulations
     *
     * ============================================================
     */

    static void randomGeneratorDemo() {

        System.out.println("\n3. RANDOM GENERATOR API");
        System.out.println("--------------------------------------");

        RandomGenerator generator =
                RandomGenerator.getDefault();

        int randomNumber =generator.nextInt(1, 101);

        System.out.println("Random Number: "+ randomNumber);


        int otp =generator.nextInt(100000,1000000);

        System.out.println("6 Digit OTP: "+ otp);
    }

    // ============================================================
    // 4. PRIVATE METHODS IN INTERFACES
    // ============================================================

    /*
     * NOTES:
     *
     * Java 9 introduced private methods inside interfaces.
     *
     * They are useful when multiple default methods need to
     * share common logic.
     *
     * A private interface method:
     *
     *     - Cannot be accessed outside the interface
     *     - Cannot be overridden
     *     - Can be called by default/static methods
     *
     * Example:
     *
     *     interface PaymentService {
     *         default void pay() {
     *
     *             validate();
     *
     *             System.out.println(
     *                 "Payment completed");
     *         }
     *
     *         private void validate() {
     *
     *             System.out.println(
     *                 "Validation");
     *         }
     *     }
     *
     * ============================================================
     */

    interface PaymentService {

        default void makePayment() {

            validatePayment();
            System.out.println("Payment completed");
        }


        private void validatePayment() {
            System.out.println("Payment validation completed");
        }
    }

    static class PaymentServiceImpl implements PaymentService {
    }


    static void privateInterfaceMethodDemo() {

        System.out.println("\n 4. PRIVATE METHODS IN INTERFACES");

        System.out.println( "--------------------------------------");


        PaymentService service =new PaymentServiceImpl();
        
        service.makePayment();
    }


    // ============================================================
    // 5. JAVA TIME API
    // ============================================================

    /*
     * NOTES:
     *
     * java.time was introduced in Java 8 and is the recommended
     * date/time API for modern Java applications.
     *
     *
     * Important classes:
     *
     *     LocalDate
     *     LocalTime
     *     LocalDateTime
     *     ZonedDateTime
     *     Period
     *     Duration
     *
     *
     * Advantages:
     *
     *     - Immutable
     *     - Thread-safe
     *     - Easier to use
     *
     * ============================================================
     */

    static void dateTimeDemo() {

        System.out.println("\n5. JAVA TIME API");
        System.out.println("--------------------------------------");


        LocalDate today =LocalDate.now();


        LocalDate joiningDate =
                LocalDate.of(
                        2020,
                        1,
                        10);


        LocalDateTime currentDateTime =LocalDateTime.now();
        Period experience =Period.between(joiningDate,today);

        System.out.println("Today: " + today);

        System.out.println("Current Date & Time: "+ currentDateTime);


        System.out.println("Years of Experience: "+ experience.getYears());
    }

    // ============================================================
    // 6. HELPFUL NullPointerException
    // ============================================================

    /*
     * NOTES:
     *
     * Modern Java provides more descriptive
     * NullPointerException messages.
     *
     * This is a JVM improvement rather than a new syntax.
     *
     * Example:
     *
     *     employee.getDepartment().getName();
     *
     * If employee is null, Java can provide information about
     * which expression caused the problem.
     *
     * This is especially useful when debugging large applications.
     *
     * No special syntax is required.
     *
     * ============================================================
     */

    static void helpfulNullPointerExceptionDemo() {

        System.out.println("\n6. HELPFUL NullPointerException");

        System.out.println( "--------------------------------------");

        Employee employee = null;

        try {

            /*
             * This intentionally causes a
             * NullPointerException.
             *
             * Java provides a more useful error
             * message in modern versions.
             */

            System.out.println(
                    employee.getName());

        } catch (NullPointerException e) {

            System.out.println( "Exception Message:");

            System.out.println( e.getMessage());
        }
    }


    // Simple class used for the NPE example
    static class Employee {

        private String name;
        
        public String getName() {

            return name;
        }
    }
}