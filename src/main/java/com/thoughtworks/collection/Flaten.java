package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> resultList = new ArrayList<>();
        for (Integer[] row:array){
            for (Integer col:row){
                resultList.add(col);
            }
        }
        return resultList;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        Set<Integer> resultSet = new LinkedHashSet<>();
        for (Integer[] row:array){
            for (Integer col:row){
                resultSet.add(col);
            }
        }
        return new ArrayList<>(resultSet);
    }
}
