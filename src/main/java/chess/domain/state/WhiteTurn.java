package chess.domain.state;

import chess.domain.board.Board;
import chess.domain.board.Position;
import chess.domain.piece.Color;

public final class WhiteTurn extends Running {

    private final Color color = Color.WHITE;

    public WhiteTurn(Board board) {
        super(board);
    }

    @Override
    public State move(Position source, Position target) {
        board.play(source, target, color);

        if (board.isKingDead(color.getOppsiteColor())) {
            return new BlackWin(board);
        }

        return new BlackTurn(board);
    }

    @Override
    public Color getTurn() {
        return color;
    }
}
