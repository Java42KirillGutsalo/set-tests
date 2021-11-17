package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetTests {
private static final int N_RANDOM_NUMBERS = 10000;
Integer[] initialNumbers = {
	10, 20, 40, 60	
};
Set<Integer> set;
	@BeforeEach
	void setUp() throws Exception {
		set = new TreeSet<>();
		fillSet();
	}

	private  void fillSet() {
		fillSetFromArray(set, initialNumbers);
		
		
	}

	private <T> void fillSetFromArray(Set<T> res, T[] array) {
		
		for(T num: array) {
			res.add(num);
		}
		
	}
	
	private Integer[] getRandomNumbers() {
		Integer[] res = new Integer[N_RANDOM_NUMBERS];
		for (int i = 0; i < res.length; i++) {
			res[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}
		return res;
		
	}

	@Test
	void addTest() {
		assertEquals(initialNumbers.length, set.size());
		for(Integer num: initialNumbers) {
			assertTrue(set.contains(num));
		}
		assertTrue(set.add(80));
		assertFalse(set.add(80));
		
	}
	@Test
	void containsTest() {
		assertTrue(set.contains(60));
		assertFalse(set.contains(80));
	}
	@Test
	void iteratorNoRemoveTest() {
		Integer[] randomNumbers = getRandomNumbers();
		Set<Integer> numbersSet = new TreeSet<>();
		fillSetFromArray(numbersSet, randomNumbers);
		Arrays.sort(randomNumbers);
		assertArrayEquals(randomNumbers, getArrayFromSet(numbersSet));
	}
	@Test
	void treeSetInsensitiveOrderTest () {
		 String strings[] = {"Boris", "Asaf", "android", "band"};
		 String expected[] = {"android", "Asaf", "band", "Boris"};
		 TreeSet<String> treeSet = new TreeSet<>((s1, s2) -> (s1.compareToIgnoreCase(s2)));
		 fillSetFromArray(treeSet, strings);
		 assertArrayEquals(expected, getArrayFromSet(treeSet));
	}
	@SuppressWarnings("unchecked")
	private <T> T[] getArrayFromSet(Set<T> set) {
		T res[] = (T[]) new Object[set.size()];
		int ind = 0;
		for(T obj: set) {
			res[ind++] = obj;
		}
		return res;
	}
	

}