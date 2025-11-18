package ch02.seq;

public interface IList {

    public void clear();
    public boolean isEmpty();
    public int length();
    public  Object get();
    public void insert(int i,Object x);
    public void remove(int i);
    public int index (Object x);
    public void display();
}
