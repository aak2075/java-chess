package chess.controller.command;

import chess.controller.dao.JdbcDAO;
import chess.domain.ChessGame;
import chess.domain.board.Board;
import chess.domain.piece.Color;
import chess.repository.ChessGameRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StartCommand extends AbstractCommand {

    private final String command = "start";

    public StartCommand(ChessGame chessGame) {
        super(chessGame);
    }

    @Override
    public void execute(String input) {

        List<String> inputs = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());

        ChessGameRepository chessGameRepository = new ChessGameRepository(new JdbcDAO());

        String userName = inputs.get(1);

        if (chessGameRepository.hasGame(userName)) {
            Board board = chessGameRepository.findBoardByUserName(userName);
            Color color = chessGameRepository.findTurnByUserName(userName);

            chessGame.start(board, color, userName);
            return;
        }

        chessGame.start(userName);
    }

    @Override
    public String getCommand() {
        return command;
    }
}
