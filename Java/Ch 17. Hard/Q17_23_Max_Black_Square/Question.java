package Q17_23_Max_Black_Square;

import CtCILibrary.AssortedMethods;

public class Question {

public static Subsquare getSquare(int[][] A){
  int N = A.length;
  for (int i = N; i >= 1; i--) {
    Subsquare square = getSquareWSize(A, i);
    if (square != null) return square;
  }
  return null;
}

static Subsquare getSquareWSize(
  int[][] A, int squareSize) {
  // On an edge of length N, there are
  // (N - sz + 1) squares of length sz.
  int count = A.length - squareSize + 1;

  // Iterate all squares w/ side len squareSize.
  for (int i = 0; i < count; i++)
    for (int j = 0; j < count; j++)
      if (isSquare(A, i, j, squareSize))
        return new Subsquare(i, j, squareSize);
  return null;
}

static boolean isSquare(
  int[][] A, int r, int c, int size) {
  // Check top and bottom border.
  for (int j = 0; j < size; j++) {
    if (A[r][c+j] == 1)
      return false;
    if (A[r+size-1][c+j] == 1)
      return false;
  }
  // Check left and right border.
  for (int i = 1; i < size - 1; i++) {
    if (A[r+i][c] == 1)
      return false;
    if (A[r+i][c+size-1] == 1)
      return false;
  }
  return true;
}

public static void main(String[] args) {
  int[][] matrix = AssortedMethods.randomMatrix(7, 7, 0, 1);
  AssortedMethods.printMatrix(matrix);
  Subsquare square = getSquare(matrix);
  square.print();
}
}
