import polimerasa.NitrogenousBase.toLetter
import polimerasa.matching.algorithms.SequenceMatching
import polimerasa.parsers.FASTAParser

@main def main(): Unit = {
  val ls_orchid_rna = FASTAParser.parseNucleicAcidFile("./ls_orchid.fasta")
  println(s"Count of polypeptide: ${ls_orchid_rna.length}")
  val first_polypeptide = ls_orchid_rna.head
  val second_polypeptide = ls_orchid_rna(90)

  println(first_polypeptide.name)
  println(second_polypeptide.name)

  val first_polypeptide_rna = first_polypeptide.toRNA
  val second_polypeptide_rna = second_polypeptide.toRNA

  println(second_polypeptide_rna.sequence.mkString("Nitrogenous bases(", ", ", ")"))
  println(second_polypeptide_rna.reverse.sequence.mkString("Reversed(", ", ", ")"))
  println(second_polypeptide_rna.reverseComplement.sequence.mkString("Reversed Complement(", ", ", ")"))

  val result = SequenceMatching.NeedlemanWunsch(first_polypeptide_rna, second_polypeptide_rna)

  println(result.seq1.sequence.map(toLetter).mkString)
  println(result.seq2.sequence.map(toLetter).mkString)

}