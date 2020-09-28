package Q8_07_Permutations_Without_Dups;

import java.util.*;

public class QuestionA {
  public static ArrayList<String>
    getPerms(String str) {
    if (str == null) {
      return null;
    }
    ArrayList<String> perms =
      new ArrayList<String>();
    if (str.length() == 0) { // base case
      perms.add("");
      return perms;
    }
              
    char first = str.charAt(0);
    String rmndr = str.substring(1);
    ArrayList<String> words = getPerms(rmndr);
    for (String word : words) {
      for (int j = 0; j <= word.length(); j++) {
        String s = insertCharAt(word, first, j);
        perms.add(s);
      }
    }
    return perms;
  }
  
  public static String insertCharAt(
    String word, char c, int i) {
    String start = word.substring(0, i);
    String end = word.substring(i);
    return start + c + end;
  }
  
  public static void main(String[] args) {
    ArrayList<String> list = getPerms("abcde");
    System.out.println("There are " + list.size()
                       + " permutations.");
    for (String s : list) {
      System.out.println(s);
    }
  }
}
