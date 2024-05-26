package polimerasa

class RNA(var sequence: Array[NitrogenousBase]) {

  def complement(): RNA = {
    RNA(this.sequence.map(base => base.complementary()))
  }
  def reverseComplement(): RNA = {
    RNA(this.sequence.map(base => base.complementary()).reverse)
  }
  def reverse(): RNA = {
    RNA(this.sequence.reverse)
  }
}
