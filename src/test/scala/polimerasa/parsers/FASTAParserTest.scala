package polimerasa.parsers

import org.scalatest.funsuite.AnyFunSuiteLike

class FASTAParserTest extends AnyFunSuiteLike {

  test("test file parsing using sample 1") {
    val result = FASTAParser.parseNucleicAcidFile("./sample1.fasta").toArray
    assert(result.length==3)
  }
  test("test file parsing using sample 2") {
    val result = FASTAParser.parseNucleicAcidFile("./sample2.fasta").toArray
    assert(result.length==1)
  }

}
