package deque;
import deque.MaxArrayDeque;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {
    @Test
    public void maxWithoutComparatorTest(){
        MaxArrayDeque<Integer> arr=new MaxArrayDeque<>(new IntComparator());
        for(int i=5;i>0;i--){
            arr.addLast(i);
        }
        assertEquals((Integer) 5,arr.max());
    }
@Test
    public void maxWithComparatorTest(){
        MaxArrayDeque<String> arr=new MaxArrayDeque<>(new StringComparator());
        arr.addLast("I love CS61B");
        arr.addLast("I love CS61B");
        assertEquals("I love CS61B",arr.max());
        assertEquals("I love CS61B",arr.max(new StringLengthComparator()));
    }
    public static class IntComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }

    public static class StringComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            int l1=o1.length();
            int l2=o2.length();
            for (int i=0;i<Math.min(l1,l2);i++){
                int o1char=o1.charAt(i);
                int o2char=o2.charAt(i);
                if (o1char!=o2char){
                    return o1char-o2char;
                }
            }
            if (l1!=l2){
                return l1-l2;
            }
            return 0;
        }
    }

    public static class StringLengthComparator implements Comparator<String >{

        @Override
        public int compare(String o1, String o2) {
            return o1.length()-o2.length();
        }
    }
}
