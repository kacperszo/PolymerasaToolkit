package polimerasa.alignments.algorithms

import org.scalatest.funsuite.AnyFunSuiteLike
import polimerasa.{DNA, NitrogenousBase, RNA}

import java.io.InvalidClassException

class SequenceMatchingTest extends AnyFunSuiteLike {
  test("test NeedlemanWunsch using equal length sequences") {
    val s1 = "GCATGCG"
    val s2 = "GATTACA"

    val dna1 = DNA(s1.map(NitrogenousBase.fromLetter).toArray)
    val dna2 = DNA(s2.map(NitrogenousBase.fromLetter).toArray)

    val result = SequenceMatching.NeedlemanWunsch(dna1, dna2)

    val matched1 = result.seq1.sequence.map(NitrogenousBase.toLetter).mkString
    val matched2 = result.seq2.sequence.map(NitrogenousBase.toLetter).mkString

    val expected1 = "GCATG-CG"
    val expected2 = "G-ATTACA"

    assert(matched1 == expected1)
    assert(matched2 == expected2)
  }

  test("test NeedlemanWunsch using different length sequences") {
    val s1 = "CAAGAC"
    val s2 = "GAAC"

    val rna1 = RNA(s1.map(NitrogenousBase.fromLetter).toArray)
    val rna2 = RNA(s2.map(NitrogenousBase.fromLetter).toArray)

    val result = SequenceMatching.NeedlemanWunsch(rna1, rna2)

    val matched1 = result.seq1.sequence.map(NitrogenousBase.toLetter).mkString
    val matched2 = result.seq2.sequence.map(NitrogenousBase.toLetter).mkString

    val expected1 = "CAAGAC"
    val expected2 = "GAA--C"

    assert(matched1 == expected1)
    assert(matched2 == expected2)
  }

  test("test NeedlemanWunsch using different sequence types") {
    val dna = DNA(Array.empty)
    val rna = RNA(Array.empty)

    assertThrows[InvalidClassException] {
      SequenceMatching.NeedlemanWunsch(dna, rna)
    }
  }
}
