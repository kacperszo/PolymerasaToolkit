package polimerasa

class RNA(sequence: Array[NitrogenousBase]) extends GeneticSequence(sequence) {

  override def complement: RNA = RNA(this.sequence.map(base => base.complementary()))

  override def reverseComplement(): RNA = RNA(this.sequence.map(base => base.complementary()).reverse)
  override def reverse(): RNA = RNA(this.sequence.reverse)
}
