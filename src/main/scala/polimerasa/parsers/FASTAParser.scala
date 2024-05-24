package polimerasa.parsers

import polimerasa.{DNA, NitrogenousBases, RNA}

import scala.collection.mutable.ArrayBuffer

case class FASTASequence(name: String, sequence: ArrayBuffer[NitrogenousBases]){
  def toDNA: DNA = {
    DNA(sequence.toArray)
  }

  def toRNA: RNA = {
    RNA(sequence.toArray)
  }
  def toProtein: Unit = {
    throw new NotImplementedError()
  }
}

object FASTAParser {

  def parseFile(filePath: String): Array[FASTASequence] = {
    val bufferedSource = scala.io.Source.fromFile(filePath)
    val sequences = ArrayBuffer[FASTASequence]()
    var currentSequence: Int = -1
    for (lines <- bufferedSource.getLines()) {
      if (lines.contains(">")) {
        currentSequence += 1
        sequences.addOne(FASTASequence(lines.substring(1),new ArrayBuffer[NitrogenousBases]))
      } else {
        lines.toUpperCase().foreach(base => {
          sequences(currentSequence).sequence.addOne(NitrogenousBases.fromLetter(base))
        })
      }
    }
    sequences.toArray
  }
}