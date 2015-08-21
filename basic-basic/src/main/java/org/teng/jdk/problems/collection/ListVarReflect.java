package org.teng.jdk.problems.collection;

import org.teng.jdk.simple.collection.CollectionUtils;

import java.util.List;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/21
 */
public class ListVarReflect {
    private final List<String> finalList;

    public ListVarReflect(final List<String> finalList) {
        this.finalList = finalList;
    }

    public void add(final String element){
        finalList.add(element);
    }

    public void delete(final String element){
        finalList.remove(element);
    }

    public void delete(){
        if(!CollectionUtils.isEmpty(finalList)){
            finalList.remove(0);
        }
    }


    public void visit(){
        if(!CollectionUtils.isEmpty(finalList)){
            int idx = 0;
            for(String element : finalList){
                System.out.println(idx++ + "::" +element);
            }
        }
    }

    public List<String> getFinalList(){
        return this.finalList;
    }
}
