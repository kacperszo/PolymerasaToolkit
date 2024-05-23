package polimerasa

enum NitrogenousBases(val letter: String) {
  case CYTOSINE extends NitrogenousBases(letter = "C")

  case GUANINE extends NitrogenousBases(letter = "G")

  case ADENINE extends NitrogenousBases(letter = "A")

  case THYMINE extends NitrogenousBases(letter = "T")

  case URACIL extends NitrogenousBases(letter = "U")


  def toLetter(nitrogenousBases: NitrogenousBases): String = {
    nitrogenousBases.letter
  }

  def complementary(): NitrogenousBases = {
    this match {
      case ADENINE => THYMINE
      case THYMINE => ADENINE
      case CYTOSINE => GUANINE
      case GUANINE => CYTOSINE
      case URACIL => ADENINE
      case _ => throw new IllegalArgumentException("Unknown Nitrogenous base")
    }
  }
}

object NitrogenousBases {
  def fromLetter(letter: Char): NitrogenousBases = {
    letter match {
      case 'C' => CYTOSINE
      case 'G' => GUANINE
      case 'A' => ADENINE
      case 'T' => THYMINE
      case 'U' => URACIL
      case _ => throw new IllegalArgumentException("Nitrogenous Base of given letter not found")
    }
  }
}