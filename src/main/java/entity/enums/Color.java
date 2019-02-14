package entity.enums;

public enum Color {
    BLACK("#000000"), WHITE("#FFFFFF"), RED("#FF0000"), GREEN("#008000"), BLUE("#0000FF"), YELLOW("#FFFF00");

    private String hex;

    Color(String hex) {
        this.hex = hex;
    }

    public String getHexColor() {
        return hex;
    }
}
