public class WordWrapper {
    public String wrap(String text, int columnsWidth) {
        if (text.length() == 0) return "";

        isColumnIsNegative(columnsWidth);


        return text.substring(0, columnsWidth) + "\n" + text.substring(columnsWidth + 1);
    }

    private void isColumnIsNegative(int columnsWidth) {
        if (columnsWidth < 0) throw new IllegalArgumentException("Negative numbers are not allowed");
    }
}
