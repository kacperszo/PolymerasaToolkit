package polimerasa

class DNA(private var sequence: Array[NitrogenousBases]) {
  def getSequence: Array[NitrogenousBases] = sequence

  def complement: DNA = new DNA(this.sequence.map(base => base.complementary()))

  def inPlaceComplement(): Unit = {
    this.sequence = this.sequence.map(base => base.complementary())
  }

  def reverseComplement(): DNA = new DNA(this.sequence.map(base => base.complementary()).reverse)

  def inPlaceReverseComplement(): Unit = {
    this.sequence = this.sequence.map(base => base.complementary()).reverse
  }

  def reverse(): DNA = new DNA(this.sequence.reverse)

  def inPlaceReverse(): Unit = {
    this.sequence = this.sequence.reverse
  }

  def sequenceMatch(other: DNA): (Array[NitrogenousBases], Array[NitrogenousBases]) = {
    val thisSeq = sequence
    val otherSeq = other.getSequence

    val cols = thisSeq.length + 1
    val rows = otherSeq.length + 1

    val dynArr: Array[Array[Int]] = Array.ofDim[Int](rows, cols)

    (null, null) // so it does compile
  }
}
