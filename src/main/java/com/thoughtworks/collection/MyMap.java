package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
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
		return array.stream()
				.map((x) -> {
					StringBuffer stringBuffer = new StringBuffer();
					while (x > 0) {
						stringBuffer.append(
								letters[(x % 26) == 0 ?
										25 :
										(x % 26) - 1]);
						if (x % 26 == 0) x--;
						x /= 26;
					}
					return stringBuffer.reverse().toString();
				})
				.collect(Collectors.toList());
	}

	public List<Integer> sortFromBig() {
		return array.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
	}

	public List<Integer> sortFromSmall() {
		return array.stream()
				.sorted()
				.collect(Collectors.toList());
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
