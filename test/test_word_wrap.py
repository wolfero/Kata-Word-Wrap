from assertpy import assert_that
from unittest import TestCase

from src.word_wrap import WordWrapper


class TestWordWrap(TestCase):
    def test_returns_an_empty_string_if_the_text_is_not_received(self):
        word_wrapper = WordWrapper()

        assert_that(word_wrapper.wrap("", 4)).is_equal_to("")

    def test_negative_numbers_are_not_allowed(self):
        word_wrapper = WordWrapper()

        assert_that(word_wrapper.wrap).raises(ValueError).when_called_with("hola", -4)
    
    def test_zero_are_not_allowed(self):
        word_wrapper = WordWrapper()

        assert_that(word_wrapper.wrap).raises(ValueError).when_called_with("hola", 0)
    
    def test_returns_wrapped_string_if_given_the_correct_format_of_string_and_a_number(self):
        word_wrapper = WordWrapper()

        assert_that(word_wrapper.wrap("test", 3)).is_equal_to("tes\nt")

    def test_returns_wrapped_string_on_space_and_does_not_break_the_word(self):
        word_wrapper = WordWrapper()

        assert_that(word_wrapper.wrap("TDD in Python", 3)).is_equal_to("TDD\nin\nPyt\nhon")