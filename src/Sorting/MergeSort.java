package Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static <T extends Comparable<? super T>> List<T> sortByMergeSorting(List<T> list) {
        if (list.size() < 2) {
            return list;
        }
        int mid = list.size() / 2;
        List<T> firstList = (new ArrayList<>(list.subList(0, mid)));
        List<T> secondList = (new ArrayList<>(list.subList(mid, list.size())));

        return merge(sortByMergeSorting(firstList), sortByMergeSorting(secondList));
    }

    private static <T extends Comparable<? super T>> List<T> merge(List<T> firstList, List<T> secondList) {
        int i = 0;
        int j = 0;
        List<T> newList = new ArrayList<>();

        while (firstList.size() > i && secondList.size() > j) {
            if (firstList.get(i).compareTo(secondList.get(j)) <= 0) {
                newList.add(firstList.get(i));
                i++;
            } else {
                newList.add(secondList.get(j));
                j++;
            }
        }

        newList.addAll(firstList.subList(i, firstList.size()));
        newList.addAll(secondList.subList(j, secondList.size()));

        return  newList;
    }
}
