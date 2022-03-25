import java.util.*;
public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t, x, y, result;
    String[] input;
    t = Integer.parseInt(sc.nextLine());

    for(int i = 0; i < t; i++) {
      input = sc.nextLine().split(" ");
      x = Integer.parseInt(input[0]);
      y = Integer.parseInt(input[1]);
      result = countMoves(x, y);
      System.out.println(result);
    }
    sc.close();
  }
  public static int countMoves(int x, int y) {
    if(x == 0 && y == 0) {
      return 0;
    }
    double  ED = Math.sqrt(x * x + y * y);
    return (ED == Math.ceil(ED))? 1 : 2;
  }
}
