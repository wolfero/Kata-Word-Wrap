class WordWrapper:
    def wrap(self, text: str, columnWidth: int) -> str:
        self.isNegativeNumber(columnWidth)

        if len(text) == 0:
            return ""

        return text[0:columnWidth]+"\n"+text[columnWidth]

    def isNegativeNumber(self, columnWidth):
        if columnWidth <= 0:
            raise ValueError("Column width must be greater than 0")
