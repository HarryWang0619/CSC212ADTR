/** Okay
 * Here we Go the SET
 * Most code from Lab Session 
 * 
 * 三(: >)-I--く
 * 
 * 
*/
package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}

	@Test // from Lab session
	public void testGeneral() {
		SetADT<String> single = new JavaSet<>();
		single.insert("Z");
		assertEquals(1, single.size());// insert work
		assertEquals(true, single.contains("Z")); //insert contains work
		assertNotEquals(true, single.contains("A"));
		single.remove("W"); 
		assertEquals(1, single.size());//remove work
		single.remove("Z");
		assertEquals(0, single.size());

		SetADT<String> notSingle = new JavaSet<>();
		notSingle.insert("N");
		notSingle.insert("P");

		assertEquals(2, notSingle.size());
		assertEquals(true, notSingle.contains("P"));
		assertEquals(false, notSingle.contains("="));
		assertEquals(true, notSingle.contains("N"));
		assertEquals(true, notSingle.contains("P"));

		notSingle.remove("P"); // REMOVE P FROM notSingleEEEEEE----!!!
		//MUAHAHAHA N is single now
		assertEquals(false, notSingle.contains("P"));
		assertEquals(1, notSingle.size());
	}

	@Test
	public void testRepeatedInserts() {
		SetADT<String> items = new JavaSet<>();
		items.insert("A");
		items.insert("B");
		items.insert("C");

		assertEquals(true, items.contains("A"));
		assertEquals(true, items.contains("B"));
		assertEquals(true, items.contains("C"));
		assertEquals(false, items.contains("P"));
		assertEquals(3, items.size());

		for (int i = 1; i<10; i++) {
			items.insert("C");
		}
		assertEquals(3, items.size());

		items.remove("B");
		items.remove("C");
		assertEquals(1, items.size());
		assertEquals(false, items.contains("C"));
		assertEquals(false, items.contains("B")); // everything works!
	}
	
}
