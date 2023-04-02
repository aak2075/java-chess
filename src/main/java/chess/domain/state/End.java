package chess.domain.state;

import chess.domain.board.Board;
import chess.domain.piece.Color;

public class End extends Finished {

    public End(Board board) {
        super(board);
    }

    @Override
    public Color winner() {
        return Color.NONE;
    }
}
