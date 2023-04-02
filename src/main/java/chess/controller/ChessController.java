package chess.controller;

import chess.controller.command.*;
import chess.controller.command.action.EndCommand;
import chess.controller.command.action.MoveCommand;
import chess.controller.command.action.StartCommand;
import chess.controller.command.printable.PrintableCommand;
import chess.controller.command.printable.StatusCommand;
import chess.view.BoardDTO;
import chess.domain.ChessGame;
import chess.view.InputView;
import chess.view.OutputView;

import java.util.List;

public final class ChessController {

    private final InputView inputView;
    private final OutputView outputView;

    public ChessController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play(final ChessGame chessGame) {
        Commands commands = new Commands(List.of(
                new StartCommand(chessGame),
                new MoveCommand(chessGame),
                new StatusCommand(chessGame),
                new EndCommand(chessGame)
        ));

        outputView.startMessage();

        while (!chessGame.isFinished()) {
            playTurn(chessGame, commands);
        }

        outputView.printWinner(chessGame.getWinner());
    }

    private void playTurn(ChessGame chessGame, Commands commands) {
        try {
            String input = inputView.inputCommand();
            Command command = commands.findCommand(input);

            command.execute(input);

            outputView.printBoard(BoardDTO.from(chessGame.getSquares()));
            printStatusIfPrintable(command);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            outputView.printInputAgainMessage();
            playTurn(chessGame, commands);
        }
    }

    private void printStatusIfPrintable(Command command) {

        if (command.isPrintable()) {
            PrintableCommand printableCommand = (PrintableCommand) command;
            outputView.printStatus(printableCommand.getWhiteScore(), printableCommand.getBlackScore());
        }
    }
}
