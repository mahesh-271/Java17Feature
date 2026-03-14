package java8StreamAPI.customClassWithStream;

import java.io.FilterOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Employee {

    public int employeeId;
    public String employeeName;
    public int employeeSalary;

    public Employee(int employeeId, String employeeName, int employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }

    //overriding hashcode and equals method to compare ojects based on their content rather than reference
    @Override
    public int hashCode() {
        return Objects.hash ( employeeId, employeeSalary, employeeName );
    }

    @Override
    public boolean equals(Object o) {
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId
                && employeeSalary == employee.employeeSalary
                && Objects.equals(employeeName, employee.employeeName);
    }

    @Override
    public String toString() {
        return "employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
                + employeeSalary + "]";
    }

    public static void main(String[] args) {

        Employee employee = new Employee ( 1, "Mahesh", 100000 );
        Employee employee6= new Employee ( 1, "Mahesh", 100000 );
        Employee employee5 = new Employee ( 5, "Mahesh", 110000 );
        Employee employee1 = new Employee ( 2, "Killu", 110000 );
        Employee employee2 = new Employee ( 3, "John", 90000 );
        Employee employee3 = new Employee ( 4, "Cena", 90000 );
        Employee employee4 = new Employee ( 6, "Garry", 90000 );

        List<Employee> employees = Arrays.asList ( employee,employee6, employee1, employee2, employee3, employee4, employee5 );
       // System.out.println (employees);  //list allows duplicates

        Set<Employee> employeeSet = new HashSet<> ( employees );

        //filter employees based on salary

        //mphasis interview question
        Map<String, Employee> employeesMap = employees.stream ()
                .collect ( Collectors.groupingBy ( val -> val.employeeName,
                        Collectors.collectingAndThen ( Collectors.maxBy ( Comparator.comparing ( emp -> emp.employeeSalary ) )
                                , Optional::get ) ) );
        //     employeesMap.forEach ( (key , val) -> System.out.println (key + " " + val) );

    }
}
