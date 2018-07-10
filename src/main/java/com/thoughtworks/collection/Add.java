package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Add {

    public int getSumOfEvens(int leftBorder, int rightBorder) {

        if (leftBorder > rightBorder) {
            leftBorder ^= rightBorder;
            rightBorder ^= leftBorder;
            leftBorder ^= rightBorder;
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = leftBorder; i <= rightBorder; i++) numbers.add(i);

        return numbers.stream()
                .filter((number) -> number % 2 == 0)
                .reduce(0, (sum, number) -> sum + number);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            leftBorder ^= rightBorder;
            rightBorder ^= leftBorder;
            leftBorder ^= rightBorder;
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = leftBorder; i <= rightBorder; i++) numbers.add(i);

        return numbers.stream()
                .filter((number) -> number % 2 != 0)
                .reduce(0, (sum, number) -> sum + number);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .mapToInt((number) -> number * 3 + 2)
                .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        //求数组中奇数元素的3倍加2，偶数元素不变的数组
        return arrayList.stream()
                .map((number) -> {
                    if (number % 2 != 0) {
                        return number * 3 + 2;
                    } else
                        return number;
                })
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        //求数组中奇数元素的3倍加5的和
        return arrayList.stream()
                .filter((number) -> number % 2 == 1)
                .mapToInt((number) -> number * 3 + 5)
                .sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        //求数组中所有偶数组成的数组的中位数
        Long evenCount = arrayList.stream()
                .filter((number) -> number % 2 == 0)
                .count();
        Integer evenSum = arrayList.stream()
                .filter((number) -> number % 2 == 0)
                .reduce(0, (sum, number) -> sum + number);
        return evenSum / evenCount;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        //求数组中所有偶数的平均数
        Long evenCount = arrayList.stream()
                .filter((number) -> number % 2 == 0)
                .count();
        Integer evenSum = arrayList.stream()
                .filter((number) -> number % 2 == 0)
                .reduce(0, (sum, number) -> sum + number);
        return evenSum / evenCount;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        // 求数组中所有偶数组成的数组是否包含某特定的数specialElment
        List<Integer> evenList = arrayList.stream()
                .filter((number) -> number % 2 == 0)
                .collect(Collectors.toList());
        return evenList.stream()
                .anyMatch((number) -> number == specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        //找出数组中的所有偶数，从中剔除重复数据并返回
        return arrayList.stream()
                .filter((number) -> number % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            result.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }
        return result;
    }
}
