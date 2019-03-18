import java.io.*;
import java.util.*;
public class Merge{

  public static void main(String[]args){
  /*  int[] array = {31,5,7,5,3,1,1,5};
    mergesort(array);
    System.out.println(Arrays.toString(array));*/
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long mtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Merge.mergesort(data2);
        t2 = System.currentTimeMillis();
        mtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*mtime/btime);
    }
    System.out.println();
  }
}

  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    // mergesort(data,0,data.length -1);
    int[] copy = new int[data.length];
    for (int i = 0; i < data.length; i++){
      copy[i] = data[i];
    }
    mergesort(data,copy,0,data.length-1);
  }
  public static void mergesort(int[] data, int[] copy, int lo, int hi){
    if (lo >= hi){
      return;
    }
    int mid = (lo + hi) / 2; // middle index between lo and hi
    // call mergesort on left and right sections of the array
    mergesort(copy, data, lo, mid);
    mergesort(copy, data, mid+1, hi);
    // merge array at current level
    merge(data,copy, lo, mid, hi);
  }
  public static void merge(int[] data, int[] copy, int lo, int mid, int hi){
    int left = lo;
    int right = mid + 1;
    int merge = lo;
    int leftLength = mid - lo + 1;
    int rightLength = hi - mid;
    //System.out.println("merge: "+Arrays.toString(data) + Arrays.toString(copy)+" "+lo+" "+mid+" "+hi);
    while (left <= mid && right <= hi){
      if (copy[left] <= copy[right]){
      //  System.out.println("copy left < right" + copy[left] +" < "+copy[right]);
        data[merge] = copy[left];
        left++;
      //  System.out.println("mergedAry["+i+"]: "+mergedAry[i]);
      }
      else if (copy[left] > copy[right]){
        //  System.out.println("copy left > right" + copy[left] +" > "+copy[right]);
        data[merge] = copy[right];
        right++;
      //  System.out.println("mergedAry["+i+"]: "+mergedAry[i]);
      }
      merge++;
    }
    // copy over leftover elements from either the left or right array
    while (left <= mid){
      data[merge] = copy[left];
      left++;
      merge++;
    }
    while (right <= hi){
      data[merge] = copy[right];
      right++;
      merge++;
    }
//    System.out.println("data: "+Arrays.toString(data));
//    System.out.println("copy: "+Arrays.toString(copy));

  }
  // takes low and high indices, splits array, then sorts and merges subsections
  public static void mergesort(int[] data, int lo, int hi){
    // return if reached smallest subsection of array
    if (lo >= hi){
      return;
    }
    int mid = (lo + hi) / 2; // middle index between lo and hi
    // call mergesort on left and right sections of the array
    mergesort(data, lo, mid);
    mergesort(data, mid+1, hi);
    // merge array at current level
    merge(data, lo, mid, hi);
    }

  // merge sorts and merges array at given low, mid, and high indices
  public static void merge(int[] data, int lo, int mid, int hi){
    int[] tempLeft = new int[mid - lo +1]; // temporary left array
    int[] tempRight = new int[hi - mid]; // temporary right array
    // copy over values from original array into left, right arrays
    for (int i = 0; i < tempLeft.length; i++){
      tempLeft[i] = data[lo+i];
    }
    for (int i = 0; i < tempRight.length; i++){
      int j = i+mid+1;
      tempRight[i] = data[j];
    }
    //System.out.println("templeft: "+Arrays.toString(tempLeft));
    //System.out.println("tempright: "+Arrays.toString(tempRight));
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

  }

}
