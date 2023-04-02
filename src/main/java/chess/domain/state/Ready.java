package chess.domain.state;

import chess.domain.board.Board;
import chess.domain.board.Position;
import chess.domain.piece.Color;

public final class Ready implements State {

    @Override
    public State start() {
        return new WhiteTurn(new Board());
    }

    @Override
    public State start(Board board, Color color) {
        if (color.isBlack()) {
            return new BlackTurn(board);
        }

        return new WhiteTurn(board);
    }

    @Override
    public State move(Position source, Position target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Color winner() {
        throw new UnsupportedOperationException();
    }

    @Override
    public State end() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double calculateWhiteScore() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double calculateBlackScore() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Color getTurn() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Board getBoard() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
