package chess.domain.piece;

public enum Color {

    BLACK,
    WHITE,
    NONE;

    public boolean isBlack() {
        return this == BLACK;
    }

    public boolean isWhite() {
        return this == WHITE;
    }

    public Color getOppsiteColor() {
        if (isBlack()) {
            return WHITE;
        }
        return BLACK;
    }
}
