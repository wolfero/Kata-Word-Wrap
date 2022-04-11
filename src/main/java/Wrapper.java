public class Wrapper {
    public String wrap(String text, int columnsWidth) {
        if (text.length() == 0) return "";

        isColumnIsNegative(columnsWidth);

        if (text.length() <= columnsWidth) return text;

        String firstWrap;
        String remainingText;
        if (text.contains(" ") && text.lastIndexOf(' ', columnsWidth) < columnsWidth) {
            firstWrap = text.substring(0, text.lastIndexOf(' ', columnsWidth)).concat("\n");
            remainingText = text.substring(text.lastIndexOf(' ', columnsWidth)).replaceFirst(" ", "");
        } else {
            firstWrap = text.substring(0, columnsWidth).concat("\n");
            remainingText = text.substring(columnsWidth).replaceFirst(" ", "");
            ;
        }

        return firstWrap.concat(wrap(remainingText, columnsWidth));
    }

    private void isColumnIsNegative(int columnsWidth) {
        if (columnsWidth < 0) throw new IllegalArgumentException("Negative numbers are not allowed");
    }
}
