package Q8_02_Robot_in_a_Grid;

import java.util.ArrayList;

import CtCILibrary.AssortedMethods;

public class QuestionA {

public static ArrayList<Point> getPath(
    boolean[][] maze) {
  if(maze == null || maze.length == 0)
    return null;
  ArrayList<Point> path = new ArrayList<Point>();
  if (getPath(maze, maze.length - 1,
              maze[0].length - 1, path))
    return path;
  return null; }

public static boolean getPath(boolean[][] maze,
    int r, int c, ArrayList<Point> path) {
  if (c < 0 || r < 0 || !maze[r][c])
    return false;

  boolean atOrgn = (r == 0) && (c == 0);

  // If path from start to (r,c) exists, add (r,c)
  if (atOrgn || getPath(maze, r, c - 1, path)
             || getPath(maze, r - 1, c, path)) {
    Point p = new Point(r, c);
    path.add(p);
    return true; }

  return false;
}

public static void main(String[] args) {
  int size = 5;
  boolean[][] maze = AssortedMethods
    .randomBooleanMatrix(size, size, 80);
  AssortedMethods.printMatrix(maze);

  ArrayList<Point> path = getPath(maze);
  if (path != null) {
    System.out.println(path.toString());
  } else {
    System.out.println("No path found.");
  }
}

}
