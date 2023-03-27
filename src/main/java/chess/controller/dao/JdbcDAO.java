package chess.controller.dao;

import chess.domain.ChessGame;
import chess.domain.board.*;
import chess.domain.piece.Color;
import chess.domain.piece.Kind;
import chess.domain.piece.Piece;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class JdbcDAO implements ChessDAO{

    public JdbcDAO() {
    }

    @Override
    public void insert(ChessGame chessGame) {

        final Board board = chessGame.board();

        for (File file : File.values()) {
            for (Rank rank : Rank.values()) {

                final var query = "INSERT INTO chessGame VALUES(?, ?, ?, ?, ?)";

                Position position = new Position(file, rank);
                Square square = board.getSquare(position);
                Piece piece = square.getPiece();
                Color color = piece.getColor();
                Kind kind = piece.getKind();
                Class<?> pieceClass = piece.getClass();

                try (final var connection = Loader.getConnection();
                        final var preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, file.name());
                    preparedStatement.setString(2, rank.name());
                    preparedStatement.setString(3, color.name());
                    preparedStatement.setString(4, kind.name());
                    preparedStatement.setString(5, pieceClass.getName());
                    preparedStatement.executeUpdate();
                } catch (final SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public ChessGame select() {

        Board board = new Board();

        final var query = "SELECT * FROM chessGame";

        try (final var connection = Loader.getConnection();
                final var preparedStatement = connection.prepareStatement(query)) {

            final var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                File squareFile = File.valueOf(resultSet.getString("square_file"));
                Rank squareRank = Rank.valueOf(resultSet.getString("square_rank"));
                Color color = Color.valueOf(resultSet.getString("piece_color"));
                //Kind kind = Kind.valueOf(resultSet.getString("piece_kind"));
                String className = resultSet.getString("class_name");

                try{
                    Class<?> pieceClass = Class.forName(className);
                    Constructor<?> pieceClassConstructor = pieceClass.getConstructor(Color.class);
                    Piece piece = (Piece) pieceClassConstructor.newInstance(color);

                    Square square = new Square(piece);
                    Position position = new Position(squareFile ,squareRank);
                    board.set(position, square);

                } catch (ClassNotFoundException | NoSuchMethodException |
                         InstantiationException | IllegalAccessException |
                         IllegalArgumentException | InvocationTargetException e) {
                    throw new IllegalArgumentException(e.getMessage());
                }

            }
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }

        return new ChessGame(board, Color.WHITE);
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
        final var query = "DELETE from chessGame";

        try (final var connection = Loader.getConnection();
        final var preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }
}