public class Merge{
  public static void mergesort(int[]data){

  }
  public static void mergesort(int[] data, int lo, int hi){
    if (lo >= hi){
      return;
    }
    int mid = (lo + hi) / 2;
    mergesort(data, lo, mid);
    mergesort(data, mid+1, hi);
  }

}
