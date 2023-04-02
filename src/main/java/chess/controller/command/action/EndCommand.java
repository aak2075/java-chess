package chess.controller.command.action;

import chess.controller.dao.JdbcDAO;
import chess.domain.ChessGame;
import chess.domain.board.Board;
import chess.repository.ChessGameRepository;

public class EndCommand extends ActionCommand {

    private final String command = "end";

    public EndCommand(ChessGame chessGame) {
        super(chessGame);
    }

    @Override
    public void execute(String input) {
        Board board = chessGame.getBoard();
        ChessGameRepository chessGameRepository = new ChessGameRepository(new JdbcDAO());

        chessGameRepository.saveGame(board, chessGame.getUserName(), chessGame.getTurn());
        chessGame.finish();
    }

    @Override
    public String getCommand() {
        return command;
    }
}
