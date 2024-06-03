package polimerasa.parsers

import org.scalatest.funsuite.AnyFunSuiteLike

class FASTAParserTest extends AnyFunSuiteLike {

  test("test Nucleic Acid file parsing using sample 1") {
    val result = FASTAParser.parseNucleicAcidFile("./sample1.fasta").toArray
    assert(result.length==3)
  }
  test("test Nucleic Acid parsing using sample 2") {
    val result = FASTAParser.parseNucleicAcidFile("./sample2.fasta").toArray
    assert(result.length==1)
  }

  test("test AminoAcid parsing using sample 3") {
    val result = FASTAParser.parseAminoAcidFile("sample3.fasta").toArray
    assert(result.length==1)
  }

}
