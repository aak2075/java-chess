package chess.controller.dao.entity;

import java.util.List;

public class BoardEntity {

    private final List<String> classNames;
    private final List<String> squareFiles;
    private final List<String> squareRanks;
    private final List<String> pieceColors;

    public BoardEntity(List<String> classNames, List<String> squareFiles, List<String> squareRanks, List<String> pieceColors) {
        this.classNames = List.copyOf(classNames);
        this.squareFiles = List.copyOf(squareFiles);
        this.squareRanks = List.copyOf(squareRanks);
        this.pieceColors = List.copyOf(pieceColors);
    }

    public List<String> getClassNames() {
        return List.copyOf(classNames);
    }

    public List<String> getSquareFiles() {
        return List.copyOf(squareFiles);
    }

    public List<String> getSquareRanks() {
        return List.copyOf(squareRanks);
    }

    public List<String> getPieceColors() {
        return List.copyOf(pieceColors);
    }
}
