package misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class YearWithHighestPopulation {
	
	private List<Integer> personYears(int[] birthsdays, int[] deaths, int index){
		return IntStream.range(birthsdays[index], deaths[index] + 1).boxed().collect(Collectors.toList());
	}
	
	private int yearWithMaxPopulation(final Map<Integer, Integer> yearMap) {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer year1, Integer year2) {
				Integer populationY1 = yearMap.get(year1);
				Integer populationY2 = yearMap.get(year2);
				return populationY2.compareTo(populationY1);
			}
		};
        TreeMap<Integer, Integer> sorted_map = new TreeMap<Integer, Integer>(comparator);
        sorted_map.putAll(yearMap);
        return sorted_map.firstKey();
	}
	
	int findYear(int[] birthsdays, int[] deaths) {
		final int n = deaths.length;
		final Map<Integer, Integer> yearMap = new HashMap<>();
		for(int i = 0; i < n; i++) {
			personYears(birthsdays, deaths, i).forEach(year -> {
				yearMap.put(year, yearMap.getOrDefault(year, 0) + 1);
			});
		}
		return yearWithMaxPopulation(yearMap);
	}
	
	int findYearNlogN(int[] birthsdays, int[] deaths) {
		final int n = deaths.length;
		final Map<Integer, Integer> yearMap = new HashMap<>();
		for(int i = 0; i < n; i++) {
			int byear = birthsdays[i];
			int dyear = deaths[i];
			yearMap.put(byear, yearMap.getOrDefault(byear, 0) + 1);
			yearMap.put(dyear, yearMap.getOrDefault(dyear, 0) - 1);
		}
		return yearWithMaxPopulation(yearMap);
	}

	int yearToIndex(int year, int min) {
		return year - min;
	}
	int indexToYear(int index, int min) {
		return index + min;
	}
	
	int maxYear(int[] arr, int min) {
		int max = 0;
		int sum = 0;
		int imax = 0;
		for(int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			if(sum > max) {
				imax = i;
				max = sum;
			}
		}
		return indexToYear(imax, min);
	}
	
	int findYearN(int[] birthsdays, int[] deaths) {
		final int n = deaths.length;
		final int min = Arrays.stream(birthsdays).min().getAsInt();
		final int max = Arrays.stream(deaths).max().getAsInt();
		final int[] arr = new int[max - min + 1];
		for(int i = 0; i < n; i++) {
			int byear = birthsdays[i];
			int dyear = deaths[i];
			arr[yearToIndex(byear, min)]++;
			arr[yearToIndex(dyear, min)]--;
		}
		return maxYear(arr, min);
	}
	
	@Test
	public void testPersonYears(){
		Assert.assertEquals(Arrays.asList(2020, 2021), personYears(new int[] {2020}, new int[] {2021}, 0));
		Assert.assertEquals(Arrays.asList(2020, 2021, 2022), personYears(new int[] {2020}, new int[] {2022}, 0));
	}

	@Test
	public void testYearWithMaxPopulation(){
		final Map<Integer, Integer> yearMap = new HashMap<>();
		yearMap.put(1983, 10);
		yearMap.put(1992, 21);
		yearMap.put(1991, 17);
		Assert.assertEquals(1992, yearWithMaxPopulation(yearMap));
	}
	
	@Test
	public void testFinsYearsNxN(){
		Assert.assertEquals(1973, findYear(new int[] {1950, 1931, 1973}, new int[] {2020, 1999, 2031}));
	}

	@Test
	public void testFindYearsN(){
		Assert.assertEquals(1973, findYearN(new int[] {1950, 1931, 1973}, new int[] {2020, 1999, 2031}));
	}

	@Test
	public void testFinsYearsNlogN(){
		Assert.assertEquals(1973, findYearNlogN(new int[] {1950, 1931, 1973}, new int[] {2020, 1999, 2031}));
	}


}
