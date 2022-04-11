export class Wrapper {
  public wrap(text: string, columnWidth: number): string {
    if (text === "") return "";

    this.isColumnWidthNegative(columnWidth);
    if (columnWidth === 0) throw "Zero are not allowed";

    return text;
  }

  private isColumnWidthNegative(columnWidth: number) {
    if (columnWidth < 0) throw "Negative numbers are not allowed";
  }
}
