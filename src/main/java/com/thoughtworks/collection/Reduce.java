package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Reduce {

	List<Integer> arrayList;

	public Reduce(List<Integer> arrayList) {
		this.arrayList = arrayList;
	}

	public int getMaximum() {
		return arrayList.stream()
				.max(Comparator.comparing(Integer::valueOf))
				.get();
	}

	public double getMinimum() {
		return arrayList.stream()
				.min(Comparator.comparing(Integer::valueOf))
				.get();
	}

	public double getAverage() {
		return arrayList.stream()
				.collect(Collectors.averagingDouble((x) -> x));
	}

	public double getOrderedMedian() {
		arrayList = arrayList.stream()
				.sorted()
				.collect(Collectors.toList());
		if (arrayList.size() % 2 == 1) {
			return arrayList.get(arrayList.size() / 2);
		} else {
			return (arrayList.get(arrayList.size() / 2) + arrayList.get(arrayList.size() / 2 - 1)) / 2.0;
		}
	}

	public int getFirstEven() {
		return arrayList.stream()
				.filter((x) -> x % 2 == 0)
				.findFirst()
				.get();
	}

	public int getIndexOfFirstEven() {
		return arrayList.indexOf(getFirstEven());
	}

	public boolean isEqual(List<Integer> arrayList) {
		Collections.sort(this.arrayList);
		Collections.sort(arrayList);
		if(this.arrayList.size()!=arrayList.size())
			return false;
		else{
			for (int i = 0; i < this.arrayList.size(); i++) {
				if(this.arrayList.get(i)!= arrayList.get(i))
					return false;
			}
		}
		return true;
	}

	public Double getMedianInLinkList(SingleLink singleLink) {
		throw new NotImplementedException();
	}

	public int getLastOdd() {
		int oddCount = (int) arrayList.stream()
				.filter(x -> x % 2 == 1)
				.count();
		return arrayList.stream()
				.filter(x -> x % 2 == 1)
				.collect(Collectors.toList())
				.get(oddCount - 1);
	}

	public int getIndexOfLastOdd() {
		return arrayList.indexOf(getLastOdd());
	}
}
