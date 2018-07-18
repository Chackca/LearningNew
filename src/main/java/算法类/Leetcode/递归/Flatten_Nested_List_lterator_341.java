package 算法类.Leetcode.递归;

import java.util.Iterator;
import java.util.List;

/**
 * 给出一个嵌套的整型列表。列表中的项或者为一个整数，或者是另一个列表。
 * 设计一个迭代器，遍历这个整型列表中的所有整数
 * 如[[1,1],2,[1,1]]
 * 如[1,[4,[6]]]
 *
 * 思想：在调用hasNext的时候，将NestedInteger拆分，
 * 然后将第一个元素保存到域变量中即可。其他元素添加到链表的首部。
 */
public class Flatten_Nested_List_lterator_341 {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation*/
     public interface NestedInteger {

         // @return true if this NestedInteger holds a single integer, rather than a nested list.
         public boolean isInteger();
         // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();

         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
     }

    public class NestedIterator implements Iterator<Integer> {
        List<NestedInteger> nestedList;
        int data;
        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
        }

        @Override
        public Integer next() {
            return data;
        }

        @Override
        public boolean hasNext() {
            while(nestedList != null && nestedList.size() > 0){
                NestedInteger tmpInt = nestedList.remove(0);
                if(tmpInt.isInteger()){
                    data = tmpInt.getInteger();
                    return true;
                }else{
                    nestedList.addAll(0,tmpInt.getList());
                }
            }
            return false;
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext())
 *      v[f()] = i.next();
 */
}
