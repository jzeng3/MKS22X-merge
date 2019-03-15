import java.io.*;
import java.util.*;
public class Merge{
  public static void main(String[] args){
    int[] ary = {0,1,5,3};

    mergesort(ary, 0, 3);
  }

  public static void mergesort(int[]data){

  }
  public static void mergesort(int[] data, int lo, int hi){
    if (lo >= hi){
      return;
    }
    int mid = (lo + hi) / 2;
    System.out.println("mid: "+mid);
    int[] tempLeft = new int[mid - lo+1];
    int[] tempRight = new int[hi - mid -1];
    System.out.println("temp length: "+tempLeft.length);
    for (int i = 0; i < tempLeft.length; i++){
      tempLeft[i] = data[i];
    }
    for (int i = 0; i < tempRight.length; i++){
      tempRight[i] = data[i+mid+1];
    }
    System.out.println(Arrays.toString(tempLeft));
    System.out.println(Arrays.toString(tempRight));
    mergesort(tempLeft, lo, mid);
    mergesort(tempLeft, mid+1, hi);
  }

}
