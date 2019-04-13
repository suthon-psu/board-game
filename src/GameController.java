public class GameController implements PlayerListener {
  private Board board;
  private Dice d1 = new Dice();
  private Dice d2 = new Dice();

  private Player p1;
  private Player p2;
  private Player currentPlayer;
  private Player winner = null;

  public GameController() {
    board = new Board(50);
    p1 = new Player("p1", board, this);
    p2 = new Player("p2", board, this);
    currentPlayer = p1;
  }

  private void rollDice() {
    d1.roll();
    d2.roll();
  }

  public void takeTurn() {
    rollDice();
    currentPlayer.walk(d1.getFace() + d2.getFace());
  }

  private void changeTurn() {
    if (currentPlayer == p1)
      currentPlayer = p2;
    else
      currentPlayer = p1;
  }

  @Override
  public void walkCompleted(Player onwer) {
    changeTurn();
  }

  @Override
  public void hasWon(Player owner) {
    if (winner == null) { // first winner only
      winner = owner;
    }
  }

  public Player getWinner() {
    return winner;
  }
}