package chess.domain.state;

import chess.domain.board.Board;
import chess.domain.board.Position;
import chess.domain.piece.Color;

public interface State {

    State start();

    State start(Board board, Color color);

    State move(Position source, Position target);

    Color winner();

    void end();

    boolean isRunning();

    Color getTurn();

    double calculateWhiteScore();

    double calculateBlackScore();

    Board getBoard();

    boolean isFinished();
}
