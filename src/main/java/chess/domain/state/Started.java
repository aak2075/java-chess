package chess.domain.state;

import chess.domain.board.Board;

public abstract class Started implements State {

    protected final Board board;

    public Started(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public State end() {
        return new End(board);
    }
}
