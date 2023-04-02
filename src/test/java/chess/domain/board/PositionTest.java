package chess.domain.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.domain.board.Positions.*;
import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("파일이 같으면 true를 반환한다.")
    void isFileEquals_true() {
        var source = new Position(File.D, Rank.FIVE);
        var target = new Position(File.D, Rank.EIGHT);

        assertThat(source.isSameFile(target)).isTrue();
    }

    @Test
    @DisplayName("파일이 다르면 false를 반환한다.")
    void isFileEquals_false() {
        var source = new Position(File.C, Rank.FIVE);
        var target = new Position(File.D, Rank.EIGHT);

        assertThat(source.isSameFile(target)).isFalse();
    }

    @Test
    @DisplayName("두 포지션의 기울기를 계산한다.")
    void computeInclination_result1() {
        var source = B4;
        var target = E7;

        double v = source.computeInclination(target);

        assertThat(v).isEqualTo(1.0d);
    }

    @Test
    @DisplayName("두 포지션의 기울기를 계산한다.")
    void computeInclination_resultNegative1() {
        var source = new Position(File.C, Rank.FIVE);
        var target = new Position(File.A, Rank.SEVEN);

        double v = source.computeInclination(target);

        assertThat(v).isEqualTo(-1.0d);
    }

    @Test
    @DisplayName("대각 경로를 계산한다")
    void computeDiagonalPath() {
        var source = C5;
        var target = A7;

        assertThat(source.computeDiagonalPath(target)).contains(A7, B6);
    }
}
