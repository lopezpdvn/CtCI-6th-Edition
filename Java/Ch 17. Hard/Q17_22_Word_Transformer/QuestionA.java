package Q17_22_Word_Transformer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class QuestionA {
static LinkedList<String> transform(String start,
  String stop, String[] words) {
  HashSet<String> dict = getDictAsSet(words);
  HashSet<String>visited = new HashSet<String>();
  return transform(visited, start, stop, dict); }

static LinkedList<String> transform(
  HashSet<String> visited, String startWord,
  String stopWord, Set<String> dict) {
  if (startWord.equals(stopWord)) {
    LinkedList<String> path =
      new LinkedList<String>();
    path.add(startWord);
    return path;
  } else if (visited.contains(startWord) ||
             !dict.contains(startWord)) {
    return null; }

  visited.add(startWord);
  ArrayList<String> words =words1Away(startWord);
  for (String word : words) {
    LinkedList<String> path =
      transform(visited, word, stopWord, dict);
    if (path != null) {
      path.addFirst(startWord);
      return path; } }
  return null; }

static ArrayList<String> words1Away(String word){
  ArrayList<String> words =
    new ArrayList<String>();
  for (int i = 0; i < word.length(); i++)
    for (char c = 'a'; c <= 'z'; c++) {
      String w =   word.substring(0, i) + c
                 + word.substring(i + 1);
      words.add(w); }
  return words; }

static HashSet<String> getDictAsSet(
  String[] words) {
  HashSet<String> hash = new HashSet<String>();
  for (String word : words) {
    hash.add(word.toLowerCase()); }
  return hash; }

public static void main(String[] args) {
  String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril"};		
  LinkedList<String> list = transform("tree", "flat", words);
  
  if (list == null) {
    System.out.println("No path.");
  } else {
    System.out.println(list.toString());
  }
}
}
// [tree, pree, pret, fret, frat, flat]