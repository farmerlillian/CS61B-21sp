package deque;

import org.junit.Test;

public class ArrayDeque<T> implements deque.Deque<T>{

    private T[] item;
    private int size;

    public ArrayDeque(){
        item=(T[]) new Object[8];
        size=0;
    }

@Override
    public void addFirst(T item) {
        for(int i=size;i>0;i--){
            this.item[i]= this.item[i-1];
        }
        this.item[0]=item;
        size+=1;
    }

@Override
    public void addLast(T t) {
        item[size]=t;
        size+=1;

    }


@Override
    public T removeFirst() {
        T first=get(0);
        for(int i=0;i<size;i++){
            item[i]=item[i+1];
        }
        size-=1;
        return first;
    }

@Override
    public T removeLast() {
        T last=get(size-1);
        size-=1;
        return last;
    }

@Override
    public int size() {
        return size;
    }
@Override
    public void printDeque(){
        for(int i=0;i<size;i++){
            System.out.print(get(i)+" ");
        }
        System.out.println();
    }
@Override
    public T get(int index){
        if (index<0 || index>=size){
            return null;
        }
        return item[index];
    }

}