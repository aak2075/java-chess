package chess.controller.dao;

import chess.controller.dao.entity.BoardEntity;
import chess.controller.dao.entity.ChessGameEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcDAO implements ChessDAO {

    @Override
    public void saveBoard(final int gameId, final BoardEntity boardEntity) {

        final var query = "INSERT INTO board(game_id, class_name, piece_file, piece_rank, piece_color) VALUES(?, ?, ?, ?, ?)";

        try (final var connection = Loader.getConnection();
             final var preparedStatement = connection.prepareStatement(query)) {

            List<String> classNames = boardEntity.getClassNames();
            List<String> squareFiles = boardEntity.getSquareFiles();
            List<String> squareRanks = boardEntity.getSquareRanks();
            List<String> pieceColors = boardEntity.getPieceColors();

            for (int i = 0, end = classNames.size(); i < end; i++) {

                preparedStatement.setInt(1, gameId);
                preparedStatement.setString(2, classNames.get(i));
                preparedStatement.setString(3, squareFiles.get(i));
                preparedStatement.setString(4, squareRanks.get(i));
                preparedStatement.setString(5, pieceColors.get(i));

                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ChessGameEntity selectChessGame(final String userName) {

        final var query = "SELECT game_id, user_name, game_turn FROM chess_game WHERE user_name = ?";

        try (final var connection = Loader.getConnection();
             final var preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, userName);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int gameId = resultSet.getInt("game_id");
                String gameTurn = resultSet.getString("game_turn");

                return new ChessGameEntity(gameId, userName, gameTurn);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return null;
    }

    @Override
    public void saveGame(final ChessGameEntity chessGameEntity) {
        final var query = "INSERT INTO chess_game(user_name, game_turn) values(?, ?)";

        try (final var connection = Loader.getConnection();
             final var preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, chessGameEntity.getUserName());
            preparedStatement.setString(2, chessGameEntity.getGameTurn());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public BoardEntity selectBoard(final int gameId) {

        final var query = "SELECT class_name, piece_file, piece_rank, piece_color FROM board WHERE game_id = ?";

        List<String> classNames = new ArrayList<>();
        List<String> pieceFiles = new ArrayList<>();
        List<String> pieceRanks = new ArrayList<>();
        List<String> pieceColors = new ArrayList<>();

        try (final var connection = Loader.getConnection();
             final var preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, gameId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                classNames.add(resultSet.getString("class_name"));
                pieceFiles.add(resultSet.getString("piece_file"));
                pieceRanks.add(resultSet.getString("piece_rank"));
                pieceColors.add(resultSet.getString("piece_color"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return new BoardEntity(classNames, pieceFiles, pieceRanks, pieceColors);
    }

    @Override
    public void updateBoard(final int gameId, final BoardEntity boardEntity) {

        final var query = "UPDATE board SET class_name = ?, piece_color = ? WHERE game_id = ? && piece_file = ? && piece_rank = ?";

        try (final var connection = Loader.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            List<String> classNames = boardEntity.getClassNames();
            List<String> squareFiles = boardEntity.getSquareFiles();
            List<String> squareRanks = boardEntity.getSquareRanks();
            List<String> pieceColors = boardEntity.getPieceColors();

            for (int i = 0, end = classNames.size(); i < end; i++) {

                preparedStatement.setString(1, classNames.get(i));
                preparedStatement.setString(2, pieceColors.get(i));
                preparedStatement.setInt(3, gameId);
                preparedStatement.setString(4, squareFiles.get(i));
                preparedStatement.setString(5, squareRanks.get(i));

                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateGame(final ChessGameEntity chessGameEntity) {

        final var query = "UPDATE chess_game SET game_turn = ? WHERE game_id = ?";
        try (final var connection = Loader.getConnection();
             final var preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, chessGameEntity.getGameTurn());
            preparedStatement.setInt(2, chessGameEntity.getGameId());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
