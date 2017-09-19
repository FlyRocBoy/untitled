package Collection;

import java.io.Serializable;
import java.util.*;

/**
 * Created by gaopeng on 2017/6/28.
 */
public class MyLinkedList<GP> extends AbstractSequentialList<GP> implements Serializable{

    //ͷָ�� ����ӡ
    private transient Entry<GP> header=new Entry<GP>(null,null,null);
    //�����С ����ӡ
    private transient int size=0;
    @Override
    public ListIterator<GP> listIterator(int index) {
        return new MyListIterator<GP>();
    }

    //˫��������
    private static class Entry<E>{
        private E e;
        private Entry<E> pr;
        private Entry<E> next;
        Entry(){

        }
        Entry(E e,Entry<E> pre,Entry<E> next){
            this.e=e;
            this.pr=pre;
            this.next=next;
        }
    }

    private class MyListIterator<E> implements ListIterator<E>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }

    @Override
    public int size() {
        return size;
    }

}
