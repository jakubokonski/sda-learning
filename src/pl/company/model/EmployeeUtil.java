package pl.company.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeUtil {

    public static float getAverageSalary(Employee[] employees) {
        if (employees.length == 0) { // check if list is empty
            return 0;
        }
        float sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.length;

    }

    public static List<Employee> findByJobTitleStartingWith(String title, Employee[] employees) {
        if (employees.length == 0) {
            return Collections.emptyList(); // return empty list
        }

        List<Employee> result = new ArrayList<>();
        String lowerCasedTitle = title.toLowerCase();
        for (Employee employee : employees) {

            if (employee.getJobTitle().toLowerCase().startsWith(lowerCasedTitle)) {
                result.add(employee);
            }
        }
        return result;
    }



}
