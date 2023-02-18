package application;

import entities.Person;
import model.service.PersonService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Person> list = new ArrayList<>();
            String line = br.readLine();
            while (Objects.nonNull(line)) {
                String[] fields = line.split(",");
                list.add(new Person(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

        Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

            List<String> emails = list.stream().filter(p -> p.getSalary() > salary)
                    .map(p -> p.getEmail())
                    .sorted(comp)
                    .collect(Collectors.toList());

            System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
            emails.forEach(System.out::println);

            PersonService ps = new PersonService();

            double sumM = ps.filteredSum(list, p -> p.getName().charAt(0) == 'M');

            //Forma alternativa
//            double sum = list.stream()
//                    .filter(x -> x.getName().charAt(0) == 'M')
//                    .map(x -> x.getSalary())
//                    .reduce(0.0, (x, y) -> x + y);

            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sumM));

        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }

        sc.close();
    }
}
