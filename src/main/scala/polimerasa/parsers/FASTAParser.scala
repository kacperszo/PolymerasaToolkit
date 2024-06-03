package polimerasa.parsers

import polimerasa.*

import scala.annotation.tailrec
import scala.io.Source
import scala.language.postfixOps
import scala.util.Using

case class NucleicAcidFASTASequence(name: String, sequence: Seq[NitrogenousBase]) {
  def toDNA: DNA = {
    DNA(sequence.toArray)
  }

  def toRNA: RNA = {
    RNA(sequence.toArray)
  }
}

case class AminoAcidFASTASequence(name: String, sequence: Seq[AminoAcid]) {
  def toPolypeptide: Polypeptide = Polypeptide(name, sequence.toArray)
}

object FASTAParser {
  def parseNucleicAcidFile(filePath: String): Seq[NucleicAcidFASTASequence] = {

    @tailrec
    def parseLine(line: String, acc: Seq[NitrogenousBase]): Seq[NitrogenousBase] = {
      if (line.isEmpty) acc
      else
        val base = NitrogenousBase.fromLetter(line.toUpperCase.charAt(0))
        parseLine(line.substring(1), acc :+ base)
    }

    @tailrec
    def parseLines(lines: Iterable[String], currentSeq: Option[NucleicAcidFASTASequence], sequences: Seq[NucleicAcidFASTASequence]): Seq[NucleicAcidFASTASequence] = {

      lines match {
        case Nil => if (currentSeq.nonEmpty) sequences :+ currentSeq.get else sequences
        case line :: xs if line.startsWith(">") => parseLines(
          xs,
          Some[NucleicAcidFASTASequence](
            NucleicAcidFASTASequence(line.substring(1),
              Seq.empty[NitrogenousBase])
          ),
          if (currentSeq.nonEmpty) sequences :+ currentSeq.get else sequences)
        case line :: xs => parseLines(
          xs,
          if (currentSeq.nonEmpty)
            Some[NucleicAcidFASTASequence](
              NucleicAcidFASTASequence(currentSeq.get.name, currentSeq.get.sequence ++ parseLine(line, Seq.empty[NitrogenousBase]))
            )
          else currentSeq, sequences)
      }

    }

    Using(Source.fromFile(filePath)) { source =>
      parseLines(source.getLines().toSeq, None, Seq.empty[NucleicAcidFASTASequence])
    }.getOrElse(throw new RuntimeException(s"Failed to read file: $filePath"))
  }

  def parseAminoAcidFile(filePath: String): Seq[AminoAcidFASTASequence] = {

    @tailrec
    def parseLine(line: String, acc: Seq[AminoAcid]): Seq[AminoAcid] = {
      if (line.isEmpty) acc
      else
        val aminoAcid = AminoAcid.fromLetter(line.toUpperCase.charAt(0))
        parseLine(line.substring(1), acc :+ aminoAcid)
    }

    @tailrec
    def parseLines(lines: Iterable[String], currentSeq: Option[AminoAcidFASTASequence], sequences: Seq[AminoAcidFASTASequence]): Seq[AminoAcidFASTASequence] = {

      lines match {
        case Nil => if (currentSeq.nonEmpty) sequences :+ currentSeq.get else sequences
        case line :: xs if line.startsWith(">") => parseLines(
          xs,
          Some[AminoAcidFASTASequence](
            AminoAcidFASTASequence(line.substring(1),
              Seq.empty[AminoAcid])
          ),
          if (currentSeq.nonEmpty) sequences :+ currentSeq.get else sequences)
        case line :: xs => parseLines(
          xs,
          if (currentSeq.nonEmpty)
            Some[AminoAcidFASTASequence](
              AminoAcidFASTASequence(currentSeq.get.name, currentSeq.get.sequence ++ parseLine(line, Seq.empty[AminoAcid]))
            )
          else currentSeq, sequences)
      }

    }

    Using(Source.fromFile(filePath)) { source =>
      parseLines(source.getLines().toSeq, None, Seq.empty[AminoAcidFASTASequence])
    }.getOrElse(throw new RuntimeException(s"Failed to read file: $filePath"))
  }
}