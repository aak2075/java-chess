package chess.domain.state;

import chess.domain.board.Board;
import chess.domain.piece.Color;

public class BlackWin extends Finished {

    private final Color color = Color.BLACK;

    public BlackWin(Board board) {
        super(board);
    }

    @Override
    public Color winner() {
        return color;
    }
}
