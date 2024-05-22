package polimerasa

class DNA(private var sequence: Array[NitrogenousBases]) {
  def getSequence(): Array[NitrogenousBases] = {
    sequence
  }

  def complement(): DNA = {
    new DNA(this.sequence.map(base => base.complementary()))
  }

  def inPlaceComplement(): Unit = {
    this.sequence = this.sequence.map(base => base.complementary())
  }

  def reverseComplement(): DNA = {
    new DNA(this.sequence.map(base => base.complementary()).reverse)
  }

  def inPlaceReverseComplement(): Unit = {
    this.sequence = this.sequence.map(base => base.complementary()).reverse
  }

  def reverse(): DNA = {
    new DNA(this.sequence.reverse)
  }

  def inPlaceReverse(): Unit = {
    this.sequence = this.sequence.reverse
  }
}
