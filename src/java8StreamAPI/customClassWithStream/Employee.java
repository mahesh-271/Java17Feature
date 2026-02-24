package java8StreamAPI.customClassWithStream;

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

    @Override
    public String toString() {
        return "employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
                + employeeSalary + "]";
    }

    public static void main(String[] args) {

        Employee employee = new Employee (1, "Mahesh", 100000);
        Employee employee5 = new Employee (5, "Mahesh", 110000);
        Employee employee1 = new Employee (2, "Killu", 110000);
        Employee employee2= new Employee (3, "John", 90000);
        Employee employee3= new Employee (4, "Cena", 90000);
        Employee employee4= new Employee (6, "Garry", 90000);

        List<Employee> employees = Arrays.asList ( employee, employee1 , employee2,employee3,employee4,employee5 );

       List<Employee> emplist =  employees.stream ()
                .toList ();


       //filter employees based on salary

        //mphasis interview question
        Map<String , Employee> employeesMap = employees.stream ()
                .collect ( Collectors.groupingBy (val -> val.employeeName,
                        Collectors.collectingAndThen( Collectors.maxBy ( Comparator.comparing ( emp -> emp.employeeSalary ) )
                                ,Optional::get)));
   //     employeesMap.forEach ( (key , val) -> System.out.println (key + " " + val) );

    }
}
