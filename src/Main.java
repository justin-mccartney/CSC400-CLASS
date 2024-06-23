public class Main {
    public static void main(String[] args) {
        /* Module 1 Critical Thinking - Main()
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

        // Testing to see the count of the removed item 'eggplant'
        System.out.println("Amount of eggplants in the bag: " + bag.count("eggplant"));
        */

        // Module 2 Critical Thinking Main()
        // Creating two new instances of bag (1 and 2)
        Bag<String> bag_one = new Bag<>();
        Bag<String> bag_two = new Bag<>();

        // Adding elements to the two different bags, creating two different bags
        bag_one.add("Audi");
        bag_one.add("Volkswagen");
        bag_one.add("Porsche");
        bag_one.add("Audi");
        bag_one.add("Mercedes Benz");

        bag_two.add("Acura");
        bag_two.add("Toyota");
        bag_two.add("Toyota");
        bag_two.add("Honda");
        bag_two.add("Nissan");

        // Printing the size of each bag respectively - using size method
        System.out.println("Size of Bag One: " + bag_one.size());
        System.out.println("Size of Bag Two: " + bag_two.size());

        // Merging the two bags together - using merge method
        bag_one.merge(bag_two);

        // Print the contents of the merged bag...
        System.out.println("\nMerged bag contents:");
        System.out.println(bag_one);

        // Creating a bag filled with only DISTINCT elements - using distinct method
        Bag<String> distinctBag = bag_one.distinct();

        // Printing the contents of the distinct bag...
        System.out.println("\nDistinct Bag Contents:");
        System.out.println(distinctBag);
    }
}
