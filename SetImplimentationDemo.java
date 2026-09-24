package collectionsdemo;

import java.util.HashSet;
import java.util.*;

/**
 * Author   : rajgs
 * Date     : 24 Sept 2026
 * Time     : 10:02:45 am
 * Project  : CoreJava
 */

/*
 * ================================================================
 * 1. WHAT IS A SET?
 * ================================================================
 *
 * Set is an interface in the Java Collections Framework.
 *A Set represents a collection of UNIQUE elements.
 *
 * Example:
 *
 *     [TCS, INFY, TCS, HDFC]
 *
 * When stored in a Set:
 *
 *     [TCS, INFY, HDFC]
 *
 * The duplicate "TCS" is automatically ignored.
 *
 *
 * IMPORTANT CHARACTERISTICS OF SET:
 *
 * 1. Does NOT allow duplicate elements.
 * 2. Generally does not provide index-based access.
 * 3. Different implementations provide different ordering behavior.
 * 4. Useful when uniqueness is more important than position.
 *
 *
 * Common implementations:
 *
 *              Set
 *               |
 *       -------------------
 *       |        |        |
 *   HashSet  LinkedHashSet TreeSet
 *
 *
 * ================================================================
 * 2. HASHSET
 * ================================================================
 *
 * HashSet internally uses hashing.
 *
 * Characteristics:
 *
 * - Does not allow duplicates.
 * - Does NOT guarantee insertion order.
 * - Average O(1) for add(), remove() and contains().
 * - Allows one null element.
 * - Usually the preferred choice when ordering is not required.
 *
 *
 * Typical usage:
 *
 *     Set<String> stocks = new HashSet<>();
 *
 *
 * Time Complexity:
 *
 * add()       -> Average O(1)
 * remove()    -> Average O(1)
 * contains()  -> Average O(1)
 * size()      -> O(1)
 *
 * Worst-case complexity can degrade due to hash collisions,
 * although modern Java implementations optimize collision handling.
 *
 * ================================================================
 * 3. LINKEDHASHSET
 * ================================================================
 *
 * LinkedHashSet combines:
 *
 *     Hashing + Linked List
 *
 * Characteristics:
 *
 * - Does not allow duplicates.
 * - Maintains INSERTION ORDER.
 * - Average O(1) for add(), remove() and contains().
 * - Allows one null element.
 *
 * Example:
 *
 *     Add:
 *     TCS
 *     INFY
 *     HDFC
 *
 *     Iteration:
 *     TCS
 *     INFY
 *     HDFC
 *
 *
 * Time Complexity:
 *
 * add()       -> Average O(1)
 * remove()    -> Average O(1)
 * contains()  -> Average O(1)
 *
 *
 * ================================================================
 * 4. TREESET
 * ================================================================
 *
 * TreeSet stores elements in SORTED ORDER.
 *
 * Internally it is based on a balanced tree
 * (specifically a Red-Black tree implementation).
 *
 * Characteristics:
 *
 * - Does not allow duplicates.
 * - Maintains sorted order.
 * - Elements must be mutually comparable, or a Comparator
 *   should be supplied.
 * - add(), remove() and contains() -> O(log n)
 * - Does not allow null with natural ordering.
 *
 *
 * Example:
 *
 * Input:
 *
 *     TCS
 *     INFY
 *     HDFC
 *
 * Output:
 *
 *     HDFC
 *     INFY
 *     TCS
 *
 *
 * ================================================================
 */


public class SetImplimentationDemo {

	public static void main(String[] args) {
		/*
		 * =========================================================
		 * 5. HASHSET
		 * =========================================================
		 */

		System.out.println("========== HASHSET ==========");

		Set<String> hashSet = new HashSet<>();

		/*
		 * add()
		 *
		 * Adds an element to the Set.
		 *
		 * Returns:
		 *
		 * true  -> element was added
		 * false -> element already existed
		 *
		 * Average Time Complexity: O(1)
		 */

		System.out.println("Add TCS: " + hashSet.add("TCS"));
		System.out.println("Add INFY: " + hashSet.add("INFY"));
		System.out.println("Add HDFC: " + hashSet.add("HDFC"));

		/*
		 * Duplicate value
		 *
		 * TCS already exists.
		 *
		 * Therefore add() returns false.
		 */

		System.out.println("Add duplicate TCS: " + hashSet.add("TCS"));

		/*
		 * HashSet does NOT guarantee insertion order.
		 */

		System.out.println("HashSet: " + hashSet);


		/*
		 * =========================================================
		 * contains()
		 * =========================================================
		 *
		 * Checks whether an element exists.
		 *
		 * Average Time Complexity: O(1)
		 */

		System.out.println("Contains INFY: " + hashSet.contains("INFY"));
		System.out.println("Contains RELIANCE: " + hashSet.contains("RELIANCE"));


		/*
		 * =========================================================
		 * remove()
		 * =========================================================
		 *
		 * Removes an element.
		 *
		 * Average Time Complexity: O(1)
		 */

		System.out.println("Remove HDFC: " + hashSet.remove("HDFC"));
		System.out.println("After remove: " + hashSet);


		/*
		 * =========================================================
		 * size()
		 * =========================================================
		 */

		System.out.println("Size: " + hashSet.size());


		/*
		 * =========================================================
		 * isEmpty()
		 * =========================================================
		 */

		System.out.println("Is Empty: " + hashSet.isEmpty());


		/*
		 * =========================================================
		 * clear()
		 * =========================================================
		 *
		 * Removes all elements.
		 *
		 * Time Complexity: O(n)
		 */

		hashSet.clear();

		System.out.println("After clear: " + hashSet);


		/*
		 * =========================================================
		 * 6. LINKEDHASHSET
		 * =========================================================
		 */

		System.out.println("\n========== LINKEDHASHSET ==========");

		Set<String> linkedHashSet = new LinkedHashSet<>();

		linkedHashSet.add("TCS");
		linkedHashSet.add("INFY");
		linkedHashSet.add("HDFC");
		linkedHashSet.add("RELIANCE");

		/*
		 * Duplicate is ignored.
		 */

		linkedHashSet.add("TCS");

		/*
		 * LinkedHashSet maintains insertion order.
		 *
		 * Expected:
		 *
		 * TCS
		 * INFY
		 * HDFC
		 * RELIANCE
		 */

		System.out.println("LinkedHashSet: " + linkedHashSet);


		/*
		 * contains()
		 */

		System.out.println("Contains HDFC: " + linkedHashSet.contains("HDFC"));


		/*
		 * remove()
		 */

		linkedHashSet.remove("INFY");

		System.out.println("After removing INFY: " + linkedHashSet);


		/*
		 * Add another stock.
		 *
		 * New element is added at the end.
		 */

		linkedHashSet.add("SBIN");

		System.out.println("After adding SBIN: " + linkedHashSet);


		/*
		 * =========================================================
		 * 7. TREESET
		 * =========================================================
		 */

		System.out.println("\n========== TREESET ==========");

		Set<String> treeSet = new TreeSet<>();

		treeSet.add("TCS");
		treeSet.add("INFY");
		treeSet.add("HDFC");
		treeSet.add("RELIANCE");
		treeSet.add("SBIN");

		/*
		 * TreeSet automatically sorts elements
		 * according to their natural ordering.
		 */

		System.out.println("TreeSet: " + treeSet);


		/*
		 * Duplicate values are ignored.
		 */

		System.out.println("Add duplicate TCS: " + treeSet.add("TCS"));


		/*
		 * contains()
		 *
		 * Time Complexity: O(log n)
		 */

		System.out.println("Contains INFY: " + treeSet.contains("INFY"));


		/*
		 * remove()
		 *
		 * Time Complexity: O(log n)
		 */

		treeSet.remove("HDFC");

		System.out.println("After removing HDFC: " + treeSet);


		/*
		 * =========================================================
		 * 8. TREESET-SPECIFIC OPERATIONS
		 * =========================================================
		 *
		 * TreeSet provides navigation methods because
		 * elements are maintained in sorted order.
		 */

		TreeSet<Integer> prices = new TreeSet<>();

		prices.add(1200);
		prices.add(850);
		prices.add(1500);
		prices.add(950);
		prices.add(2000);

		System.out.println("\nStock Prices: " + prices);


		/*
		 * first()
		 *
		 * Returns the smallest element.
		 *
		 * Time Complexity: O(1)
		 */

		System.out.println("Lowest Price: " + prices.first());


		/*
		 * last()
		 *
		 * Returns the largest element.
		 *
		 * Time Complexity: O(1)
		 */

		System.out.println("Highest Price: " + prices.last());


		/*
		 * higher(x)
		 *
		 * Returns the smallest element
		 * strictly greater than x.
		 */

		System.out.println("Price higher than 1000: " + prices.higher(1000));


		/*
		 * lower(x)
		 *
		 * Returns the largest element
		 * strictly smaller than x.
		 */

		System.out.println("Price lower than 1000: " + prices.lower(1000));


		/*
		 * ceiling(x)
		 *
		 * Returns the smallest element
		 * greater than or equal to x.
		 */

		System.out.println("Ceiling of 1000: " + prices.ceiling(1000));


		/*
		 * floor(x)
		 *
		 * Returns the largest element
		 * less than or equal to x.
		 */

		System.out.println("Floor of 1000: " + prices.floor(1000));


		/*
		 * =========================================================
		 * 9. ITERATING THROUGH A SET
		 * =========================================================
		 */

		System.out.println("\n========== ITERATION ==========");

		Set<String> stocks = new LinkedHashSet<>();

		stocks.add("TCS");
		stocks.add("INFY");
		stocks.add("HDFC");
		stocks.add("SBIN");


		/*
		 * Enhanced for loop
		 */

		for (String stock : stocks) {
			System.out.println("Stock: " + stock);
		}


		/*
		 * forEach() using Lambda
		 */

		System.out.println("\nUsing forEach():");

		stocks.forEach(stock -> System.out.println(stock));


		/*
		 * =========================================================
		 * 10. SET OPERATIONS
		 * =========================================================
		 *
		 * Set supports mathematical operations such as:
		 *
		 * UNION
		 * INTERSECTION
		 * DIFFERENCE
		 *
		 * These are very useful in real applications.
		 */


		Set<String> portfolioA = new HashSet<>(Arrays.asList("TCS", "INFY", "HDFC", "SBIN"));

		Set<String> portfolioB = new HashSet<>(Arrays.asList("INFY", "HDFC", "RELIANCE", "ICICI"));

		System.out.println("\nPortfolio A: " + portfolioA);
		System.out.println("Portfolio B: " + portfolioB);


		/*
		 * =========================================================
		 * UNION
		 * =========================================================
		 *
		 * Combines all unique elements from both Sets.
		 *
		 * A UNION B
		 *
		 * Time Complexity: O(n + m)
		 */

		Set<String> union = new HashSet<>(portfolioA);

		union.addAll(portfolioB);

		System.out.println("\nUnion: " + union);


		/*
		 * =========================================================
		 * INTERSECTION
		 * =========================================================
		 *
		 * Finds elements common to both Sets.
		 *
		 * A INTERSECTION B
		 *
		 * retainAll() keeps only common elements.
		 *
		 * Typical complexity: O(n + m) for HashSet-based
		 * collections.
		 */

		Set<String> intersection = new HashSet<>(portfolioA);

		intersection.retainAll(portfolioB);

		System.out.println("Intersection: " + intersection);


		/*
		 * =========================================================
		 * DIFFERENCE
		 * =========================================================
		 *
		 * Finds elements present in A but NOT in B.
		 *
		 * A - B
		 *
		 * removeAll() removes elements that occur in B.
		 */

		Set<String> difference = new HashSet<>(portfolioA);

		difference.removeAll(portfolioB);

		System.out.println("Difference A - B: " + difference);


		/*
		 * =========================================================
		 * 11. NULL VALUES
		 * =========================================================
		 *
		 * HashSet:
		 *     Allows one null.
		 *
		 * LinkedHashSet:
		 *     Allows one null.
		 *
		 * TreeSet:
		 *     With natural ordering, null is not allowed.
		 */

		Set<String> hashSetWithNull = new HashSet<>();

		hashSetWithNull.add(null);
		hashSetWithNull.add("TCS");
		hashSetWithNull.add(null);

		System.out.println("\nHashSet with null: " + hashSetWithNull);


		Set<String> linkedSetWithNull = new LinkedHashSet<>();

		linkedSetWithNull.add(null);
		linkedSetWithNull.add("TCS");
		linkedSetWithNull.add(null);

		System.out.println("LinkedHashSet with null: " + linkedSetWithNull);


		/*
		 * TreeSet with natural ordering:
		 *
		 * treeSet.add(null);
		 *
		 * This will result in NullPointerException.
		 *
		 * Therefore the following code is intentionally commented.
		 */

		/*
        Set<String> treeSetWithNull = new TreeSet<>();
        treeSetWithNull.add(null);
		 */


		/*
		 * =========================================================
		 * 12. CONVERTING SET TO ARRAY
		 * =========================================================
		 */

		Set<String> stockSet = new HashSet<>();

		stockSet.add("TCS");
		stockSet.add("INFY");
		stockSet.add("HDFC");

		String[] stockArray = stockSet.toArray(new String[0]);

		System.out.println("\nArray: " + Arrays.toString(stockArray));


		/*
		 * =========================================================
		 * 13. CREATING AN UNMODIFIABLE SET
		 * =========================================================
		 *
		 * Java provides Set.of() for creating an
		 * unmodifiable Set.
		 *
		 * Useful when the collection should not be changed.
		 */

		Set<String> fixedStocks = Set.of("TCS", "INFY", "HDFC");

		System.out.println("\nUnmodifiable Set: " + fixedStocks);

		/*
		 * The following will throw
		 * UnsupportedOperationException:
		 *
		 * fixedStocks.add("SBIN");
		 */


		/*
		 * =========================================================
		 * 14. COPY A SET
		 * =========================================================
		 */

		Set<String> copiedSet = new HashSet<>(stocks);

		System.out.println("\nCopied Set: " + copiedSet);


	}

}
