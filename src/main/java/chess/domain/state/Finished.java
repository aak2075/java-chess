package chess.domain.state;

import chess.domain.board.Board;
import chess.domain.board.Position;
import chess.domain.piece.Color;

public abstract class Finished extends Started {

    public Finished(Board board) {
        super(board);
    }

    @Override
    public State start(Board board, Color color) {
        throw new UnsupportedOperationException();
    }

    @Override
    public State start() {
        throw new UnsupportedOperationException();
    }

    @Override
    public State move(Position source, Position target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Color winner() {
        return null;
    }

    @Override
    public void end() {

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
        return false;
    }

    @Override
    public Color getTurn() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
