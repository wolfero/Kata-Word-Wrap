from assertpy import assert_that
from unittest import TestCase

from src.word_wrap import WordWrapper


class TestWordWrap(TestCase):
	def test_returns_an_empty_string_if_the_text_is_not_received(self):
		word_wrapper = WordWrapper()

		result = word_wrapper.wrap("", 4)

		assert_that(result).is_equal_to("")
