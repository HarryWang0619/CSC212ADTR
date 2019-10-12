package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {
	
	// you might want this.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, String> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
		//Assert.assert
	}

	@Test //Code From Lab
	public void testMapGeneral() {
		MapADT<Integer, Integer> squares = new JavaMap<>();
		squares.put(4, 16);
		squares.put(5, 25);
		squares.put(6, 36);

		assertEquals(3, squares.size()); //put works. size works.
		assertEquals((int)25, (int)squares.get(5)); //get works.
		assertIntEq(25, squares.get(5));
		squares.remove(4);
		assertEquals(2, squares.size()); //remove works
		assertEquals((int) 25, (int)squares.remove(5));
		//test size and put
	}

	@Test // bug for remove fixed.
	public void testRemove() {
		MapADT<String, Integer> probablyMap = new JavaMap<>();
		
		probablyMap.put("abc", 1);
		probablyMap.put("def", 2);
		probablyMap.put("ghi", 3);
		probablyMap.put("hahahha this don't follow the naming rule", 93482);

		assertIntEq(93482, probablyMap.get("hahahha this don't follow the naming rule"));
		assertEquals(4, probablyMap.size());
		probablyMap.remove("abc");
		assertEquals(3, probablyMap.size()); 
		//now the first one get removed!
	}	
}
