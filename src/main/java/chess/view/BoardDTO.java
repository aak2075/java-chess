package chess.view;

import chess.domain.board.Squares;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BoardDTO {

    private final List<List<String>> squares;

    private BoardDTO(final List<Squares> board) {
        squares = board.stream()
                .map(Squares::getPieces)
                .map(KindMapper::mapToStrings)
                .collect(Collectors.toList());

        Collections.reverse(squares);
    }

    public static BoardDTO from(final List<Squares> board) {
        return new BoardDTO(board);
    }

    public List<List<String>> getSquares() {
        return squares;
    }
}
