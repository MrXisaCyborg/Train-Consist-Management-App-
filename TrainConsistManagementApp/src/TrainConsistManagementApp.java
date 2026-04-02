import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    private static int countTotalSeats(List<Bogie> bogies) {
        return bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println("UC10 - Count Total Seats in Train\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("Bogies in Train:");
        bogies.forEach(System.out::println);

        int totalSeats = countTotalSeats(bogies);
        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);

        System.out.println("\nUC10 aggregation completed ...");

        System.out.println("\n--- Test Cases ---");

        List<Bogie> test1 = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("AC Chair", 56));
        System.out.println("testReduce_TotalSeatCalculation: " + countTotalSeats(test1));

        List<Bogie> test2 = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("AC Chair", 56), new Bogie("First Class", 24));
        System.out.println("testReduce_MultipleBogiesAggregation: " + countTotalSeats(test2));

        List<Bogie> test3 = Arrays.asList(new Bogie("Sleeper", 72));
        System.out.println("testReduce_SingleBogieCapacity: " + countTotalSeats(test3));

        List<Bogie> test4 = new ArrayList<>();
        System.out.println("testReduce_EmptyBogieList: " + countTotalSeats(test4));

        List<Bogie> test5 = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("AC Chair", 56));
        System.out.println("testReduce_CorrectCapacityExtraction: " + test5.stream().map(b -> b.capacity).collect(Collectors.toList()));

        List<Bogie> test6 = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("AC Chair", 56), new Bogie("First Class", 24));
        System.out.println("testReduce_AllBogiesIncluded: " + countTotalSeats(test6));

        List<Bogie> test7 = new ArrayList<>();
        test7.add(new Bogie("Sleeper", 72));
        test7.add(new Bogie("AC Chair", 56));
        countTotalSeats(test7);
        System.out.println("testReduce_OriginalListUnchanged: " + test7.size() + " bogies remain");
    }
}
