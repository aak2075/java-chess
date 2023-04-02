package chess.controller.dao;

import chess.controller.dao.entity.BoardEntity;
import chess.controller.dao.entity.ChessGameEntity;

public interface ChessDAO {

    void saveBoard(final int gameId, final BoardEntity boardEntity);

    ChessGameEntity selectChessGame(final String userName);

    BoardEntity selectBoard(final int gameId);

    void updateBoard(final int gameId, final BoardEntity boardEntity);

    void saveGame(final ChessGameEntity chessGameEntity);

    void updateGame(final ChessGameEntity chessGameEntity);
}
