class WordWrapper:
    def wrap(self, text: str, columnWidth: int) -> str:
        self.isNegativeNumber(columnWidth)

        if len(text) == 0:
            return ""
        
        if len(text) <= columnWidth:
            return text

        wrapLimit=text.find(" ")
        
        wrappedText=""
        remainingText=""
        
        if (wrapLimit!=-1) and (wrapLimit<columnWidth):
            wrappedText=text[0:wrapLimit]+"\n"
            remainingText=text[wrapLimit:].strip()
        else:
            wrappedText=text[0:columnWidth]+"\n"
            remainingText=text[columnWidth:].strip()
            
        print(wrappedText)
        print(remainingText)
        
        return wrappedText+self.wrap(remainingText, columnWidth)

    def isNegativeNumber(self, columnWidth):
        if columnWidth <= 0:
            raise ValueError("Column width must be greater than 0")
