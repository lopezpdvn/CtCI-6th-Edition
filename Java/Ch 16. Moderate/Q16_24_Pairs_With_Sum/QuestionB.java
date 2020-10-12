//package Q16_24_Pairs_With_Sum;

import java.util.ArrayList;
import java.util.HashMap;


public class QuestionB {
static ArrayList<Pair> printPairSums(
  int[] array, int sum) {
  ArrayList<Pair> result = new ArrayList<Pair>();
  HashMap<Integer, Integer> unpairedCnt =
                new HashMap<Integer, Integer>();
  for (int x : array) {
    int cmplmnt = sum - x;
    if(unpairedCnt.getOrDefault(cmplmnt, 0) > 0){
      result.add(new Pair(x, cmplmnt));
      adjustCounterBy(unpairedCnt, cmplmnt, -1);
    } else adjustCounterBy(unpairedCnt, x, 1);
  }
  return result;
}

static void adjustCounterBy(
  HashMap<Integer, Integer> counter, int key,
  int delta) {
  counter.put(
    key, counter.getOrDefault(key, 0) + delta);
}


public static void main(String[] args) {
  int[] test = {-1, -1, -1, -1, 0, 0, 0, 0, 1,1};
  ArrayList<Pair> pairs = printPairSums(test,-1);
  for (Pair p : pairs)
    System.out.println(p.toString());
}
}
