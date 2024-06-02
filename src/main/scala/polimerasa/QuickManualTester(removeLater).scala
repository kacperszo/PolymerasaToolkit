package polimerasa

import polimerasa.alignments.algorithms.SequenceMatching


@main
def matchingTester(): Unit = {
  val s1 = "GCATGCG"
  val s2 = "GATTACA"

  val seq1 = s1.map(NitrogenousBase.fromLetter).toArray
  val seq2 = s2.map(NitrogenousBase.fromLetter).toArray

  val dna1 = DNA(seq1)
  val dna2 = DNA(seq2)

  val res = SequenceMatching.NeedlemanWunsch(dna1, dna2)

  val matchedDna1 = res.seq1.sequence
  val matchedDna2 = res.seq2.sequence

  val ms1 = matchedDna1.map(base => base.letter).mkString
  val ms2 = matchedDna2.map(base => base.letter).mkString

  println(ms1)
  println(ms2)
}