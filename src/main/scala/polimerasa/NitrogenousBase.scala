package polimerasa

enum NitrogenousBase(val letter: String) {
  case CYTOSINE extends NitrogenousBase(letter = "C")

  case GUANINE extends NitrogenousBase(letter = "G")

  case ADENINE extends NitrogenousBase(letter = "A")

  case THYMINE extends NitrogenousBase(letter = "T")

  case URACIL extends NitrogenousBase(letter = "U")

  case PURINE extends NitrogenousBase(letter = "R")

  case PYRIMIDINE extends NitrogenousBase(letter = "Y")

  case KETONES extends NitrogenousBase(letter = "K")

  case AMINO_GROUPS extends NitrogenousBase(letter = "M")

  case STRONG extends NitrogenousBase(letter = "S")

  case WEAK extends NitrogenousBase(letter = "W")

  case NOT_ADENINE extends NitrogenousBase("B")

  case NOT_CYTOSINE extends NitrogenousBase("D")

  case NOT_GUANINE extends NitrogenousBase("H")

  case NOT_URACIL extends NitrogenousBase("V")

  case NUCLEIC_ACID extends NitrogenousBase("N")

  case GAP extends NitrogenousBase("-")

  def complementary(): NitrogenousBase = {
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

object NitrogenousBase {
  def fromLetter(letter: Char): NitrogenousBase = {
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

  def toLetter(nitrogenousBases: NitrogenousBase): Char = {
    nitrogenousBases.letter.charAt(0)
  }
}