package chess.domain;

import chess.domain.board.Board;
import chess.domain.board.Position;
import chess.domain.board.Squares;
import chess.domain.piece.Color;
import chess.domain.state.Ready;
import chess.domain.state.State;

import java.util.List;

public final class ChessGame {

    private State state;
    private String userName;

    public ChessGame() {
        this.state = new Ready();
    }

    public void start(String userName) {
        state = state.start();
        this.userName = userName;
    }

    public void start(Board board, Color color, String userName) {
        state = state.start(board, color);
        this.userName = userName;
    }

    public void move(Position source, Position target) {
        state = state.move(source, target);
    }

    public String getWinner() {
        return state.winner().name();
    }

    public double calculateWhiteScore() {
        return state.calculateWhiteScore();
    }

    public double calculateBlackScore() {
        return state.calculateBlackScore();
    }

    public Color getTurn() {
        return state.getTurn();
    }

    public Board getBoard() {
        return state.getBoard();
    }

    public List<Squares> getSquares() {
        return state.getBoard().getSquares();
    }

    public boolean isFinished() {
        return state.isFinished();
    }

    public String getUserName() {
        return userName;
    }

    public void finish() {
        state = state.end();
    }
}
