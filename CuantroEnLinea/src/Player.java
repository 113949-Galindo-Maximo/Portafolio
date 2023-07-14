public class Player {

    private String name;
    private int points;
    private char turn;
    private int gameWins;

    public int getGameWins() {
        return gameWins;
    }

    public void setGameWins(int gameWins) {
        this.gameWins = gameWins;
    }

    public char getTurn() {
        return turn;
    }

    public void setTurn(char turn) {
        this.turn = turn;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {        return name;    }

    public void setName(String name) { this.name = name;}

    public Player(){
        name = "";
        points=0;
    }

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }
}
