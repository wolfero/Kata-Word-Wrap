import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordWrapperShould {
    /*TODO
     *  ("",4) -> ""
     *  ("hola",-4) -> "Negative numbers are not permitted"
     *  ("hola",0) -> "Zero not allowed"
     *  ("hola",4) -> "hola"
     *  ("abc def",3) -> "abc\ndef"
     *  ("hello world,7) -> "hello\nworld"
     *  ("a lot of words for a single line", 10) -> "a lot of\nwords for\na single\nline"
     *  ("practicando TDD en Java",4) -> "prac\ntica\nndo\nTDD\nen\Java"
     * */
    private WordWrapper wordWrapper;

    @BeforeEach
    void init() {
        wordWrapper = new WordWrapper();
    }

    @Test
    void returns_an_empty_string_if_the_text_is_not_received() {
        assertThat(wordWrapper.wrap("", 4)).isEqualTo("");
    }

    @Test
    void negative_numbers_are_not_allowed() {
        String expectedMessage = "Negative numbers are not allowed";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> wordWrapper.wrap("hola", -4));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
