public class Main {
    public static void main(String[] args) {
        // Creating an instance of the bag class
        Bag<String> bag = new Bag<>();

        // Adding elements to bag - having some instances of duplicates
        bag.add("cucumber");
        bag.add("broccoli");
        bag.add("tomato");
        bag.add("broccoli");
        bag.add("eggplant");
        bag.add("asparagus");
        bag.add("asparagus");
        bag.add("pumpkin");

        // Print the contents of the bag
        System.out.println("Bag contents: ");
        System.out.println(bag);

        // Testing to see if certain items are in the bag
        System.out.println("Bag contains 'broccoli': " + bag.containsItem("broccoli"));
        System.out.println("Bag contains 'carrot': " + bag.containsItem("carrot"));
        System.out.println("\n");

        // Counting the number of occurrences of an element within the bag
        System.out.println("Amount of broccoli in the bag: " + bag.count("broccoli"));
        System.out.println("Amount of tomatoes in the bag: " + bag.count("tomato"));
        System.out.println("\n");

        // Remove an element from the bag
        bag.remove("eggplant");
        System.out.println("'Eggplant' has been removed from the list.\n");

        // Reprint the UPDATED contents of the bag
        System.out.println("Reprinting the contents of the bag...");
        System.out.println(bag);

        // Testing to see if the bag contains the removed item
        System.out.println("Bag contains 'eggplant': " + bag.containsItem("eggplant"));

        // Testing to see the count of the removed item
        System.out.println("Amount of eggplants in the bag: " + bag.count("eggplant"));
    }
}
