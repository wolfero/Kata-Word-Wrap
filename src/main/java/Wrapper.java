public class Wrapper {
    public String wrap(String text, int columnsWidth) {
        if (text.length() == 0) return "";

        isColumnIsNegative(columnsWidth);

        if (text.length() <= columnsWidth) return text;

        boolean shouldWrappedInBlankSpace = isWrappedInBlankSpace(text, columnsWidth);
        int wrapLimit = (shouldWrappedInBlankSpace) ? text.lastIndexOf(" ", columnsWidth) : columnsWidth;
        String firstWrap = text.substring(0, wrapLimit).concat("\n");
        String remainingText = text.substring(wrapLimit).trim();

        return firstWrap.concat(wrap(remainingText, columnsWidth));
    }

    private void isColumnIsNegative(int columnsWidth) {
        if (columnsWidth < 0) throw new IllegalArgumentException("Negative numbers are not allowed");
    }

    private boolean isWrappedInBlankSpace(String text, int columnsWidth) {
        int blankSpaceIndex = text.lastIndexOf(" ", columnsWidth);
        return 0 < blankSpaceIndex && blankSpaceIndex < columnsWidth;
    }
}
