package chess.controller.command.action;

import chess.controller.command.AbstractCommand;
import chess.domain.ChessGame;

public abstract class ActionCommand extends AbstractCommand {

    public ActionCommand(ChessGame chessGame) {
        super(chessGame);
    }

    @Override
    public boolean isPrintable() {
        return false;
    }
}
