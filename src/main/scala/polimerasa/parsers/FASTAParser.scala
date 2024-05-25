package polimerasa.parsers

import polimerasa.{DNA, NitrogenousBases, RNA}

import scala.+:
import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import scala.util.Using
import scala.io.Source
import scala.language.postfixOps

case class FASTASequence(name: String, sequence: Seq[NitrogenousBases]){
  def toDNA: DNA = {
    DNA(sequence.toArray)
  }

  def toRNA: RNA = {
    RNA(sequence.toArray)
  }
  def toProtein(): Unit = {
    throw new NotImplementedError()
  }
}

object FASTAParser {

  def parseFile(filePath: String): Seq[FASTASequence] = {

    @tailrec
    def parseLine(line: String, acc: Seq[NitrogenousBases]): Seq[NitrogenousBases] = {
      if(line.isEmpty) acc
      else parseLine(line.substring(1), acc:+NitrogenousBases.fromLetter(line.toUpperCase.charAt(0)))
    }

    @tailrec
    def parseLines(lines: Iterable[String], currentSeq: Option[FASTASequence], sequences: Seq[FASTASequence]): Seq[FASTASequence] = {

      lines match{
        case Nil => if (currentSeq.nonEmpty) sequences :+ currentSeq.get else sequences
        case line :: xs if line.startsWith(">") => parseLines(xs, Some[FASTASequence]( FASTASequence(line.substring(1), Seq.empty[NitrogenousBases])), if (currentSeq.nonEmpty) sequences :+ currentSeq.get else sequences)
        case line :: xs => parseLines(xs, if(currentSeq.nonEmpty) Some[FASTASequence](FASTASequence(currentSeq.get.name, currentSeq.get.sequence ++ parseLine(line, Seq.empty[NitrogenousBases]))) else currentSeq, sequences)
      }

    }

    Using(Source.fromFile(filePath)) { source =>
      parseLines(source.getLines().toSeq, None, Seq.empty[FASTASequence])
    }.getOrElse(throw new RuntimeException(s"Failed to read file: $filePath") )
  }
}