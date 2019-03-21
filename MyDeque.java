public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    start = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String s = "{";
    for (int i = start; i < size; i++) {
      s+=data[i]+" ";
    }
    return s += "}";
  }
  public void addFirst(E element){
    if (start > 0) {
      data[start-1] = element;
      start--;
      size++;
    } else {
      data[data.length-1] = element;
      start = data.length-1
      size++;
    }
  }
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
}
