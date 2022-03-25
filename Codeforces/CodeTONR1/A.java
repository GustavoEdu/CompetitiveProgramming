import java.io.*;
import java.util.*;
public class A {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t, n, iFromSorted, jFromSorted, i, j;
    String[] input;
    int[] arr, copy, result;
    t = Integer.parseInt(br.readLine());
    for(int r = 0; r < t; r++) {
      n = Integer.parseInt(br.readLine()); 
      input = br.readLine().split(" ");
      arr = parseToIntArray(input);
      copy = getCopy(arr);
      Arrays.sort(arr);
      result = getIndexesOfGoodPairs(arr, n);
      iFromSorted = result[0];
      jFromSorted = result[1];
      i = findItem(copy, arr[iFromSorted]);
      j = findItem(copy, arr[jFromSorted]);
      System.out.printf("%d %d%n", i + 1, j + 1);
    }
    br.close();
  }
  public static int findItem(int[] arr, int wanted) {
    for(int i = 0; i < arr.length; i++) {
      if(wanted == arr[i]) { return i; }
    }
    return -1;
  }
  public static int[] getIndexesOfGoodPairs(int[] arr, int n) {
    int[] result = new int[2];
    int j;
    for(int i = 0; i <= Math.ceil(n / 2); i++) {
      j = n - i - 1;
      if(areTheyGoodPairs(arr, i, j)) {
        result[0] = i;
        result[1] = j;
        return result;
      }
    }
    return null;
  }
  public static boolean areTheyGoodPairs(int[] arr, int i, int j) {
    int ai, aj, diff;
    ai = arr[i];
    aj = arr[j];
    diff = Math.abs(ai - aj);
    for(int k = 0; k < arr.length; k++) {
      if((Math.abs(ai - arr[k]) + Math.abs(arr[k] - aj)) != diff) {
        return false;
      }
    }
    return true;
  }
  public static void showArray(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
  public static int[] getCopy(int[] arr) {
    int[] result = new int[arr.length];
    for(int i = 0; i < arr.length; i++) {
      result[i] = arr[i];
    }
    return result;
  }
  public static int[] parseToIntArray(String[] input) {
    int[] result = new int[input.length];
    for(int i = 0; i < input.length; i++) {
      result[i] = Integer.parseInt(input[i]);
    }
    return result;
  }
}
