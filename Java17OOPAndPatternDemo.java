package java17features.demo;

/**
 * Author   : rajgs
 * Date     : 25 Sept 2026
 * Time     : 9:36:32 am
 * Project  : AdvancedJava
 * ================================================================
 * JAVA 17 - MODERN OOP AND PATTERN MATCHING
 * ================================================================
 *
 * Topics:
 *
 * 1. Sealed Classes
 * 2. Sealed Interfaces
 * 3. final subclasses
 * 4. non-sealed subclasses
 * 5. Pattern Matching
 * 6. Pattern Matching with switch
 *
 * ================================================================
 */

public class Java17OOPAndPatternDemo {

	public static void main(String[] args) {
		
		System.out.println("==============================================");
        System.out.println(" JAVA 17 - MODERN OOP & PATTERN MATCHING");
        System.out.println("==============================================");

        sealedClassDemo();
        sealedInterfaceDemo();
        patternMatchingDemo();
       // patternSwitchDemo();

	}

	  // ============================================================
    // 1. SEALED CLASSES
    // ============================================================

    /*
     * NOTES:
     *
     * A sealed class restricts which classes can extend it.
     *
     * This gives developers control over inheritance.
     *
     * SYNTAX:
     *
     *     sealed class Parent
     *         permits Child1, Child2 {
     *     }
     *
     * A permitted child must be declared as:
     *
     *     final
     *     OR
     *     sealed
     *     OR
     *     non-sealed
     *
     * Why use sealed classes?
     *
     *     - Controlled inheritance
     *     - Better domain modeling
     *     - Improved type safety
     *     - Useful with pattern matching
     *
     * ============================================================
     */

    sealed static class Employee permits Manager, Developer {
        void work() {
            System.out.println("Employee is working");
        }
    }

    /*
     * final means:
     *
     * Manager cannot be extended further.
     */

    final static class Manager extends Employee {

        void manage() {
            System.out.println("Manager is managing the team");
        }
    }


    final static class Developer extends Employee {
    	
        void develop() {
            System.out.println("Developer is writing code");
        }
    }

    static void sealedClassDemo() {
        System.out.println("\n1. SEALED CLASS");
        System.out.println("--------------------------------------");

        Employee employee =new Manager();

        employee.work();
        
         if (employee instanceof Manager manager) 
            manager.manage();
        }
    
    // ============================================================
    // 2. SEALED INTERFACE
    // ============================================================
    /*
     * NOTES:
     *
     * Interfaces can also be sealed.
     *
     * SYNTAX:
     *
     *     sealed interface Payment
     *         permits CreditCardPayment,
     *                 UpiPayment {
     *     }
     *
     * This means only the permitted classes can implement
     * the Payment interface.
     *
     * ============================================================
     */

    sealed interface Payment permits CreditCardPayment,
            UpiPayment,
            CashPayment {
    }
 
    final static class CreditCardPayment implements Payment {

        void pay() {

            System.out.println("Payment using Credit Card");
        }
    }


    final static class UpiPayment implements Payment {

        void pay() {

            System.out.println( "Payment using UPI");
        }
    }


    final static class CashPayment implements Payment {

        void pay() {

            System.out.println("Payment using Cash");
        }
    }


    static void sealedInterfaceDemo() {

        System.out.println("\n2. SEALED INTERFACE");
        System.out.println("--------------------------------------");

        Payment payment =new CreditCardPayment();

        if (payment instanceof CreditCardPayment card) {

            card.pay();
        }
    }
    
 // ============================================================
    // 3. PATTERN MATCHING
    // ============================================================
    /*
     * NOTES:
     *
     * Pattern matching reduces explicit type casting.
     *
     * OLD:
     *     if (employee instanceof Manager) {
     *
     *         Manager manager =
     *             (Manager) employee;
     *
     *         manager.manage();
     *     }
     *     
     * MODERN:
     *
     *     if (employee instanceof Manager manager) {
     *
     *         manager.manage();
     *     }
     *
     * ============================================================
     */

    static void patternMatchingDemo() {

        System.out.println("\n3. PATTERN MATCHING");
        System.out.println("--------------------------------------");

        Employee employee =new Developer();

        if (employee instanceof Developer developer) {
            developer.develop();
        }

        if (employee instanceof Manager manager) {
            manager.manage();
        }
    }


   
    }


