class WordWrapper:
    def wrap(self, text: str, columnWidth: int) -> str:
        if len(text) == 0:
            return ""
        raise ValueError("Column width must be greater than 0")
