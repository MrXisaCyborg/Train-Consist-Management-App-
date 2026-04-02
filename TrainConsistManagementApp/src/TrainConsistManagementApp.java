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

    private static Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
        return bogies.stream().collect(Collectors.groupingBy(b -> b.name));
    }

    public static void main(String[] args) {
        System.out.println("UC9 - Group Bogies by Type\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        Map<String, List<Bogie>> groupedBogies = groupBogies(bogies);

        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("Capacity -> " + b.capacity);
            }
        }

        System.out.println("\nUC9 grouping completed ...");

        System.out.println("\n--- Test Cases ---");

        System.out.println("testGrouping_BogiesGroupedByType: " + groupBogies(Arrays.asList(
                new Bogie("Sleeper", 72), new Bogie("Sleeper", 70))));

        System.out.println("testGrouping_MultipleBogiesInSameGroup: " + groupBogies(Arrays.asList(
                new Bogie("AC Chair", 56), new Bogie("AC Chair", 60))));

        System.out.println("testGrouping_DifferentBogieTypes: " + groupBogies(Arrays.asList(
                new Bogie("Sleeper", 72), new Bogie("First Class", 24))));

        System.out.println("testGrouping_EmptyBogieList: " + groupBogies(new ArrayList<>()));

        System.out.println("testGrouping_SingleBogieCategory: " + groupBogies(Arrays.asList(
                new Bogie("Sleeper", 72))));

        Map<String, List<Bogie>> keysTest = groupBogies(Arrays.asList(
                new Bogie("Sleeper", 72), new Bogie("AC Chair", 56), new Bogie("First Class", 24)));
        System.out.println("testGrouping_MapContainsCorrectKeys: " + keysTest.keySet());

        Map<String, List<Bogie>> sizeTest = groupBogies(Arrays.asList(
                new Bogie("Sleeper", 72), new Bogie("Sleeper", 70), new Bogie("AC Chair", 56)));
        System.out.println("testGrouping_GroupSizeValidation: Sleeper=" + sizeTest.get("Sleeper").size()
                + ", AC Chair=" + sizeTest.get("AC Chair").size());

        List<Bogie> original = new ArrayList<>();
        original.add(new Bogie("Sleeper", 72));
        original.add(new Bogie("AC Chair", 56));
        groupBogies(original);
        System.out.println("testGrouping_OriginalListUnchanged: " + original.size() + " bogies remain");
    }
}
