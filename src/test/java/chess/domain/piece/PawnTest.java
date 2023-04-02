package chess.domain.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static chess.domain.board.Positions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PawnTest {

    @Test
    @DisplayName("폰은 전진할 경로에 기물이 없으면 이동할 수 있다.")
    void canMove_forwardEmpty_true() {
        final var pawn = new WhitePawn();

        final var source = C4;
        final var target = C5;

        assertThat(pawn.canMoveWithValidate(Map.of(target, true), source, target)).isTrue();
    }

    @Test
    @DisplayName("폰은 대각선위치에 기물이 없으면 이동할 수 없다.")
    void canMove_diagonalEmpty_false() {
        final var pawn = new WhitePawn();

        final var source = C4;
        final var target = D5;

        assertThat(pawn.canMoveWithValidate(Map.of(target, true), source, target)).isFalse();
    }

    @Test
    @DisplayName("폰은 대각선위치에 기물이 있으면 이동할 수 있다.")
    void canMove_diagonalExist_true2() {
        final var pawn = new WhitePawn();

        final var source = C4;
        final var target = D5;

        assertThat(pawn.canMoveWithValidate(Map.of(target, false), source, target)).isTrue();
    }

    @Test
    @DisplayName("폰은 두칸 전진 경로에 기물이 있으면 이동할 수 없다.")
    void canMove_forwardTwoExist_false() {
        final var pawn = new WhitePawn();

        final var source = C2;
        final var target = C4;

        assertThat(pawn.canMoveWithValidate(Map.of(C3, true, C4, false), source, target)).isFalse();
    }

    @DisplayName("폰은 잘못된 경로를 받으면 움직일 수 없다.")
    @Test
    void canMoveWithValidate_illegal_exception() {
        final var pawn = new WhitePawn();

        final var source = A4;
        final var target = C6;

        assertThatThrownBy(() -> pawn.canMoveWithValidate(
                Map.of(A5, false, B5, false, C6, true),
                source,
                target)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
