public class Main {
  public static void main(String[] args) {
    GameController gc = new GameController();
    while (gc.getWinner() == null) {
      gc.takeTurn();
    }
    System.out.println(gc.getWinner() + " is a winner");
  }
}