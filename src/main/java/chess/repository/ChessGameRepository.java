package chess.repository;

import chess.controller.dao.ChessDAO;
import chess.controller.dao.entity.BoardEntity;
import chess.controller.dao.entity.ChessGameEntity;
import chess.domain.board.*;
import chess.domain.piece.Color;
import chess.domain.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class ChessGameRepository {

    private final ChessDAO chessDAO;

    public ChessGameRepository(ChessDAO chessDAO) {
        this.chessDAO = chessDAO;
    }

    public Board findBoardByUserName(String userName) {
        var chessGameEntity = chessDAO.selectChessGame(userName);
        var boardEntity = chessDAO.selectBoard(chessGameEntity.getGameId());

        return createBoard(
                boardEntity.getClassNames(),
                boardEntity.getSquareFiles(),
                boardEntity.getSquareRanks(),
                boardEntity.getPieceColors()
        );
    }

    private Board createBoard(final List<String> classNames,
                              final List<String> squareFiles,
                              final List<String> squareRanks,
                              final List<String> pieceColors) {
        final var board = new Board();

        for (int i = 0, end = File.values().length * Rank.values().length; i < end; i++) {
            Piece piece = PieceMapper.mapToPiece(classNames.get(i), Color.valueOf(pieceColors.get(i)));
            Square square = new Square(piece);
            Position position = new Position(File.valueOf(squareFiles.get(i)), Rank.valueOf(squareRanks.get(i)));

            board.set(position, square);
        }

        return board;
    }

    public Color findTurnByUserName(final String userName) {
        ChessGameEntity chessGameEntity = chessDAO.selectChessGame(userName);

        return Color.valueOf(chessGameEntity.getGameTurn());
    }

    public void saveGame(final Board board, final String userName, final Color turn) {
        BoardEntity boardEntity = mapToBoardEntity(board);
        if (hasGame(userName)) {
            ChessGameEntity chessGameEntity = chessDAO.selectChessGame(userName);
            int gameId = chessGameEntity.getGameId();
            chessDAO.updateGame(new ChessGameEntity(gameId, userName, turn.name()));
            chessDAO.updateBoard(gameId, boardEntity);
            return;
        }

        chessDAO.saveGame(new ChessGameEntity(userName, turn.name()));
        ChessGameEntity chessGameEntity = chessDAO.selectChessGame(userName);
        chessDAO.saveBoard(chessGameEntity.getGameId(), boardEntity);
    }

    public boolean hasGame(final String userName) {
        ChessGameEntity chessGameEntity = chessDAO.selectChessGame(userName);

        return chessGameEntity != null;
    }

    private BoardEntity mapToBoardEntity(final Board board) {

        var classNames = new ArrayList<String>();
        var pieceFiles = new ArrayList<String>();
        var pieceRanks = new ArrayList<String>();
        var pieceColors = new ArrayList<String>();

        for (Rank rank : Rank.values()) {
            for (File file : File.values()) {
                Position position = new Position(file, rank);
                Square square = board.getSquare(position);
                Piece piece = square.getPiece();
                Class<?> pieceClass = piece.getClass();
                Color color = piece.getColor();

                classNames.add(pieceClass.getName());
                pieceFiles.add(file.name());
                pieceRanks.add(rank.name());
                pieceColors.add(color.name());
            }
        }

        return new BoardEntity(classNames, pieceFiles, pieceRanks, pieceColors);
    }
}
