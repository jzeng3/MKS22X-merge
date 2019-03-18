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
    return;
  }
  public static void mergesort(int[] data, int lo, int hi){
    System.out.println("mergesort "+Arrays.toString(data)+", "+lo+", "+hi);
    if (lo >= hi){
      return;
    }
    int mid = (lo + hi) / 2;
    //System.out.println("mid: "+mid);
    mergesort(data, lo, mid);
    mergesort(data, mid+1, hi);
    merge(data, lo, mid, hi); // merge array at current level
    }

  public static int[] merge(int[] data, int lo, int mid, int hi){
    System.out.println("merge "+Arrays.toString(data)+", "+lo+", "+mid+", "+hi);
    int[] tempLeft = new int[mid - lo +1]; // temporary left array
    int[] tempRight = new int[hi - mid]; // temporary right array
    // copy over values from original array into left, right arrays
    for (int i = 0; i < tempLeft.length; i++){
      tempLeft[i] = data[lo+i];
    }
    for (int i = 0; i < tempRight.length; i++){
      int j = i+mid+1;
    //  System.out.println("i+mid+1: "+j);
      tempRight[i] = data[j];
    }
    System.out.println("templeft: "+Arrays.toString(tempLeft));
    System.out.println("tempright: "+Arrays.toString(tempRight));
    int left = 0; // left array index
    int right = 0; // right array index index
    int merge = lo; // merged array index
    /* Compare current element in left and right array while
       there are still element(s) in both arrays
    */
    while (left < tempLeft.length && right < tempRight.length){
      if (tempLeft[left] <= tempRight[right]){
        data[merge] = tempLeft[left];
        left++;
      //  System.out.println("mergedAry["+i+"]: "+mergedAry[i]);
      }
      else if (tempLeft[left] > tempRight[right]){
        data[merge] = tempRight[right];
        right++;
      //  System.out.println("mergedAry["+i+"]: "+mergedAry[i]);
      }
      merge++;
    }
    // copy over leftover elements from either the left or right array
    while (left < tempLeft.length){
      data[merge] = tempLeft[left];
      left++;
      merge++;
    }
    while (right < tempRight.length){
      data[merge] = tempRight[right];
      right++;
      merge++;
    }

    System.out.println("data: "+Arrays.toString(data));
    return data;
  }

}
