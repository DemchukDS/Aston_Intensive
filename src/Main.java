import Castom.CastomArrayList;

import java.util.Arrays;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CastomArrayList<Integer> list = new CastomArrayList<>();
        list.add(0, 8);
        list.add(1, 2);
        list.add(2, 16);
        System.out.println("Список после добавления: " + list);

        list.addAll(Arrays.asList(4, 5, 6));
        System.out.println("Список после addAll: " + list);

        list.removeByIndex(2);
        System.out.println("Список после remove по индексу: " + list);

        list.removeByVolume(Integer.valueOf(5));
        System.out.println("Список после remove по элементу: " + list);

        list.sort(Integer::compareTo);
        System.out.println("Список после сортировки: " + list);

        System.out.println("Первый элемент: " + list.get(0));

        System.out.println("Список пуст: " + list.isEmpty());

        list.clear();
        System.out.println("Список после очистки: " + list);

        System.out.println("Список пуст: " + list.isEmpty());
    }
}