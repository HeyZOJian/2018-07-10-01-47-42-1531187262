package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        //选出给定区间中所有的数字
        List<Integer> resultList = new ArrayList<>();
        if (left < right) {
            for (int i = left; i <= right; i++) resultList.add(i);
        } else {
            for (int i = left; i >= right; i--) resultList.add(i);
        }
        return resultList;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> numberList = getListByInterval(left, right);
        return numberList.stream()
                .filter((x) -> x % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        //选出给定区间中所有的偶数
        List<Integer> list = new ArrayList<>();
        for (int x : array) {
            list.add(x);
        }
        return list.stream()
                .filter((x) -> x % 2 == 0)
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> result = new ArrayList<>();
        for (int x : firstArray) {
            for (int y : secondArray) {
                if (x == y)
                    result.add(x);
            }
        }
        return result;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = new ArrayList<Integer>(Arrays.asList(firstArray));
        List<Integer> secondList = new ArrayList<Integer>(Arrays.asList(secondArray));

        List<Integer> unique = secondList.stream()
                .filter((x) -> !firstList.stream().anyMatch((x1) -> x1 == x))
                .collect(Collectors.toList());

        firstList.addAll(unique);
        return firstList;
    }
}
