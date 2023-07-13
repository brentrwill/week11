package projects;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
		
		/**
		 * Custom
		 */
		Collections.sort(list, new NaturalComparator());
		System.out.println(list);
		
		Collections.sort(list, new SortReverseComparator());
		System.out.println(list);
		
		/**
		 * Streams
		 */
		List<Integer> sortedList = list.stream()
		      .sorted()
		      .collect(Collectors.toList());
		// System.out.println(sortedList);
		
		/**
		 * Lambdas
		 */
		list.sort((Integer int1, Integer int2) -> int1.compareTo(int2));
		System.out.println(list);
		
		list.sort((Integer int1, Integer int2) -> int2.compareTo(int1));
		System.out.println(list);
	}
	
	public static class NaturalComparator implements Comparator<Integer> {
		@Override
    	public int compare(Integer int1, Integer int2) {
			return int1.compareTo(int2);
		}
	}
	
	public static class SortReverseComparator implements Comparator<Integer> {
		@Override
    	public int compare(Integer int1, Integer int2) {
			return int2.compareTo(int1);
		}
	}
}
