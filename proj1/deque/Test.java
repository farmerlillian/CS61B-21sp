package deque;

import deque.ArrayDeque;


public class Test {
    public static void main(String[] args) {
        ArrayDeque<Integer> a=new ArrayDeque<>();
        for(int i=0;i<3;i++){
            a.addFirst(i);
        }
        for(int i=0;i<3;i++){
            a.addLast(i);
        }
        a.printDeque();
        System.out.println(a.removeFirst());
        System.out.println(a.removeLast());
        System.out.println(a.removeFirst());
        System.out.println(a.removeLast());
    }
}