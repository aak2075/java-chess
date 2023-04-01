package chess.controller.dao;

import chess.controller.dao.entity.BoardEntity;
import chess.controller.dao.entity.ChessGameEntity;

public interface ChessDAO {

    void saveBoard(int gameId, BoardEntity boardEntity);

    ChessGameEntity selectChessGame(String userName);

    BoardEntity selectBoard(int gameId);

    void updateBoard(final int gameId, final BoardEntity boardEntity);

    void saveGame(ChessGameEntity chessGameEntity);

    void updateGame(ChessGameEntity chessGameEntity);
}
