import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WrapperShould {
    /*TODO
     *  ("",4) -> ""
     *  ("hola",-4) -> "Negative numbers are not permitted"
     *  ("hola",0) -> "Zero not allowed"
     *  ("hola",4) -> "hola"
     *  ("hello world",7) -> "hello\nworld"
     *  ("learning TDD in Java",4) -> "lear\nning\nTDD\nin\nJava"
     * */
    private Wrapper wrapper;

    @BeforeEach
    void init() {
        wrapper = new Wrapper();
    }

    @Test
    void returns_an_empty_string_if_the_text_is_not_received() {
        assertThat(wrapper.wrap("", 4)).isEqualTo("");
    }

    @Test
    void negative_numbers_are_not_allowed() {
        String expectedMessage = "Negative numbers are not allowed";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> wrapper.wrap("hola", -4));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void returns_wrapped_string_if_given_the_correct_format_of_string_and_a_number() {
        assertThat(wrapper.wrap("hola", 3)).isEqualTo("hol\na");
    }

    @Test
    void returns_wrapped_string_on_space_and_does_not_break_the_word() {
        assertThat(wrapper.wrap("hello world", 7)).isEqualTo("hello\nworld");
        assertThat(wrapper.wrap("learning TDD width Java", 4)).isEqualTo("lear\nning\nTDD\nwidt\nh\nJava");
    }

    @Test
    void returns_wrapped_string_on_space_if_have_long_word() {
        assertThat(wrapper.wrap("this book is uncopyrightable", 7)).isEqualTo("this\nbook is\nuncopyr\nightabl\ne");
    }

}
