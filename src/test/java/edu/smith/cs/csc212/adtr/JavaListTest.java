package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;
import edu.smith.cs.csc212.adtr.real.JavaList;


public class JavaListTest {
	
	/**
	 * Make a new empty list.
	 * @return an empty list to be tested.
	 */
	private <T> ListADT<T> makeEmptyList() {
		return new JavaList<>();
	}
	
	/**
	 * Helper method to make a full list.
	 * @return [a, b, c, d] - a small, predictable list for many tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = makeEmptyList();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		return data;
	}
		
	@Test
	public void testEmpty() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(0, data.size());
		Assert.assertEquals(true, data.isEmpty());
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeBack();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(3);
	}

	@Test
	public void testAddToFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-2");
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
	}


	// Test list addToBack.
	@Test 
	public void addToBack() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addBack("B");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("B", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addBack("a");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("a", data.getIndex(1));
		data.addBack("c");
		data.addBack("k");
		Assert.assertEquals(4, data.size());
		Assert.assertEquals("c", data.getIndex(2));
		Assert.assertEquals("k", data.getIndex(3));

		// "B" -> "a" -> "c" -> "k"
	}


	// Test list remove
	// First Remove from empty!
	@Test(expected = EmptyListError.class)
	public void testRemoveEmpty() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(0);
		data.removeFront();
		data.removeBack();
	}

	// Second Remove Bad Index!
	@Test(expected = BadIndexError.class)
	public void testRemoveBadIndex() {
		ListADT<String> data = makeEmptyList();
		data.addBack("1");
		data.removeIndex(10);
	}
	
	// Then normal remove test!
	@Test  // remove back, remove front, remove index!
	public void testRemove() {
		ListADT<String> data = makeEmptyList();
		data.addBack("r");
		data.addBack("e");
		data.addBack("m");
		data.addBack("o");
		data.addBack("v");
		data.addBack("i");
		data.addBack("n");
		data.addBack("g");
		Assert.assertEquals(8, data.size());
		Assert.assertEquals("r", data.getFront());
		Assert.assertEquals("e", data.getIndex(1));
		Assert.assertEquals("m", data.getIndex(2));
		data.removeBack();
		data.addFront("?");
		Assert.assertEquals(8, data.size());
		Assert.assertEquals("?", data.getFront());
		data.removeFront();
		data.removeIndex(6);
		data.removeIndex(5);
		Assert.assertEquals(5, data.size());
		data.addBack("e");
		data.addBack("d");
	}


	
	// Test addIndex methods.
	@Test
	public void testAddIndex(){
		ListADT<String> data = new JavaList(); // old school add list ; )
		data.addIndex(0, "First");
		data.addIndex(1, "Second");
		data.addIndex(2, "Fourth");
		assertEquals("First", data.getFront());
		assertEquals(3, data.size());
		data.addIndex(2, "Third");
		assertEquals(4, data.size());
		assertEquals(data.getIndex(3), "Fourth");
		assertEquals(data.getIndex(2), "Third");
		data.addIndex(4, "Fünfte"); //This is german
		assertEquals(data.getIndex(4), "Fünfte");
		assertEquals(5, data.size());
	}


	@Test
	public void testGetFront() {
		ListADT<String> data = makeFullList();
		assertEquals("a", data.getFront());
	}
	
	@Test
	public void testGetBack() {
		ListADT<String> data = makeFullList();
		assertEquals("d", data.getBack());
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.getFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.getBack();
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexLow() {
		ListADT<String> data = makeFullList();
		data.getIndex(-2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size());
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size()*2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()*2, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHigh() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()+1, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexLow() {
		ListADT<String> data = makeFullList();
		data.addIndex(-1, "the");
	}
	
	// Write some tests for setIndex.
	@Test
	public void testSetIndex() {
		ListADT<String> data = makeEmptyList();
		data.addIndex(0, "");
		data.addIndex(1, "");
		assertEquals(2, data.size());
		assertEquals("", data.getIndex(0));
		data.setIndex(1, "value");
		data.setIndex(0, "value");
		assertEquals("value", data.getIndex(1));
		assertEquals("value", data.getIndex(0));
		assertEquals(2, data.size());
	}
	
	@Test
	public void testToJava() {
		assertEquals(makeFullList().toJava(), Arrays.asList("a", "b", "c", "d"));
	}
	
	@Test
	public void testEquals() {
		assertEquals(makeFullList(), new JavaList<>(Arrays.asList("a", "b", "c", "d")));
	}
	
	@Test
	public void testEquals2() {
		assertEquals(makeFullList(), makeFullList());
	}
}
