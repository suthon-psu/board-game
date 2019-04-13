public class Player {
  private String name;
  private Board board;
  private PlayerListener listener;
  private int currentPosition = 0;

  public Player(String name, Board board, PlayerListener listener) {
    this.name = name;
    this.board = board;
    this.listener = listener;
  }

  public void walk(int steps) {
    int next_position = currentPosition + steps;
    System.out.println(this + " walks from " + currentPosition + " to " + next_position);
    currentPosition = next_position;
    if (currentPosition >= board.getFinishPosition()) {
      this.listener.hasWon(this);
    }
    this.listener.walkCompleted(this);
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName();
  }
}