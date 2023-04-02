package chess.controller.command;

public class IllegalCommand implements Command {

    @Override
    public void execute(String input) {
        throw new IllegalArgumentException("잘못된 명령입니다");
    }

    @Override
    public String getCommand() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isPrintable() {
        return false;
    }

}
