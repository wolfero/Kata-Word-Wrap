import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WordWrapperShould {
    /*TODO
     *  ("",4) -> ""
     *  ("hola",-4) -> "Not negative numbers allowed"
     *  ("hola",0) -> "Zero not allowed"
     *  ("hola",4) -> "hola"
     *  ("abc def",3) -> "abc\ndef"
     *  ("hello world,7) -> "hello\nworld"
     *  ("a lot of words for a single line", 10) -> "a lot of\nwords for\na single\nline"
     *  ("practicando TDD en Java",4) -> "prac\ntica\nndo\nTDD\nen\Java"
     * */

    @Test
    void returns_an_empty_string_if_the_text_is_not_received(){
        WordWrapper wordWrapper = new WordWrapper();

        assertThat(wordWrapper.wrap("",4)).isEqualTo("");
    }
}
