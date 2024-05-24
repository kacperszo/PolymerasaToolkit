package polimerasa

enum NitrogenousBases(val letter: String) {
  case CYTOSINE extends NitrogenousBases(letter = "C")

  case GUANINE extends NitrogenousBases(letter = "G")

  case ADENINE extends NitrogenousBases(letter = "A")

  case THYMINE extends NitrogenousBases(letter = "T")

  case URACIL extends NitrogenousBases(letter = "U")

  case PURINE extends NitrogenousBases(letter = "R")

  case PYRIMIDINE extends NitrogenousBases(letter = "Y")

  case KETONES extends NitrogenousBases(letter = "K")

  case AMINO_GROUPS extends NitrogenousBases(letter = "M")

  case STRONG extends NitrogenousBases(letter = "S")

  case WEAK extends NitrogenousBases(letter = "W")

  case NOT_ADENINE extends NitrogenousBases("B")

  case NOT_CYTOSINE extends NitrogenousBases("D")

  case NOT_GUANINE extends NitrogenousBases("H")

  case NOT_URACIL extends NitrogenousBases("V")

  case NUCLEIC_ACID extends NitrogenousBases("N")

  case GAP extends NitrogenousBases("-")

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
      case 'R' => PURINE
      case 'Y' => PYRIMIDINE
      case 'K' => KETONES
      case 'M' => AMINO_GROUPS
      case 'S' => STRONG
      case 'W' => WEAK
      case 'B' => NOT_ADENINE
      case 'D' => NOT_CYTOSINE
      case 'H' => NOT_GUANINE
      case 'V' => NOT_URACIL
      case 'N' => NUCLEIC_ACID
      case '-' => GAP
      case letter => throw new IllegalArgumentException("Nitrogenous Base of given letter: "+letter+" not found")
    }
  }

  def toLetter(nitrogenousBases: NitrogenousBases): Char = {
    nitrogenousBases.letter.charAt(0)
  }
}