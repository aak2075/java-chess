package chess.domain.state;

import chess.domain.ChessGame;
import chess.domain.board.Board;
import chess.domain.piece.Color;

public abstract class Running extends Started {

    public Running(Board board) {
        super(board);
    }

    @Override
    public State start() {
        throw new UnsupportedOperationException();
    }

    @Override
    public State start(Board board, Color color) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Color winner() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double calculateWhiteScore() {
        return board.calculateTotalScore(Color.WHITE);
    }

    @Override
    public double calculateBlackScore() {
        return board.calculateTotalScore(Color.BLACK);
    }

    @Override
    public boolean isRunning() {
        return true;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
