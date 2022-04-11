export class Wrapper {
  public wrap(text: string, columnsWidth: number): string {
    if (text === "") return "";

    if (text.length <= columnsWidth) return text;

    this.isColumnWidthZero(columnsWidth);

    this.isColumnWidthNegative(columnsWidth);

    let firstWrap = "";
    let remainingText = "";
    if (
      text.includes(" ") &&
      text.lastIndexOf(" ", columnsWidth) < columnsWidth
    ) {
      firstWrap = text
        .substring(0, text.lastIndexOf(" ", columnsWidth))
        .concat("\n");
      remainingText = text
        .substring(text.lastIndexOf(" ", columnsWidth))
        .trim();
    } else {
      firstWrap = text.substring(0, columnsWidth).concat("\n");
      remainingText = text.substring(columnsWidth).trim();
    }
    return firstWrap + this.wrap(remainingText, columnsWidth);
  }

  private isColumnWidthZero(columnWidth: number) {
    if (columnWidth === 0) throw "Zero are not allowed";
  }

  private isColumnWidthNegative(columnWidth: number) {
    if (columnWidth < 0) throw "Negative numbers are not allowed";
  }
}
