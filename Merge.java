import java.io.*;
import java.util.*;
public class Merge{
  public static void main(String[] args){
    int[] ary = {0,1,5,32,7,5,3};
    int[] arySub1 = {0,1};
    int[] arySub2 = {5,32};
    mergesort(ary, 0, ary.length - 1);
    int[] merge = sort(arySub1, arySub2);
    System.out.println(Arrays.toString(merge));
  }

  public static void mergesort(int[]data){

  }
  public static void mergesort(int[] data, int lo, int hi){
    System.out.println("mergesort "+Arrays.toString(data)+", "+lo+", "+hi);
    if (lo >= hi){
      System.out.println("return");
      return;
    }
    int mid = (lo + hi) / 2;
    //System.out.println("mid: "+mid);
    int[] tempLeft = new int[mid - lo +1];
    int[] tempRight = new int[hi - mid];
    //System.out.println("tempLeft length: "+tempLeft.length);
    //System.out.println("tempRight length: "+tempRight.length);
    for (int i = 0; i < tempLeft.length; i++){
      tempLeft[i] = data[lo+i];
    }
    for (int i = 0; i < tempRight.length; i++){
      int j = i+mid+1;
    //  System.out.println("i+mid+1: "+j);
      tempRight[i] = data[i+mid+1];
    }
    System.out.println("tempLeft: "+Arrays.toString(tempLeft));
    System.out.println("tempRight: "+Arrays.toString(tempRight));
    mergesort(data, lo, mid);
    mergesort(data, mid+1, hi);
    System.out.println("after mergesort recursion calls");

    }
  //  System.out.println("done with everything");


  public static int[] sort(int[] data1, int[] data2){
    int[] mergedAry = new int[data1.length + data2.length];
    int d1index = 0; // data1 index
    int d2index = 0; // data2 index
    for (int i = 0; i < mergedAry.length; i++){

      if ( (d1index < data1.length && d2index < data2.length
            && data1[d1index] <= data2[d2index]) ||
            d2index >= data2.length){
        mergedAry[i] = data1[d1index];
        d1index++;
        System.out.println("mergedAry["+i+"]: "+mergedAry[i]);
      }
      else{
        mergedAry[i] = data2[d2index];
        d2index++;
        System.out.println("mergedAry["+i+"]: "+mergedAry[i]);
      }
    }
    return mergedAry;
  }

}
