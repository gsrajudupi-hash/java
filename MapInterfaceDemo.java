package collectionsdemo;

/**
 * Author   : rajgs
 * Date     : 24 Sept 2026
 * Time     : 11:15:05 am
 * Project  : CoreJava
 */

/*
 * ================================================================
 * 1. WHAT IS A MAP?
 * ================================================================
 *
 * Map is an interface in the Java Collections Framework.
 *
 * A Map stores data in the form of:
 *
 *              KEY  ---> VALUE
 *
 * Example:
 *
 *     "TCS"       ---> 3500.50
 *     "INFY"      ---> 1800.75
 *     "RELIANCE"  ---> 2900.25
 *
 *
 * IMPORTANT:
 *
 * 1. A Map stores KEY-VALUE pairs.
 * 2. Keys must be UNIQUE.
 * 3. Values can be duplicated.
 * 4. A Map does not extend the Collection interface.
 * 5. Different Map implementations provide different ordering.
 *
 *
 * Example:
 *
 *     Map<String, Double> stockPrices;
 *
 *
 * Common implementations:
 *
 *
 *                    Map
 *                     |
 *          -------------------------
 *          |           |           |
 *       HashMap   LinkedHashMap  TreeMap
 *
 *
 * ================================================================
 *
 * 2. HASHMAP
 * ================================================================
 *
 * HashMap uses hashing to store key-value pairs.
 *
 * Characteristics:
 *
 * - Does NOT allow duplicate keys.
 * - Allows duplicate values.
 * - Does NOT guarantee insertion order.
 * - Allows one null key.
 * - Allows multiple null values.
 * - Average O(1) for put(), get(), remove() and containsKey().
 *
 *
 * Time Complexity:
 *
 * put()          -> Average O(1)
 * get()          -> Average O(1)
 * remove()       -> Average O(1)
 * containsKey()  -> Average O(1)
 * containsValue()-> O(n)
 *
 *
 * Typical use:
 *
 *     Map<String, Double> stockPrices = new HashMap<>();
 *
 *
 * ================================================================
 *
 * 3. LINKEDHASHMAP
 * ================================================================
 *
 * LinkedHashMap combines:
 *
 *      Hash Table + Linked List
 *
 * Characteristics:
 *
 * - Does NOT allow duplicate keys.
 * - Allows duplicate values.
 * - Maintains INSERTION ORDER.
 * - Allows one null key.
 * - Allows multiple null values.
 * - Average O(1) for put(), get(), remove().
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
 * Iteration:
 *
 *     TCS
 *     INFY
 *     HDFC
 *
 *
 * ================================================================
 *
 * 4. TREEMAP
 * ================================================================
 *
 * TreeMap stores key-value pairs in SORTED KEY ORDER.
 *
 * TreeMap is based on a Red-Black tree.
 *
 * Characteristics:
 *
 * - Does NOT allow duplicate keys.
 * - Allows duplicate values.
 * - Keys are sorted according to natural ordering
 *   or a Comparator.
 * - put(), get(), remove() -> O(log n)
 * - null key is not allowed with natural ordering.
 * - null values are allowed.
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
 * TreeMap order:
 *
 *     HDFC
 *     INFY
 *     TCS
 *
 *
 * ================================================================
 */


public class MapInterfaceDemo {

	public static void main(String[] args) {
		 /*
         * =========================================================
         * 5. HASHMAP
         * =========================================================
         */

        System.out.println("========== HASHMAP ==========");

        Map<String, Double> stockPrices = new HashMap<>();


        /*
         * =========================================================
         * put()
         * =========================================================
         *
         * Adds a KEY-VALUE pair.
         *
         * Syntax:
         *
         *     map.put(key, value);
         *
         * Average Time Complexity: O(1)
         */

        stockPrices.put("TCS", 3500.50);
        stockPrices.put("INFY", 1800.75);
        stockPrices.put("HDFC", 1650.25);
        stockPrices.put("RELIANCE", 2900.40);

        System.out.println("Stock Prices: " + stockPrices);


        /*
         * =========================================================
         * DUPLICATE KEY
         * =========================================================
         *
         * A Map does NOT allow duplicate keys.
         *
         * If the same key is inserted again,
         * its old value is REPLACED.
         */

        stockPrices.put("TCS", 3600.00);

        System.out.println("After updating TCS: " + stockPrices);


        /*
         * Notice:
         *
         * TCS is still present only ONCE.
         *
         * New value = 3600.00
         */


        /*
         * =========================================================
         * get()
         * =========================================================
         *
         * Retrieves the value associated with a key.
         *
         * Average Time Complexity: O(1)
         */

        System.out.println("TCS Price: " + stockPrices.get("TCS"));
        System.out.println("INFY Price: " + stockPrices.get("INFY"));


        /*
         * If the key does not exist:
         *
         * get() returns null.
         */

        System.out.println("SBIN Price: " + stockPrices.get("SBIN"));


        /*
         * =========================================================
         * getOrDefault()
         * =========================================================
         *
         * Returns the value if key exists.
         * Otherwise returns the supplied default value.
         */

        System.out.println("SBIN Price: " + stockPrices.getOrDefault("SBIN", 0.0));


        /*
         * =========================================================
         * containsKey()
         * =========================================================
         *
         * Checks whether a key exists.
         *
         * Average Time Complexity: O(1)
         */

        System.out.println("Contains TCS: " + stockPrices.containsKey("TCS"));
        System.out.println("Contains SBIN: " + stockPrices.containsKey("SBIN"));


        /*
         * =========================================================
         * containsValue()
         * =========================================================
         *
         * Checks whether a value exists.
         *
         * Time Complexity: O(n)
         */

        System.out.println("Contains price 1800.75: " + stockPrices.containsValue(1800.75));


        /*
         * =========================================================
         * size()
         * =========================================================
         */

        System.out.println("Map Size: " + stockPrices.size());


        /*
         * =========================================================
         * isEmpty()
         * =========================================================
         */

        System.out.println("Is Map Empty: " + stockPrices.isEmpty());


        /*
         * =========================================================
         * remove()
         * =========================================================
         *
         * Removes the entry associated with the key.
         *
         * Average Time Complexity: O(1)
         */

        stockPrices.remove("HDFC");

        System.out.println("After removing HDFC: " + stockPrices);


        /*
         * =========================================================
         * remove(key, value)
         * =========================================================
         *
         * Removes the entry only if BOTH key and value match.
         */

        boolean removed = stockPrices.remove("INFY", 1800.75);

        System.out.println("INFY removed: " + removed);
        System.out.println("After conditional remove: " + stockPrices);


        /*
         * =========================================================
         * replace()
         * =========================================================
         *
         * Replaces the value associated with an existing key.
         */

        stockPrices.replace("TCS", 3700.00);

        System.out.println("After replacing TCS: " + stockPrices);


        /*
         * =========================================================
         * putIfAbsent()
         * =========================================================
         *
         * Adds the key-value pair only if the key
         * does not already exist.
         */

        stockPrices.putIfAbsent("TCS", 4000.00);
        stockPrices.putIfAbsent("SBIN", 850.00);

        System.out.println("After putIfAbsent(): " + stockPrices);


        /*
         * TCS will NOT become 4000 because it already exists.
         *
         * SBIN will be added because it does not exist.
         */


        /*
         * =========================================================
         * 6. ITERATING THROUGH HASHMAP
         * =========================================================
         */


        /*
         * =========================================================
         * keySet()
         * =========================================================
         *
         * Returns a Set containing all keys.
         */

        System.out.println("\nKeys:");

        for (String stock : stockPrices.keySet()) {

            System.out.println(stock);
        }


        /*
         * =========================================================
         * values()
         * =========================================================
         *
         * Returns a Collection containing all values.
         */

        System.out.println("\nValues:");

        for (Double price : stockPrices.values()) {

            System.out.println(price);
        }


        /*
         * =========================================================
         * entrySet()
         * =========================================================
         *
         * Returns all KEY-VALUE pairs.
         *
         * Map.Entry represents one key-value pair.
         */

        System.out.println("\nKey-Value Pairs:");

        for (Map.Entry<String, Double> entry : stockPrices.entrySet()) {

            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        /*
         * =========================================================
         * forEach()
         * =========================================================
         *
         * Java 8+ Lambda approach.
         */

        System.out.println("\nUsing forEach():");

        stockPrices.forEach((stock, price) -> System.out.println(stock + " -> " + price));


        /*
         * =========================================================
         * 7. LINKEDHASHMAP
         * =========================================================
         */

        System.out.println("\n========== LINKEDHASHMAP ==========");

        Map<String, Double> linkedStockPrices = new LinkedHashMap<>();

        linkedStockPrices.put("TCS", 3500.50);
        linkedStockPrices.put("INFY", 1800.75);
        linkedStockPrices.put("HDFC", 1650.25);
        linkedStockPrices.put("RELIANCE", 2900.40);
        linkedStockPrices.put("SBIN", 850.00);

        /*
         * LinkedHashMap maintains INSERTION ORDER.
         */

        System.out.println("LinkedHashMap: " + linkedStockPrices);


        /*
         * Updating an existing key does NOT create
         * a new position.
         */

        linkedStockPrices.put("TCS", 3600.00);

        System.out.println("After updating TCS: " + linkedStockPrices);


        /*
         * Removing and adding the key again will put it
         * at the end because it is a new insertion.
         */

        linkedStockPrices.remove("INFY");
        linkedStockPrices.put("INFY", 1850.00);

        System.out.println("After removing and adding INFY: " + linkedStockPrices);


        /*
         * =========================================================
         * 8. TREEMAP
         * =========================================================
         */

        System.out.println("\n========== TREEMAP ==========");

        Map<String, Double> sortedStockPrices = new TreeMap<>();

        sortedStockPrices.put("TCS", 3500.50);
        sortedStockPrices.put("INFY", 1800.75);
        sortedStockPrices.put("HDFC", 1650.25);
        sortedStockPrices.put("RELIANCE", 2900.40);
        sortedStockPrices.put("SBIN", 850.00);

        /*
         * TreeMap automatically sorts entries
         * according to their KEYS.
         */

        System.out.println("TreeMap: " + sortedStockPrices);


        /*
         * =========================================================
         * 9. TREEMAP NAVIGATION OPERATIONS
         * =========================================================
         *
         * TreeMap provides navigation methods because
         * its keys are maintained in sorted order.
         */


        /*
         * firstKey()
         *
         * Returns the smallest key.
         *
         * Time Complexity: O(log n)
         */

        System.out.println("First Key: " + ((TreeMap<String, Double>) sortedStockPrices).firstKey());


        /*
         * lastKey()
         *
         * Returns the largest key.
         */

        System.out.println("Last Key: " + ((TreeMap<String, Double>) sortedStockPrices).lastKey());


        /*
         * ceilingKey()
         *
         * Returns the smallest key greater than
         * or equal to the specified key.
         */

        TreeMap<String, Double> treeMap = (TreeMap<String, Double>) sortedStockPrices;

        System.out.println("Ceiling Key of INFY: " + treeMap.ceilingKey("INFY"));


        /*
         * floorKey()
         *
         * Returns the largest key less than
         * or equal to the specified key.
         */

        System.out.println("Floor Key of INFY: " + treeMap.floorKey("INFY"));


        /*
         * higherKey()
         *
         * Returns the smallest key strictly greater
         * than the specified key.
         */

        System.out.println("Higher Key than INFY: " + treeMap.higherKey("INFY"));


        /*
         * lowerKey()
         *
         * Returns the largest key strictly smaller
         * than the specified key.
         */

        System.out.println("Lower Key than INFY: " + treeMap.lowerKey("INFY"));


        /*
         * =========================================================
         * 10. HEADMAP / TAILMAP / SUBMAP
         * =========================================================
         *
         * These methods are useful for obtaining
         * ranges of sorted keys.
         */


        /*
         * headMap()
         *
         * Returns keys before the specified key.
         */

        System.out.println("HeadMap before INFY: " + treeMap.headMap("INFY"));


        /*
         * tailMap()
         *
         * Returns keys from the specified key onwards.
         */

        System.out.println("TailMap from INFY: " + treeMap.tailMap("INFY"));


        /*
         * subMap()
         *
         * Returns entries between two keys.
         *
         * Start key is inclusive.
         * End key is exclusive.
         */

        System.out.println("SubMap HDFC to TCS: " + treeMap.subMap("HDFC", "TCS"));


        /*
         * =========================================================
         * 11. NULL VALUES
         * =========================================================
         *
         * HashMap:
         *
         *     Allows ONE null key.
         *     Allows multiple null values.
         *
         * LinkedHashMap:
         *
         *     Allows ONE null key.
         *     Allows multiple null values.
         *
         * TreeMap:
         *
         *     Does NOT allow null key when using
         *     natural ordering.
         *
         *     Null values are allowed.
         */


        Map<String, Double> hashMapNull = new HashMap<>();

        hashMapNull.put(null, 1000.00);
        hashMapNull.put("TCS", null);
        hashMapNull.put("INFY", null);

        System.out.println("\nHashMap with null: " + hashMapNull);


        Map<String, Double> linkedMapNull = new LinkedHashMap<>();

        linkedMapNull.put(null, 1000.00);
        linkedMapNull.put("TCS", null);

        System.out.println("LinkedHashMap with null: " + linkedMapNull);


        /*
         * TreeMap null key example is intentionally
         * commented because it will throw
         * NullPointerException with natural ordering.
         */

        /*
        TreeMap<String, Double> treeMapNull = new TreeMap<>();

        treeMapNull.put(null, 1000.00);
        */


        /*
         * Null VALUE is allowed in TreeMap.
         */

        TreeMap<String, Double> treeMapWithNullValue = new TreeMap<>();

        treeMapWithNullValue.put("TCS", null);
        treeMapWithNullValue.put("INFY", 1800.75);

        System.out.println("TreeMap with null value: " + treeMapWithNullValue);


        /*
         * =========================================================
         * 12. CLEAR
         * =========================================================
         *
         * Removes all entries.
         *
         * Time Complexity: O(n)
         */

        Map<String, Double> tempMap = new HashMap<>();

        tempMap.put("TCS", 3500.00);
        tempMap.put("INFY", 1800.00);

        System.out.println("\nBefore clear: " + tempMap);

        tempMap.clear();

        System.out.println("After clear: " + tempMap);


        /*
         * =========================================================
         * 13. CHECKING EMPTY MAP
         * =========================================================
         */

        System.out.println("Is tempMap empty: " + tempMap.isEmpty());


        /*
         * =========================================================
         * 14. COPY A MAP
         * =========================================================
         */

        Map<String, Double> copiedMap = new HashMap<>(stockPrices);

        System.out.println("\nCopied Map: " + copiedMap);


        /*
         * =========================================================
         * 15. UNMODIFIABLE MAP
         * =========================================================
         *
         * Map.of() creates an unmodifiable Map.
         *
         * Java 9+
         */

        Map<String, Double> fixedPrices = Map.of(
                "TCS", 3500.00,
                "INFY", 1800.00,
                "HDFC", 1650.00
        );

        System.out.println("Unmodifiable Map: " + fixedPrices);


        /*
         * The following statement will throw:
         *
         * UnsupportedOperationException
         *
         * fixedPrices.put("SBIN", 850.00);
         */


        /*
         * =========================================================
         * 16. REPLACE ALL
         * =========================================================
         *
         * Java 8+ provides replaceAll().
         *
         * Here we increase every stock price by 100.
         */

        Map<String, Double> priceUpdate = new LinkedHashMap<>();

        priceUpdate.put("TCS", 3500.00);
        priceUpdate.put("INFY", 1800.00);
        priceUpdate.put("HDFC", 1650.00);

        System.out.println("\nBefore price update: " + priceUpdate);

        priceUpdate.replaceAll((stock, price) -> price + 100);

        System.out.println("After price update: " + priceUpdate);


        /*
         * =========================================================
         * 17. COMPUTE
         * =========================================================
         *
         * compute() can calculate a new value for an existing key.
         */

        priceUpdate.compute("TCS", (stock, price) -> price + 50);

        System.out.println("\nAfter compute(): " + priceUpdate);


        /*
         * =========================================================
         * 18. COMPUTE IF ABSENT
         * =========================================================
         *
         * Adds a value only when the key is absent.
         */

        priceUpdate.computeIfAbsent(
                "RELIANCE",
                stock -> 2900.00
        );

        System.out.println("After computeIfAbsent(): " + priceUpdate);


        /*
         * =========================================================
         * 19. COMPUTE IF PRESENT
         * =========================================================
         *
         * Updates a value only when the key is already present.
         */

        priceUpdate.computeIfPresent(
                "INFY",
                (stock, price) -> price + 75
        );

        System.out.println("After computeIfPresent(): " + priceUpdate);


        /*
         * =========================================================
         * 20. MERGE
         * =========================================================
         *
         * merge() is useful when combining or accumulating values.
         *
         * Example:
         *
         * Existing TCS price + 100
         */

        priceUpdate.merge(
                "TCS",
                100.00,
                Double::sum
        );

        System.out.println("After merge(): " + priceUpdate);

	}

}
