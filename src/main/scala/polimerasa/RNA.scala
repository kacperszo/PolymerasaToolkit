package polimerasa

class RNA(private var sequence: Array[NitrogenousBases]) {
  def getSequence(): Array[NitrogenousBases] = {
    sequence
  }

  def complement(): RNA = {
    new RNA(this.sequence.map(base => base.complementary()))
  }

  def complementInPlace(): Unit = {
    this.sequence = this.sequence.map(base => base.complementary())
  }

  def reverseComplement(): RNA = {
    new RNA(this.sequence.map(base => base.complementary()).reverse)
  }

  def reverseComplementInPlace(): Unit = {
    this.sequence = this.sequence.map(base => base.complementary()).reverse
  }

  def reverse(): RNA = {
    new RNA(this.sequence.reverse)
  }

  def reverseInPlace(): Unit = {
    this.sequence = this.sequence.reverse
  }
}
