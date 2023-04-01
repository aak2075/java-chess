package chess.controller.dao.entity;

public class ChessGameEntity {

    private final int gameId;
    private final String userName;
    private final String gameTurn;

    public ChessGameEntity(String userName, String gameTurn) {
        this.gameId = -1;
        this.userName = userName;
        this.gameTurn = gameTurn;
    }

    public ChessGameEntity(int gameId, String userName, String gameTurn) {
        this.gameId = gameId;
        this.userName = userName;
        this.gameTurn = gameTurn;
    }

    public int getGameId() {
        return gameId;
    }

    public String getUserName() {
        return userName;
    }

    public String getGameTurn() {
        return gameTurn;
    }
}
