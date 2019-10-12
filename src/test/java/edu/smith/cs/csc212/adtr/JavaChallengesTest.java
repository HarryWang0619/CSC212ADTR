package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import javax.swing.event.ChangeEvent;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaChallengesTest {
    @Test
	public void testEmptyUnion() {
		SetADT<Integer> left = new JavaSet();
		SetADT<Integer> right = new JavaSet();
        SetADT<Integer> empty = Challenges.union(left, right);
        assertEquals(left.size(), 0);
        assertEquals(right.size(), 0);
        assertEquals(empty.size(), 0);
    }
    
    @Test
	public void testEmptyIntersection() {
        SetADT<Integer> left = new JavaSet();
		SetADT<Integer> right = new JavaSet();
        SetADT<Integer> empty = Challenges.intersection(left, right);
        assertEquals(left.size(), 0);
        assertEquals(right.size(), 0);
        assertEquals(empty.size(), 0);
    }
    
    @Test
	public void testEmptyWordCount() {
        ListADT<String> input = new JavaList();
        MapADT<String, Integer> empty = new JavaMap<>();
        empty = Challenges.wordCount(input);
        assertEquals(input.size(), 0);
        assertEquals(empty.size(), 0);
    }
    
    @Test
    public void testUnion() {
        SetADT<Integer> left = new JavaSet();
        SetADT<Integer> right = new JavaSet();
        left.insert(1);
        left.insert(2);
        left.insert(3);
        right.insert(3);
        right.insert(4);
        right.insert(5);
        assertEquals(left.size(), 3);
        assertEquals(right.size(), 3);
        SetADT<Integer> output = Challenges.union(left, right);
        assertEquals(output.size(), 5);
    }

    @Test
    public void testIntersection() {
        SetADT<Integer> left = new JavaSet();
        SetADT<Integer> right = new JavaSet();
        left.insert(1);
        left.insert(2);
        left.insert(3);
        right.insert(3);
        right.insert(4);
        right.insert(5);
        assertEquals(left.size(), 3);
        assertEquals(right.size(), 3);
        SetADT<Integer> output = Challenges.intersection(left, right);
        assertEquals(output.size(), 1);
    }

    @Test
    public void testWordCount() {
        ListADT<String> in = new JavaList();
        in.addBack("A");
        in.addBack("B");
        in.addBack("C");
        in.addBack("D");
        in.addBack("E");
        MapADT out = Challenges.wordCount(in);
        assertEquals(out.size(), 5);
        assertEquals(out.get("A"), 1);
        assertEquals(out.get("E"), 5);
    }
}