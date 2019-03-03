import pl.company.model.Employee;
import pl.company.model.EmployeeUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _19_OOP_Basics_Task {
    public static void main(String[] args) {
        /*
        *1. create package pl.company.model
        *2. add class Employee:
            - immutable fields:
                * name
                * family name
                * pesel
                * birthday -> java.time.LocalDate
            - mutable
                * salary
                * job title
          *  - add constructor for immutable
          *  - add getters
          *  - add setter job title
            - add mutation for salary - it should increase or decrease by given amount, not lower than 1000
         3. Create class EmployeeUtil with static methods:
            - float getAverageSalary(Employee[] employees)
            - List<employee> findByJobTitleStartingWith(String title, Emplyee[] arr)
         4. Use Scanner to get input from user and create objects of Employee class
        ------------------------------------------------------------------------------
         */
        // scanner input
        Scanner scanner = new Scanner(System.in);
        List<Employee> employeesList = new ArrayList<>();
        boolean finished = false;

        do {
            System.out.println("First name:");
            String firstName = scanner.next();

            System.out.println("Last name:");
            String familyName = scanner.next();

            System.out.println("PESEL:");
            String pesel = scanner.next();

            System.out.println("Date of birth");
            System.out.println("Year");
            int year = scanner.nextInt();
            System.out.println("Month");
            int month = scanner.nextInt();
            System.out.println("Day");
            int day = scanner.nextInt();

            LocalDate birthday = LocalDate.of(year, month, day);

            Employee employee = new Employee(firstName, familyName, pesel, birthday); // create new employee
            employeesList.add(employee); // add new employee to the list. employee is an index no. on list, not name!

            System.out.println("Salary:");
            employee.setSalary(scanner.nextFloat()); // add salary to employee
            scanner.nextLine();

            System.out.println("Job title:");
            employee.setJobTitle(scanner.nextLine());

            System.out.println("Type 'yes' for another emplyee");
            String response = scanner.next();
            finished = !response.equalsIgnoreCase("yes");

        } while (!finished); // do while finished is true

        // list no. of employees
        System.out.println("Created employees: " + employeesList.size());

        // convert list to array:
        float avgSalary = EmployeeUtil.getAverageSalary(employeesList.toArray(new Employee[0])); // transfer list to array (create new array), conver list to array
        System.out.println("Average salary is: " + avgSalary);

        System.out.println("Provide starting title letters:");
        String title = scanner.next();
        List<Employee> result = EmployeeUtil
                .findByJobTitleStartingWith(title, employeesList.toArray(new Employee[0]));

        for (Employee employee : result) {
            System.out.println(employee.getFullName());
        }

/*
        // W klasie Employee tworzymy zmienną employee1 z konstruktora Employee z parametrami. trzeba podać wszystkie parametry!

        Employee employee1 = new Employee("Jan", "Kowalski", 909090, 900303, 1002);
        Employee employee2 = new Employee("Zygmunt", "Nowak", 900301, 748436, 2000);


        Employee[] employees = new Employee[] {employee1, employee2}; // add to array

        System.out.println(employee1.getFirstName() + " " + employee1.getFamilyName() + " " + employee1.getBirthday());
        System.out.println(employee2.getFirstName() + " " + employee2.getFamilyName() + " " + employee2.getBirthday());

        // calc av salary
        int salarySum = 0;
        for (Employee salary : employees) {
            salarySum += salary.getSalary();
        }
        int avSalary = salarySum / employees.length;
        System.out.println("Av salary: " + avSalary);
*/


    }
}
