package stepfour.collections;

import java.util.*;

public class SetTest {

    public static void main(String[] args) {
        /**
         * Task 1: create a collection that will have only unique elements
         * and will sort elements after adding new element.
         */
        SortedSet stringSortedSet = Collections.synchronizedSortedSet(new TreeSet());
        stringSortedSet.add("Test1");
        stringSortedSet.add("Test22");
        stringSortedSet.add("Test2");
        stringSortedSet.add("ABC");
        System.out.println(stringSortedSet.toString());

        SortedSet intSortedSet = Collections.synchronizedSortedSet(new TreeSet());
        intSortedSet.add(1);
        intSortedSet.add(-15);
        intSortedSet.add(100);
        intSortedSet.add(30);
        System.out.println(intSortedSet.toString());

        /**
         * Task 2: create a map of Users with key= id field of user and print all Users with even id.
         */
        HashMap<Integer, String> users = new HashMap<Integer, String>();
        users.put(1, "User1");
        users.put(2, "User2");
        users.put(3, "User3");
        users.put(4, "User4");
        users.put(12, "User12");

        for (Integer id : users.keySet()) {
            if (id % 2 == 0){
                System.out.print(users.get(id) + ", ");
            }
        }

        /**
         * Task 3: collapse set and list with Strings to one collection.
         * Set has values:
         * Olya, Natasha, Polina, Vlad
         * and list has values:
         * Bohdan, Oleksandr, Vlad, Natasha.
         * Print all values of result collection to console.
         */
        Set<String> set = new HashSet<>(Set.of("Olya", "Natasha", "Polina", "Vlad" ));
        List<String> list = new ArrayList<> (List.of("Bohdan", "Oleksandr", "Vlad", "Natasha"));
        list.addAll(set);
        set.addAll(list);
        System.out.println("\n" +list);
        System.out.println(set);

        HashMap<String, String> testMap = new HashMap<>();
        testMap.put("333", "Test333");
        testMap.put("121", "Test1");
        testMap.put("1211", "Test2");
        testMap.put("222", "Test3");
        testMap.put("12", "Test4");
        System.out.println(sortedMap(testMap));

    }
    /**
     * Task 4: create a static method that accept like argument map(key and value Strings).
     * Method must return sorted map(key and value Strings), that has only 3 characters keys.
     */
    public static Map sortedMap(HashMap<String, String> map){
        Map<String, String> resultMap = new HashMap<>();
        for (String kye : map.keySet()) {
            if (kye.matches("...")){
                resultMap.put(kye, map.get(kye));
            }
        }
        return resultMap;
    }

}
