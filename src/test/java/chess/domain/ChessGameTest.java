package chess.domain;

import chess.domain.piece.Color;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.domain.board.Positions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ChessGameTest {

    @DisplayName("턴을 진행하면 턴이 바뀐다")
    @Test
    void playTurn_change() {
        ChessGame chessGame = new ChessGame();
        chessGame.start("test");
        final var source = A2;
        final var target = A3;
        chessGame.move(source, target);
        assertThat(chessGame.getTurn()).isEqualTo(Color.BLACK);
    }

    @DisplayName("킹이 죽어서 게임이 끝난다")
    @Test
    void isKingDead_true() {
        ChessGame chessGame = new ChessGame();
        chessGame.start("test");
        chessGame.move(E2, E4);
        chessGame.move(D7, D5);
        chessGame.move(E1, E2);
        chessGame.move(D8, D7);
        chessGame.move(A2, A4);
        chessGame.move(D7, F5);
        chessGame.move(A4, A5);
        chessGame.move(F5, G4);
        chessGame.move(A5, A6);
        chessGame.move(G4, E2);

        assertThat(chessGame.isFinished()).isTrue();
    }

    @DisplayName("게임이 끝나지 않았다")
    @Test
    void isKingDead_false() {
        ChessGame chessGame = new ChessGame();
        chessGame.start("test");
        assertThat(chessGame.isFinished()).isFalse();
    }


    @DisplayName("초기 백의 점수를 계산한다")
    @Test
    void calculateScore_White() {
        ChessGame chessGame = new ChessGame();
        chessGame.start("test");
        assertThat(chessGame.calculateWhiteScore()).isEqualTo(38);
    }

    @DisplayName("초기 흑의 점수를 계산한다")
    @Test
    void calculateScore_Black() {
        ChessGame chessGame = new ChessGame();
        chessGame.start("test");
        assertThat(chessGame.calculateBlackScore()).isEqualTo(38);
    }

    @DisplayName("file1에 whitePawn이 2개이면 전체는 37점")
    @Test
    void calculateFileScore() {
        var chessGame = new ChessGame();
        chessGame.start("test");

        chessGame.move(B2, B4);
        chessGame.move(A7, A5);
        chessGame.move(B4, A5);

        assertThat(chessGame.calculateWhiteScore()).isEqualTo(37);
    }

    @DisplayName("file1에 whitePawn이 3개이면 전체는 36.5점")
    @Test
    void calculateWhiteScore() {
        var chessGame = new ChessGame();
        chessGame.start("test");

        chessGame.move(B2, B4);
        chessGame.move(A7, A5);
        chessGame.move(B4, A5);
        chessGame.move(B7, B5);
        chessGame.move(C2, C4);
        chessGame.move(A8, A6);
        chessGame.move(C4, B5);
        chessGame.move(C7, C6);
        chessGame.move(B5, A6);

        AssertionsForClassTypes.assertThat(chessGame.calculateWhiteScore()).isEqualTo(36.5);
    }
}
