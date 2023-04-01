package chess.domain.state;

import chess.domain.board.Board;
import chess.domain.board.Position;
import chess.domain.piece.Color;

public class BlackTurn extends Running {

    private final Color color = Color.BLACK;

    public BlackTurn(Board board) {
        super(board);
    }

    @Override
    public State move(Position source, Position target) {
        board.play(source, target, color);

        if (board.isKingDead(color)) {
            return new BlackWin(board);
        }

        return new WhiteTurn(board);
    }

    @Override
    public void end() {

    }

    @Override
    public Color getTurn() {
        return color;
    }
}
