import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John ", 28, "TCS", "E001", 55000));
        employees.add(new Employee("Raju", 32, "Infy", "E002", 65000));
        employees.add(new Employee("Naga", 25, "TECH", "E003", 45000));
        employees.add(new Employee("Gali", 35, "Tech Corp", "E004", 35000));
        employees.add(new Employee("chari", 27, "Tech Corp", "E005", 52000));

        System.out.println("\nEmployees with salary > 50000:");
        employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .forEach(System.out::println);


        System.out.println("\nEmployees with age < 30:");
        employees.stream()
                .filter(e -> e.getAge() < 30)
                .forEach(System.out::println);


        Map<String, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getName, e -> e));


        System.out.println("\nEmployees from map with salary < 40000:");
        employeeMap.values().stream()
                .filter(e -> e.getSalary() < 40000)
                .forEach(System.out::println);

        System.out.println("\nEmployees from map with age > 25:");
        employeeMap.values().stream()
                .filter(e -> e.getAge() > 25)
                .forEach(System.out::println);
    }
}