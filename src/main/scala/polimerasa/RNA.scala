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

}
