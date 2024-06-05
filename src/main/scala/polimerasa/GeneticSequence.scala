package polimerasa

class GeneticSequence(val sequence: Array[NitrogenousBase]) {
  def complement: GeneticSequence = GeneticSequence(this.sequence.map(base => base.complementary()))
  def reverseComplement: GeneticSequence = GeneticSequence(this.sequence.map(base => base.complementary()).reverse)
  def reverse: GeneticSequence = GeneticSequence(this.sequence.reverse)
}
