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
    end = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String str = "{";
    int s = start;
    int e = end;
    if (s >= e) {
      for (int i = 0; i < size; i++) {
        if (s < 0) {
          s = data.length-1;
        }
        str+=data[s]+" ";
        s--;
      }
    } else {
      for (int i = 0; i < size; i++) {
        if (s > data.length-1) {
          s = 0;
        }
        str+=data[s]+" ";
        s++;
      }
    }
    str += "}";
    return str;
  }
  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    // if (size > data.length) {
    //   resize();
    // }
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
  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    // if (size > data.length) {
    //   resize();
    // }
    if (end < data.length-1) {
      data[end+1] = element;
      end++;
      size++;
    } else {
      data[0] = element;
      end = 0;
      size++;
    }
  }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
}
