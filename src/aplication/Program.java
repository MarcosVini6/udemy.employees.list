package aplication;

import entities.Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employees> employeesList = new ArrayList<>();
        System.out.println("How many employees we be registered?");
        int numberemployee = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numberemployee; i++) {
            System.out.println("Enter the id of employee " + (i + 1) + ":");
            Integer id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the name of employee " + (i + 1) + ":");
            String name = sc.nextLine();
            System.out.println("Enter the salary of employee " + (i + 1) + ":");
            Double salary = sc.nextDouble();
            Employees x = new Employees(id, name, salary);
            employeesList.add(x);
        }
        System.out.println("Enter the employee id that will have salary increase:");
        int idSalary = sc.nextInt();
        Integer pos = position(employeesList, idSalary);
        if (pos == null) {
            System.out.println("Id inexistente");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            employeesList.get(pos).salaryIncrase(percentage);
        }
        System.out.println();
        System.out.println("List of emplooyes");
        for (Employees employees: employeesList
             ) {
            System.out.println(employees);
        }


        sc.close();
    }

    static Integer position(List<Employees> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
}

