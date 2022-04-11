export class Wrapper {
  public wrap(text: string, columnWidth: number): string {
    if (text === "") return "";

    if (columnWidth < 0) {
      throw "Negative numbers are not allowed";
    }
    return text;
  }
}
