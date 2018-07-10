package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream()
                .map((x) -> x * 3)
                .collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream()
                .map((x) -> letters[x - 1])
                .collect(Collectors.toList());
    }

    public List<String> mapLetters() {
//        return array.stream()
//                .map((x) -> {
//                    String str = "";
//                    int num = 25;
//                    while (x>=25){
//                        str += letters[x/num];
//                        x/=25;
//                        num *= 25;
//                    }
//                    str += letters[x];
//                    return str;
//                })
//                .collect(Collectors.toList());
        return null;
    }

    public List<Integer> sortFromBig() {
        throw new NotImplementedException();
    }

    public List<Integer> sortFromSmall() {
        throw new NotImplementedException();
    }

    public static void main(String[] args) {
        //字母表映射
        Integer[] array = new Integer[]{1, 13, 27, 30, 52, 53};
        List<Integer> list = Arrays.asList(array);

        MyMap myMap = new MyMap(list);

        String[] result = new String[]{"a", "m", "aa", "ad", "az", "ba"};
        List<String> resultList = Arrays.asList(result);

        System.out.println(myMap.mapLetters());
    }
}
