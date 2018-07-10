package com.thoughtworks.collection;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {
    }

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
//        List<Integer> resultList = new ArrayList<>();
//        number -= 2;
//        while (number > 0) {
//            resultList.add(number);
//            number -= 2;
//        }
//        return resultList;
        if (number % 2 == 0) {
            return new CollectionOperator().getEvenListByIntervals(number, 0);
        } else {
            return new CollectionOperator()
                    .getListByInterval(number - 2, 1)
                    .stream()
                    .filter((x) -> x % 2 == 1)
                    .collect(Collectors.toList());
        }

    }
}
