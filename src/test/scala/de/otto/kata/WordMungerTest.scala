package de.otto.kata

import org.scalatest.FunSpec

class WordMungerTest extends FunSpec {

  describe("The WordMunger") {
    describe("should do nothing") {
      it("when input is null") {
        assert(new WordMunger().munge(null) == null)
      }
      it("when input is empty") {
        assert(new WordMunger().munge("") == "")
      }
      it("when input is single character") {
        assert(new WordMunger().munge("a") == "a")
      }
      it("when input is two characters") {
        assert(new WordMunger().munge("ab") == "ab")
      }
      it("when input is three characters") {
        assert(new WordMunger().munge("abc") == "abc")
      }
    }

    describe("should handle one word") {
      it("when input is four characters") {
        assert(new WordMunger().munge("abcd") == "acbd")
      }

      it("when input is five characters") {
        assert(new WordMunger().munge("abcde") == "adcbe")
      }
    }

    describe("should handle multiple words") {
      it("when input has two words which are not scrambled") {
        assert(new WordMunger().munge("ab cd") == "ab cd")
      }

      it("when input has two words which are scrambled") {
        assert(new WordMunger().munge("abcde abcd") == "adcbe acbd")
      }

      it("should preserve whitespace at the beginning and end") {
        assert(new WordMunger().munge("  abcde abcd   ") == "  adcbe acbd   ")
      }

      it("should preserve non letter or digit characters at the beginning and end") {
        assert(new WordMunger().munge("Hello, World!") == "Hlleo, Wlrod!")
      }
    }
  }
}
