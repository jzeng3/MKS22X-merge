import java.io.*;
import java.util.*;
public class Merge{
  public static void main(String[] args){
    int[] ary = {32,5,1,0,7,5,3};
    int[] arySub1 = {1,4,7,9};
    int[] arySub2 = {5,32};
    mergesort(ary, 0, ary.length - 1);
    System.out.println(Arrays.toString(ary));
    //int[] merge = sort(arySub1, arySub2);
    //System.out.println(Arrays.toString(merge));
  }

  public static void mergesort(int[]data){
    mergesort(data,0,data.length-1);
  }
  public static void mergesort(int[] data, int lo, int hi){
  //  System.out.println("mergesort "+Arrays.toString(data)+", "+lo+", "+hi);
    if (lo >= hi){
    //  System.out.println("return");
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
    System.out.println("AFTER MERGESORT CALLS");
    System.out.println("tempLeft: "+Arrays.toString(tempLeft));
    System.out.println("tempRight: "+Arrays.toString(tempRight));
    int[] mergedAry = new int[tempLeft.length + tempRight.length];
    mergedAry = merge(data, lo, mid, hi); // merge array at current level
    }
  //  System.out.println("done with everything");

  public static int[] merge(int[] data, int lo, int mid, int hi){
    int[] tempLeft = new int[mid - lo +1];
    int[] tempRight = new int[hi - mid];
    System.out.println(Arrays.toString(tempLeft));
    System.out.println(Arrays.toString(tempRight));
    int[] mergedAry = new int[tempLeft.length + tempRight.length];
    int left = 0; // left array index
    int right = 0; // right array index index
    for (int i = 0; i < mergedAry.length; i++){

      if ( (left < tempLeft.length && right < tempRight.length
            && tempLeft[left] <= tempRight[right]) ||
            right >= tempRight.length){
        mergedAry[i] = tempLeft[left];
        left++;
        System.out.println("mergedAry["+i+"]: "+mergedAry[i]);
      }
      else{
        mergedAry[i] = tempRight[right];
        right++;
        System.out.println("mergedAry["+i+"]: "+mergedAry[i]);
      }
    }
    return mergedAry;
  }

}
