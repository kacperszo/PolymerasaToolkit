package polimerasa

class RNA(sequence: Array[NitrogenousBases]) {
  def getSequence(): Array[NitrogenousBases] = {
    sequence
  }

  def complement(): Array[NitrogenousBases] = {
    var res = Array[NitrogenousBases]()
    for base <- sequence do {
      res :+= base.complementary()
    }
    res
  }

  def reverse_complement(): Array[NitrogenousBases] = {
    this.complement().reverse
  }

  def reverse(): Array[NitrogenousBases] = {
    this.sequence.reverse
  }
}
