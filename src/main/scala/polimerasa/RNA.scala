package polimerasa

class RNA(genome: Array[NitrogenousBases]) {
  def getGenome(): Array[NitrogenousBases] = {
    genome
  }

  def complement(): Array[NitrogenousBases] = {
    var res = Array[NitrogenousBases]()
    for base <- genome do {
      res :+= base.complementary()
    }
    res
  }

  def reverse_complement(): Array[NitrogenousBases] = {
    this.complement().reverse
  }

  def reverse(): Array[NitrogenousBases] = {
    this.genome.reverse
  }
}
