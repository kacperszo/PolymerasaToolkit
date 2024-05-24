package polimerasa.parsers

import org.scalatest.funsuite.AnyFunSuiteLike

class FASTAParserTest extends AnyFunSuiteLike {

  test("test file parsing using sample 1") {
    val result = FASTAParser.parseFile("sample1.fasta")
    println(result(0))
    println(result(1))
    println(result(2))
  }
  test("test file parsing using sample 2") {
    val result = FASTAParser.parseFile("sample2.fasta")
    println(result(0))
  }

}
