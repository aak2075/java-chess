package chess.controller.command.printable;

import chess.controller.command.AbstractCommand;
import chess.domain.ChessGame;

public abstract class PrintableCommand extends AbstractCommand {

    public PrintableCommand(ChessGame chessGame) {
        super(chessGame);
    }

    public abstract double getWhiteScore();

    public abstract double getBlackScore();

    @Override
    public boolean isPrintable() {
        return true;
    }
}
