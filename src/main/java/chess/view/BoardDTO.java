package chess.view;

import chess.domain.board.Squares;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BoardDTO {

    private final List<List<String>> squares;

    public BoardDTO(final List<Squares> board) {
        squares = board.stream()
                .map(Squares::getPieces)
                .map(KindMapper::mapToStrings)
                .collect(Collectors.toList());

        Collections.reverse(squares);
    }

    public List<List<String>> getSquares() {
        return squares;
    }
}
