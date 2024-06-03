package polimerasa.alignments.algorithms

import polimerasa.{GeneticSequence, NitrogenousBase}
import polimerasa.alignments.AlignmentResult

import java.io.InvalidClassException

import scala.collection.mutable.ArrayBuffer

object SequenceMatching {
  def NeedlemanWunsch(obj1: GeneticSequence, obj2: GeneticSequence): AlignmentResult = {
    if (obj1.getClass.ne(obj2.getClass)) {
      throw InvalidClassException("Cannot match DNA with RNA!")
    }

    val seq1 = obj1.sequence
    val seq2 = obj2.sequence

    val cols = seq1.length + 1
    val rows = seq2.length + 1

    val dynArr: Array[Array[Int]] = Array.ofDim[Int](rows, cols)
    val fromArr: Array[Array[Int]] = Array.ofDim[Int](rows, cols) // 1 - left, 2 - diagonal, 3 - top

    for i <- 0 until cols do {
      dynArr(0)(i) = -i
    }
    for i <- 0 until rows do {
      dynArr(i)(0) = -i
    }

    for i <- 1 until rows do {
      for j <- 1 until cols do {
        var max = dynArr(i)(j - 1) - 1
        var from = 1
        if (dynArr(i - 1)(j) - 1 > max) {
          max = dynArr(i - 1)(j) - 1
          from = 3
        }

        if (seq1(j-1) == seq2(i-1)) {
          if (dynArr(i - 1)(j - 1) + 1 > max) {
            max = dynArr(i - 1)(j - 1) + 1
            from = 2
          }
        } else {
          if (dynArr(i - 1)(j - 1) - 1 > max) {
            max = dynArr(i - 1)(j - 1) - 1
            from = 2
          }
        }
        dynArr(i)(j) = max
        fromArr(i)(j) = from
      }
    }

    var i = rows - 1
    var j = cols - 1
    val res1 = new ArrayBuffer[NitrogenousBase](rows.max(cols))
    val res2 = new ArrayBuffer[NitrogenousBase](rows.max(cols))


    while i != 0 && j != 0 do {
      fromArr(i)(j) match {
        case 1 => {
          res1 += seq1(j-1)
          res2 += NitrogenousBase.GAP
          j -= 1
        }
        case 2 => {
          res1 += seq1(j-1)
          res2+= seq2(i-1)
          j -= 1
          i -= 1
        }
        case 3 => {
          res1 += NitrogenousBase.GAP
          res2 += seq2(i-1)
          i -= 1
        }
        case _ => {
          // unreachable
        }
      }
    }



    AlignmentResult(GeneticSequence(res1.toArray.reverse), GeneticSequence(res2.toArray.reverse))
  }
}
