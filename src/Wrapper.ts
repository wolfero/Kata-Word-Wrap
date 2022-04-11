export class Wrapper {
  public wrap(text: string, columnsWidth: number): string {
    if (text === "") return "";

    if (text.length <= columnsWidth) return text;

    this.isColumnWidthZero(columnsWidth);

    this.isColumnWidthNegative(columnsWidth);

    const wrapLimit = this.obtainWrapLimit(text, columnsWidth);

    const [firstWrap, remainingText] = this.splitFirstWrapAndRemainingText(
      text,
      wrapLimit
    );
    return firstWrap + this.wrap(remainingText, columnsWidth);
  }

  private isColumnWidthZero(columnWidth: number) {
    if (columnWidth === 0) throw "Zero are not allowed";
  }

  private isColumnWidthNegative(columnWidth: number) {
    if (columnWidth < 0) throw "Negative numbers are not allowed";
  }

  private obtainWrapLimit(text: string, columnsWidth: number): number {
    const shouldWrappedInBlankSpace = this.isWrappedInBlankSpace(
      text,
      columnsWidth
    );
    return shouldWrappedInBlankSpace
      ? text.lastIndexOf(" ", columnsWidth)
      : columnsWidth;
  }
  private isWrappedInBlankSpace(text: string, columnsWidth: number): boolean {
    let blankSpaceIndex = text.lastIndexOf(" ", columnsWidth);
    return 0 < blankSpaceIndex && blankSpaceIndex < columnsWidth;
  }
  private splitFirstWrapAndRemainingText(
    text: string,
    wrapLimit: number
  ): string[] {
    const firstWrap = text.substring(0, wrapLimit).concat("\n");
    const remainingText = text.substring(wrapLimit).trim();
    return [firstWrap, remainingText];
  }
}
