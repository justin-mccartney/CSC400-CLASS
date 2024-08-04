import java.util.*;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    // Constructor to initialize person object, setting first name, last name, and age
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getter for persons first name
    public String getFirstName() {
        return firstName;
    }

    // Getter for persons last name
    public String getLastName() {
        return lastName;
    }

    // Getter for persons age
    public int getAge() {
        return age;
    }

    // toString method which allows for simple printing of Person object
    @Override
    public String toString() {
        return firstName + " " + lastName + ", Age: " + age;
    }
}

class Queue {
    private List<Person> people;

    // Constructor for initialization of the queue object
    public Queue() {
        people = new ArrayList<>();
    }

    // Add method for people into array list
    public void add(Person person) {
        people.add(person);
    }

    // Display (print) method that allows program to display list of people
    public void display() {
        for(Person person : people) {
            System.out.println(person);
        }
    }

    // Method that sorts the queue by last name - in descending order
    public void sortByLastNameDescending() {
        quickSort(people, 0, people.size() - 1, Comparator.comparing(Person::getLastName).reversed());
    }

    // Method that sorts the queue by age - in descending order
    public void sortByAgeDescending() {
        quickSort(people, 0, people.size() - 1, Comparator.comparingInt(Person::getAge).reversed());
    }

    // Quick sort algorithm
    private void quickSort(List<Person> list, int low, int high, Comparator<Person> comparator) {
        if(low < high) {
            int pi = partition(list, low, high, comparator);
            quickSort(list, low, pi - 1, comparator);
            quickSort(list, pi + 1, high, comparator);
        }
    }

    // Partition method that assists with quick sort algorithm
    private int partition(List<Person> list, int low, int high, Comparator<Person> comparator) {
        Person pivot = list.get(high);
        int i = (low - 1);
        for(int j = low; j < high; j++) {
            if(comparator.compare(list.get(j), pivot) > 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }
}