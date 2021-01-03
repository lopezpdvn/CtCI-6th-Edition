package Q16_04_Tic_Tac_Win;

import java.util.ArrayList;

import CtCILibrary.AssortedMethods;

public class QuestionG {

public static class Check {
  public int row, col;
  private int rowInc, colInc;
  public Check(int row,int col,int rowI,int colI){
    this.row = row; this.col = col;
    this.rowInc = rowI; this.colInc = colI; }

  public void increment() {
    row += rowInc; col += colInc; }

  public boolean inBounds(int size) {
    return row >= 0 && col >= 0 &&
        row < size && col < size; }
}

public static Piece hasWon(Piece[][] board) {
  if (board.length != board[0].length)
    return Piece.Empty;
  int size = board.length;

  ArrayList<Check> checks =new ArrayList<Check>();
  for (int i = 0; i < board.length; i++) {
    checks.add(new Check(0, i, 1, 0));// column(s)
    checks.add(new Check(i, 0, 0, 1));/*row(s)*/ }
  checks.add(new Check(0, 0, 1, 1)); // main diag
  checks.add(new Check(0,size-1, 1,-1));//antidiag

  for (Check instr : checks) {
    Piece winner = hasWon(board, instr);
    if (winner != Piece.Empty)
      return winner; }
  return Piece.Empty;
}

public static Piece hasWon(
    Piece[][] board, Check instr) {
  Piece first = board[instr.row][instr.col];
  while (instr.inBounds(board.length)) {
    if (board[instr.row][instr.col] != first)
      return Piece.Empty;
    instr.increment(); }
  return first;
}

public static void main(String[] args) {
  int N = 3;
  int[][] board_t =
    AssortedMethods.randomMatrix(N, N, 0, 2);
  Piece[][] board = new Piece[N][N];
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      int x = board_t[i][j];
      board[i][j] = Tester.convertIntToPiece(x);
    }
  }
  Piece p1 = hasWon(board);
  System.out.println(p1);
  AssortedMethods.printMatrix(board_t);
}

}
