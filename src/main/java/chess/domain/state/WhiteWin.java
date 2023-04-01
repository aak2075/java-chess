package chess.domain.state;

import chess.domain.board.Board;
import chess.domain.piece.Color;

public class WhiteWin extends Finished {

    private final Color color = Color.WHITE;

    public WhiteWin(Board board) {
        super(board);
    }

    @Override
    public Color winner() {
        return color;
    }
}
