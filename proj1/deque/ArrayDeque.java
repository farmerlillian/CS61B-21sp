package deque;

import org.junit.Test;

public class ArrayDeque<T> implements deque.Deque<T>{

    private T[] item;
    private int size;
    private int capacity;

    public ArrayDeque(){
        item=(T[]) new Object[8];
        size=0;
        capacity=8;
    }
private void resize(){
        if (size>=capacity){
        capacity=2*size;
        T[] a=(T[]) new Object[capacity];
        System.arraycopy(item,0,a,0,size);
        item=a;
        }
        if (size<0.25*capacity&&capacity>=16){
            capacity=capacity/2;
            T[] a=(T[]) new Object[capacity];
            System.arraycopy(item,0,a,0,size);
            item=a;
        }

}
@Override
    public void addFirst(T item) {
        resize();
        for(int i=size;i>0;i--){
            this.item[i]= this.item[i-1];
        }
        this.item[0]=item;
        size+=1;
    }

@Override
    public void addLast(T t) {
        resize();
        item[size]=t;
        size+=1;

    }


@Override
    public T removeFirst() {
        if (size==0){
            return null;
        }
        T first=get(0);
        for(int i=0;i<size;i++){
            item[i]=item[i+1];
        }
        size-=1;
        resize();
        return first;
    }

@Override
    public T removeLast() {
    if (size==0){
        return null;
    }
        T last=get(size-1);
        size-=1;
        resize();
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
