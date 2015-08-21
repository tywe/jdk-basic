package org.teng.jdk.problems.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/21
 */
public class ListVarReflectTest {

    private final List<String> finalList = new ArrayList<>(2);
    private ListVarReflect lvr = new ListVarReflect(finalList);

    @Test
    public void testAdd(){
        lvr.add("a");
        lvr.add("b");
        lvr.add("c");
        lvr.visit();
    }

    @Test
    public void testVarIter(){
        lvr.add("a");
        lvr.add("b");
        lvr.add("c");
        lvr.delete();
        lvr.visit();

        int idx = 0;
        Iterator<String> iter = lvr.getFinalList().listIterator();
        lvr.delete("c");
        lvr.visit();

        while(iter.hasNext()){
            System.out.println(idx++ + "::" + iter.next());
        }
    }
}