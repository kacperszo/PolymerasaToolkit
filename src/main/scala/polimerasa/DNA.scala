package polimerasa

class DNA( val sequence: Array[NitrogenousBase]) {
  def complement: DNA = new DNA(this.sequence.map(base => base.complementary()))

  def reverseComplement(): DNA = DNA(this.sequence.map(base => base.complementary()).reverse)

  def reverse(): DNA = DNA(this.sequence.reverse)

  def sequenceMatch(other: DNA): (Array[NitrogenousBase], Array[NitrogenousBase]) = {
    val thisSeq = sequence
    val otherSeq = other.sequence

    val cols = thisSeq.length + 1
    val rows = otherSeq.length + 1

    val dynArr: Array[Array[Int]] = Array.ofDim[Int](rows, cols)

    (null, null) // so it does compile
  }
}
