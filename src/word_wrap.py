class WordWrapper:
    def wrap(self, text: str, columnWidth: int) -> str:
        self.isNegativeNumber(columnWidth)

        if len(text) == 0:
            return ""
        
        if len(text) <= columnWidth:
            return text

        wrappedText=text[0:columnWidth]+"\n"
        remainingText=text[columnWidth]

        return wrappedText +self.wrap(remainingText,columnWidth)

    def isNegativeNumber(self, columnWidth):
        if columnWidth <= 0:
            raise ValueError("Column width must be greater than 0")
