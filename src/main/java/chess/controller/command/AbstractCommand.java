package chess.controller.command;

import chess.domain.ChessGame;

public abstract class AbstractCommand implements Command {

    protected ChessGame chessGame;

    public AbstractCommand(ChessGame chessGame) {
        this.chessGame = chessGame;
    }

}
