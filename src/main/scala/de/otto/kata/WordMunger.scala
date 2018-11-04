package de.otto.kata


class WordMunger {

  private abstract class Token

  private case class WhiteSpaceToken(s: String) extends Token

  private case class WordToken(s: String) extends Token

  def munge(input: String): String = {
    if (input == null) {
      null
    } else {
      strToTokens(input).map(t => handleToken(t)).mkString
    }
  }

  private def handleToken(t: Token): String = {
    t match {
      case WhiteSpaceToken(s) => s
      case WordToken(s) => scrambleWord(s)
    }
  }

  private def scrambleWord(word: String): String = {
    if (word.length <= 3) {
      word
    } else {
      word.charAt(0) + word.substring(1, word.length() - 1).reverse + word.charAt(word.length() - 1)
    }
  }

  private def strToTokens(s: String): List[Token] = {
    if (s == "") {
      List()
    } else {
      if (s(0).isLetterOrDigit) {
        WordToken(s.takeWhile(c => c.isLetterOrDigit)) :: strToTokens(s.dropWhile(c => c.isLetterOrDigit))
      } else {
        WhiteSpaceToken(s.takeWhile(c => !c.isLetterOrDigit)) :: strToTokens(s.dropWhile(c => !c.isLetterOrDigit))
      }
    }
  }
}
