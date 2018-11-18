public class Lawn {

  private static int[][] theLawn = {{2,2,2,2}, {2,1,1,2}, {2,1,1,2}, {2,2,2,2}};
  private static int rows;
  private static int cols;

  public static void main(String[] args) {
    rows = theLawn.length;
    cols = theLawn[0].length;
    boolean answer = itCanBeFrigginMowed();
    System.out.println(answer);
    theLawn = new int[][] {{2,2,2,2}, {2,2,2,2}, {2,2,2,2}, {2,2,2,2}};
    boolean answer2 = itCanBeFrigginMowed();
    System.out.println(answer2);
    theLawn = new int[][] {{2,1}, {1,2}};
    rows = theLawn.length;
    cols = theLawn[0].length;
    boolean answer3 = itCanBeFrigginMowed();
    System.out.println(answer3);
    theLawn = new int[][] {{2,1,2}, {1,1,1}};
    rows = theLawn.length;
    cols = theLawn[0].length;
    boolean answer4 = itCanBeFrigginMowed();
    System.out.println(answer4);
    theLawn = new int[][] {{2}};
    rows = theLawn.length;
    cols = theLawn[0].length;
    boolean answer5 = itCanBeFrigginMowed();
    System.out.println(answer5);
  }

  private static boolean itCanBeFrigginMowed() {
    if(rows==1 || cols==1){
      return true;
    }
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if(isSmallestInRow(theLawn[row][col], row)){
          if(isSmallestInCol(theLawn[row][col], col)){
            return false;
          }
        }
      }

    }
    return true;
  }

  public static boolean isSmallestInRow(int value, int row){
    int firstRowVal = -1;
    boolean allTheSame = true;
    for (int col = 0; col < cols; col++) {
      if(col == 0){
        firstRowVal = theLawn[row][col];
      }
      if(theLawn[row][col]!=firstRowVal){
        allTheSame = false;
      }
      if(value > theLawn[row][col]){
        return false;
      }
    }
    if(allTheSame){
      return false;
    }
    return true;
  }

  public static boolean isSmallestInCol(int value, int col){
    int firstColVal = -1;
    boolean allTheSameInCol = true;
    for (int row = 0; row < rows; row++) {
      if(row == 0){
        firstColVal = theLawn[row][col];
      }
      if(theLawn[row][col]!=firstColVal){
        allTheSameInCol = false;
      }
      if(value > theLawn[row][col]){
        return false;
      }
    }
    if(allTheSameInCol){
      return false;
    }
    return true;
  }
}
