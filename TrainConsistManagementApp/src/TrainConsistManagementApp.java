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

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    private static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        testFilter_CapacityGreaterThanThreshold();
        testFilter_CapacityEqualToThreshold();
        testFilter_CapacityLessThanThreshold();
        testFilter_MultipleBogiesMatching();
        testFilter_NoBogiesMatching();
        testFilter_AllBogiesMatching();
        testFilter_EmptyBogieList();
        testFilter_OriginalListUnchanged();
    }

    static void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("AC Chair", 56));
        List<Bogie> result = filterBogies(bogies, 70);
        System.out.println("GreaterThanThreshold: " + result);
    }

    static void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Equal", 70), new Bogie("High", 80));
        List<Bogie> result = filterBogies(bogies, 70);
        System.out.println("EqualToThreshold: " + result);
    }

    static void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Low", 60), new Bogie("Lower", 50));
        List<Bogie> result = filterBogies(bogies, 70);
        System.out.println("LessThanThreshold: " + result);
    }

    static void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("General", 90), new Bogie("AC Chair", 56));
        List<Bogie> result = filterBogies(bogies, 60);
        System.out.println("MultipleMatching: " + result);
    }

    static void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Small", 20), new Bogie("Medium", 40));
        List<Bogie> result = filterBogies(bogies, 60);
        System.out.println("NoMatching: " + result);
    }

    static void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("General", 90));
        List<Bogie> result = filterBogies(bogies, 60);
        System.out.println("AllMatching: " + result);
    }

    static void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        List<Bogie> result = filterBogies(bogies, 60);
        System.out.println("EmptyList: " + result);
    }

    static void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        List<Bogie> result = filterBogies(bogies, 60);
        System.out.println("OriginalListUnchanged: " + bogies + " | Filtered: " + result);
    }
}
