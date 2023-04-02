package chess.domain.piece;

import chess.domain.board.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static chess.domain.board.Positions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RookTest {

    @DisplayName("같은 File일 때 이동 가능한 경로를 계산한다")
    @Test
    void computePath_sameFile() {
        Rook rook = new Rook(Color.BLACK);
        Set<Position> positions = rook.computePathWithValidate(B5, B1);

        assertThat(positions).containsExactlyInAnyOrder(B4, B3, B2, B1);
    }

    @DisplayName("같은 Rank일 때 이동 가능한 경로를 계산한다")
    @Test
    void computePath_sameRank() {
        Rook rook = new Rook(Color.BLACK);
        Set<Position> positions = rook.computePathWithValidate(A4, E4);

        assertThat(positions).containsExactlyInAnyOrder(E4, D4, C4, B4);
    }

    @DisplayName("같은 Rank일 때 이동 가능한 경로를 계산한다")
    @Test
    void computePath_sameRank2() {
        Rook rook = new Rook(Color.BLACK);
        Set<Position> positions = rook.computePathWithValidate(C3, A3);

        assertThat(positions).containsExactlyInAnyOrder(A3, B3);
    }

    @DisplayName("source와 target의 File이 같지않고 Rank가 같지 않으면 예외를 발생한다")
    @Test
    void computPath_throw() {
        var rook = new Rook(Color.BLACK);

        assertThatThrownBy(() -> rook.computePathWithValidate(A4, B7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void canMove_emptyPath_true() {
        var rook = new Rook(Color.BLACK);
        final var source = C4;
        final var target = C7;
        boolean actual = rook.canMoveWithValidate(Map.of(C5, true, C6, true, C7, false), source, target);

        assertThat(actual).isTrue();
    }

    @Test
    void canMove_emptyPathAndTargetExist_true() {
        var rook = new Rook(Color.BLACK);
        final var source = C4;
        final var target = C7;
        boolean actual = rook.canMoveWithValidate(Map.of(C5, true, C6, true, C7, false), source, target);

        assertThat(actual).isTrue();
    }

    @Test
    void canMove_notEmptyPath_false() {
        var rook = new Rook(Color.BLACK);
        final var source = C4;
        final var target = C7;
        boolean actual = rook.canMoveWithValidate(Map.of(C5, true, C6, false, C7, true), source, target);

        assertThat(actual).isFalse();
    }

    @DisplayName("흑색 룩은 점수가 5점이다")
    @Test
    void getScore_blackThree() {
        var piece = new Rook(Color.BLACK);

        assertThat(piece.getScore(Color.BLACK)).isEqualTo(5);
    }

    @DisplayName("백색 룩은 점수가 5점이다")
    @Test
    void getScore_whiteThree() {
        var piece = new Rook(Color.WHITE);

        assertThat(piece.getScore(Color.WHITE)).isEqualTo(5);
    }

    @DisplayName("다른 색의 룩은 점수가 0점이다")
    @Test
    void getScore_zero() {
        var piece = new Rook(Color.BLACK);

        assertThat(piece.getScore(Color.WHITE)).isEqualTo(0);
    }
}
