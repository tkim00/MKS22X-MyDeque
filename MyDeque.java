import java.util.*;
import java.lang.*;

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
    //System.out.println(data.length);
    // for (int i = 0; i < data.length; i++) {
    //   System.out.print(data[i]);
    // }
    String str = "{";
    int s = start;
    int e = end;
    // if (s >= e) {
    //   for (int i = 0; i < size; i++) {
    //     if (s < 0) {
    //       s = data.length-1;
    //     }
    //     str+=data[s]+" ";
    //     s++;
    //   }
    // } else {
    //   for (int i = 0; i < size; i++) {
    //     if (s > data.length-1) {
    //       s = 0;
    //     }
    //     str+=data[s]+" ";
    //     s++;
    //   }
    // }
    for (int i = 0; i < size; i++) {
      if (s > data.length-1) {
        s = 0;
      }
      str+=data[s] + ", ";
      s++;
    }
    //str = str.trim();
    if (str.length() > 2) {  //simply for aesthetic purpose
      str = str.substring(0, str.length()-2);
    }
    // str = str.strip(",");
    str+="}";
    return str;
  }
  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if (size == data.length) {
      resize();
    }
    if (size == 0) {
      data[start] = element;
      size++;
    } else {
      if (start > 0) { //com
        data[start-1] = element;
        start--;
        size++;
      } else {
        //{ //compare start and end
        data[data.length-1] = element;
        start = data.length-1;
        size++;
      }
    }
  }
  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if (size == data.length) {
      resize();
    }
    if (size == 0) {
      data[end] = element;
      size++;
    } else {
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
  }
  public E removeFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    E element = data[start];
    if (size == 1) {
      data[start] = null;
      size--;
    } else {
      if (start < data.length-1) {
        data[start] = null;
        start++;
        size--;
      } else {
        data[start] = null;
        start = 0;
        size--;
      }
    }
    return element;
  }
  public E removeLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    E element = data[end];
    if (size == 1) {
      data[end] = null;
      size--;
    } else {
      if (end > 0) {
        data[end] = null;
        end--;
        size--;
      } else {
        data[end] = null;
        end = data.length-1;
        size--;
      }
    }
    return element;
  }
  public E getFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[start];
  }
  public E getLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[end];
  }
  private void resize() {
    E[] temp = (E[])new Object[size*2];
    //System.out.println(size);
    // if (end < start) {
    //   int k = 0;
    //   for (int i = start; i < data.length; i++) {
    //     temp[k] = data[i];
    //     k++;
    //   }
    //   for (int i = 0; i <= end; i++) {
    //     temp[k] = data[i];
    //     k++;
    //   }
    //   end = k;
    // } else {
    //   int k = 0;
    //   for (int i = start; i <= end; i++) {
    //     temp[k] = data[i];
    //     k++;
    //   }
    //   end = k;
    // }
    int s = start;
    int e = end;
    for (int i = 0; i < size; i++) {
      if (s > data.length-1) {
        s = 0;
      }
      temp[i] = data[s];
      s++;
    }
    start = 0;
    end = data.length-1; //this fixed it <-------
    data = Arrays.copyOf(temp, temp.length);
  }
}
