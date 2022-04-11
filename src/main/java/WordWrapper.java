public class WordWrapper {
    public String wrap(String text, int columnsWidth) {
        if (text.length() == 0) return "";

        isColumnIsNegative(columnsWidth);

        if (text.length() <= columnsWidth) return text;

        String firstWord = text.substring(0, columnsWidth);
        String restOfText = text.substring(columnsWidth).trim();
        return firstWord + "\n" + wrap(restOfText, columnsWidth);
    }

    private void isColumnIsNegative(int columnsWidth) {
        if (columnsWidth < 0) throw new IllegalArgumentException("Negative numbers are not allowed");
    }
}
