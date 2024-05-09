package polimerasa

class DNA(sequence: Array[NitrogenousBases]) {
  def getSequence(): Array[NitrogenousBases] = {
    sequence
  }

  def complement(): Array[NitrogenousBases] = {
    var res = Array[NitrogenousBases]()
    for base <- sequence do {
      res :+= base
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
