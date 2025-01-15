import Castom.CastomArrayList;
import StreamTraining.Employee;
import StreamTraining.RandomNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        {
//            CastomArrayList<Integer> list = new CastomArrayList<>();
//            list.add(0, 8);
//            list.add(1, 2);
//            list.add(2, 16);
//            System.out.println("Список после добавления: " + list);
//
//            list.addAll(Arrays.asList(4, 5, 6));
//            System.out.println("Список после addAll: " + list);
//
//            list.removeByIndex(2);
//            System.out.println("Список после remove по индексу: " + list);
//
//            list.removeByValue(Integer.valueOf(5));
//            System.out.println("Список после remove по элементу: " + list);
//
//            list.sort(Integer::compareTo);
//            System.out.println("Список после сортировки: " + list);
//
//            System.out.println("Первый элемент: " + list.get(0));
//
//            System.out.println("Список пуст: " + list.isEmpty());
//
//            list.clear();
//            System.out.println("Список после очистки: " + list);
//
//            System.out.println("Список пуст: " + list.isEmpty());
//        }

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Дмитрий", "male", 29, 1000.5d));
        employees.add(new Employee("Владислав", "male", 28, 1500.31d));
        employees.add(new Employee("Виктория", "female", 25, 920d));
        employees.add(new Employee("Александра", "female", 36, 360d));
        employees.add(new Employee("София", "female", 32, 600d));
        employees.add(new Employee("Радмир", "male", 39, 800d));
        employees.add(new Employee("Илона", "female", 19, 480d));
        employees.add(new Employee("Виктор", "male", 49, 690d));
        employees.add(new Employee("Степан", "male", 18, 810d));
        employees.add(new Employee("Борис", "male", 22, 300d));

        employees = employees.stream()
                .map(employee -> {
                    if (employee.getAge() >= 25 && employee.getSex() == "male"){
                        employee.setSalary(employee.getSalary() * 3);
                    } else if (employee.getAge() >= 30 && employee.getSex() == "female") {
                        employee.setSalary(employee.getSalary() * 2);
                    }
                    return employee;
                })
                .toList();
        employees.forEach(System.out::println);

        employees.stream().filter(
                employee -> employee.getAge() < 25 && employee.getSalary() > 200 && employee.getSex().equals("male"))
                .findFirst().ifPresent(System.out::println);

        List<Integer> numbers = RandomNumber.findListRandomNumbers();
        System.out.println("Исходный массив: " + numbers);

        int sum = 0;
        List<Integer> newList = numbers.stream().filter(element -> element < 0).sorted().toList();
        System.out.println("Полученный массив: " + newList);

        // Преобразовать МАП в список пар

        Map<Integer, String> nameByNumber = new HashMap<>();
        nameByNumber.put(0, "Dima");
        nameByNumber.put(1, "Vlad");
        nameByNumber.put(2, "Vika");
        nameByNumber.put(3, "Alesya");
        nameByNumber.put(4, "Alisa");
        nameByNumber.put(5, "Mikrochel");

        List<String> newArray = (new ArrayList<Integer>(nameByNumber.keySet()))
                .stream().map(element -> element + " -> " + nameByNumber.get(element)).toList();
        System.out.println(newArray);

        Map<String, String> clasessLa2ByPlayer = new HashMap<>();
        clasessLa2ByPlayer.put("Dima", "ShK");
        clasessLa2ByPlayer.put("Vlad", "Necr");
        clasessLa2ByPlayer.put("Vika", "EE");
        clasessLa2ByPlayer.put("Alesya", "Destroer");
        clasessLa2ByPlayer.put("Egor", "Sorcer");
        clasessLa2ByPlayer.put("Vasyan", "Bish");

        Map<String, String> subClasessL2ByPlayer = new HashMap<>();
        subClasessL2ByPlayer.put("Dima", "Wark");
        subClasessL2ByPlayer.put("Vlad", "Paladin");
        subClasessL2ByPlayer.put("Vika", "ShE");
        subClasessL2ByPlayer.put("Alesya", "ShK");
        subClasessL2ByPlayer.put("Egor", "Spoiler");
        subClasessL2ByPlayer.put("Oleg", "Hui");

        //Получить список пар "Дима имеет класс ___ и сабкласс ___"
        Set<String> set = new HashSet<>(clasessLa2ByPlayer.keySet());
        set.addAll(subClasessL2ByPlayer.keySet());
        List<String> l2Players = new ArrayList<String>(set).stream()
            .map(l2Player -> l2Player +
                (clasessLa2ByPlayer.containsKey(l2Player)
                    ? " имеет класс " + clasessLa2ByPlayer.get(l2Player)
                    : " не имеет класса") +
                (subClasessL2ByPlayer.containsKey(l2Player)
                    ? " и сабкласс " + subClasessL2ByPlayer.get(l2Player)
                    : " и не имеет сабкласса")
            ).toList();

        System.out.println(l2Players);
    }
}