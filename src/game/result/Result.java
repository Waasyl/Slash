package game.result;

/**
 * Created by Lukasz on 2017-06-12.
 */
public class Result {
    private String playerName;

    private int result;

    private int boardSize;

    public Result(String playerName, int result, int boardSize) {
        this.playerName = playerName;
        this.result = result;
        this.boardSize = boardSize;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getResult() {
        return result;
    }

    public int getBoardSize() {
        return boardSize;
    }

    @Override
    public String toString() {
        return playerName + ';' + result +
                ";" + boardSize;
    }
}
