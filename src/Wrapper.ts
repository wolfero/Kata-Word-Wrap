export class Wrapper {
  public wrap(text: string, columnWidth: number): string {
    if (text === "") return "";

    this.isColumnWidthZero(columnWidth);

    this.isColumnWidthNegative(columnWidth);

    return text;
  }

  private isColumnWidthZero(columnWidth: number) {
    if (columnWidth === 0) throw "Zero are not allowed";
  }

  private isColumnWidthNegative(columnWidth: number) {
    if (columnWidth < 0) throw "Negative numbers are not allowed";
  }
}
