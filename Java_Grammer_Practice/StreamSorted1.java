
import java.util.*;
import java.util.stream.*;

public class Main {

    static class Employee {
        String name;
        int score;

        Employee(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static List<String> getPassedNames(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.score >= 70)
                .sorted(Comparator.comparingInt(
                        employee -> employee.score
                ).reversed())
                ,map(employee -> employee.name)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("민수", 80),
                new Employee("지영", 65),
                new Employee("수진", 95),
                new Employee("현우", 70)
        );

        System.out.println(getPassedNames(employees));
        // 기대 결과: [수진, 민수, 현우]
    }
}
