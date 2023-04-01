package chess.repository;

import chess.domain.piece.Color;
import chess.domain.piece.Piece;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PieceMapper {

    public static Piece mapToPiece(String className, Color color) {
        try {
            Class<?> pieceClass = Class.forName(className);
            Constructor<?> pieceClassConstructor = pieceClass.getConstructor(Color.class);
            return (Piece) pieceClassConstructor.newInstance(color);
        } catch (ClassNotFoundException | NoSuchMethodException |
                 InstantiationException | IllegalAccessException |
                 IllegalArgumentException | InvocationTargetException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
