public class Wrapper {
    public String wrap(String text, int columnsWidth) {
        if (text.length() == 0) return "";

        isColumnIsNegative(columnsWidth);

        if (text.length() <= columnsWidth) return text;


        String firstWrap = text.substring(0, columnsWidth).concat("\n");
        String remainingText = text.substring(columnsWidth).replaceFirst(" ", "");
        return firstWrap.concat(wrap(remainingText, columnsWidth));
    }

    private void isColumnIsNegative(int columnsWidth) {
        if (columnsWidth < 0) throw new IllegalArgumentException("Negative numbers are not allowed");
    }
}
