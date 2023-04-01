package chess.controller;

import chess.controller.command.*;
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
        while (true) {
            String input = inputView.inputCommand();
            Command command = commands.findCommand(input);
            command.execute(input);

            if (command.getCommand().equals("end")) return;
        }
    }
}
