class WordWrapper:
    def wrap(self, text: str, columnWidth: int) -> str:
        self.isNegativeNumber(columnWidth)

        if len(text) == 0:
            return ""
        
        if len(text) <= columnWidth:
            return text

        wrapLimit=self.obtainWrapLimit(text, columnWidth)
        wrappedText=text[0:wrapLimit]+"\n"
        remainingText=text[wrapLimit:].strip()
        
        return wrappedText+self.wrap(remainingText, columnWidth)
    

    def isNegativeNumber(self, columnWidth):
        if columnWidth <= 0:
            raise ValueError("Column width must be greater than 0")

    def obtainWrapLimit(self, text: str, columnWidth: int) -> int:
        wrapLimit=text.find(" ")
        if (wrapLimit!=-1) and (wrapLimit<columnWidth):
            return wrapLimit
        
        return columnWidth