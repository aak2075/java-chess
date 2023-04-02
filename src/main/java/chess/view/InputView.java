package chess.view;

import java.util.Scanner;

public final class InputView {

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputCommand() {
        return scanner.nextLine();
    }
}
