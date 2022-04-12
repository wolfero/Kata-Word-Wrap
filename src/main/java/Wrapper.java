public class Wrapper {
    public String wrap(String text, int columnsWidth) {
        validate(columnsWidth);

        if (text.length() == 0) return "";

        if (text.length() <= columnsWidth) return text;

        final int wrapLimit = obtainWrapLimit(text, columnsWidth);
        final var firstWrap = text.substring(0, wrapLimit).concat("\n");
        final var remainingText = text.substring(wrapLimit).trim();
        return firstWrap.concat(wrap(remainingText, columnsWidth));
    }

    private void validate(int columnsWidth) {
        isColumnWidthZero(columnsWidth);
        isColumnWidthNegative(columnsWidth);
    }

    private void isColumnWidthZero(int columnsWidth) {
        if (columnsWidth == 0) throw new IllegalArgumentException("Zero are not allowed");
    }

    private void isColumnWidthNegative(int columnsWidth) {
        if (columnsWidth < 0) throw new IllegalArgumentException("Negative numbers are not allowed");
    }

    private int obtainWrapLimit(String text, int columnsWidth) {
        final boolean shouldWrappedInBlankSpace = isWrappedInBlankSpace(text, columnsWidth);
        return (shouldWrappedInBlankSpace) ? text.lastIndexOf(" ", columnsWidth) : columnsWidth;
    }

    private boolean isWrappedInBlankSpace(String text, int columnsWidth) {
        final int blankSpaceIndex = text.lastIndexOf(" ", columnsWidth);
        return 0 < blankSpaceIndex && blankSpaceIndex < columnsWidth;
    }
}
