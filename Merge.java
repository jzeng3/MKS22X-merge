import java.io.*;
import java.util.*;
public class Merge{
  public static void main(String[] args){
    int[] ary = {0,1,5,32,7,5,3};

    mergesort(ary, 0, ary.length - 1);
  }

  public static void mergesort(int[]data){

  }
  public static void mergesort(int[] data, int lo, int hi){
    System.out.println("mergesort "+Arrays.toString(data)+", "+lo+", "+hi);
    if (lo >= hi){
      return;
    }
    int mid = (lo + hi) / 2;
    System.out.println("mid: "+mid);
    int[] tempLeft = new int[mid - lo+1];
    int[] tempRight = new int[hi - mid];
    System.out.println("tempLeft length: "+tempLeft.length);
    System.out.println("tempRight length: "+tempRight.length);
    for (int i = 0; i < tempLeft.length; i++){
      tempLeft[i] = data[lo+i];
    }
    for (int i = 0; i < tempRight.length; i++){
      int j = i+mid+1;
      System.out.println("i+mid+1: "+j);
      tempRight[i] = data[i+mid+1];
    }
    System.out.println(Arrays.toString(tempLeft));
    System.out.println(Arrays.toString(tempRight));
    mergesort(data, lo, mid);
    mergesort(data, mid+1, hi);
  }

}
