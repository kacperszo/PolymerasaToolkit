package polimerasa

class DNA(sequence: Array[NitrogenousBase]) extends GeneticSequence(sequence) {
  override def complement: DNA = DNA(this.sequence.map(base => base.complementary()))

  override def reverseComplement: DNA = DNA(this.sequence.map(base => base.complementary()).reverse)

  override def reverse: DNA = DNA(this.sequence.reverse)
}
