package polimerasa

enum AminoAcid(val short: String, val abbrev: String, val codons: Array[String]) {
  case ALANINE extends AminoAcid("A", "Ala", Array("GCU", "GCC", "GCA", "GCG"))
  case CYSTEINE extends AminoAcid("C", "Cys", Array("UGU", "UGC"))
  case ASPARTIC_ACID extends AminoAcid("D", "Asp", Array("GAU", "GAC"))
  case GLUTAMIC_ACID extends AminoAcid("E", "Glu", Array("GAA", "GAG"))
  case PHENYLALANINE extends AminoAcid("F", "Phe", Array("UUU", "UUC"))
  case GLYCINE extends AminoAcid("G", "Gly", Array("GGU", "GGC", "GGA", "GGG"))
  case HISTIDINE extends AminoAcid("H", "His", Array("CAU", "CAC"))
  case ISOLEUCINE extends AminoAcid("I", "Ile", Array("AUU", "AUC", "AUA"))
  case LYSINE extends AminoAcid("K", "Ala", Array("AAA", "AAG"))
  case LEUCINE extends AminoAcid("L", "Leu", Array("UUA", "UUG", "CUU", "CUC", "CUA", "CUG"))
  case METHIONINE extends AminoAcid("M", "Met", Array("AUG")) // START
  case ASPARAGINE extends AminoAcid("N", "Asn", Array("AAU", "AAC"))
  case PROLINE extends AminoAcid("P", "Pro", Array("CCU", "CCC", "CCA", "CCG"))
  case GLUTAMINE extends AminoAcid("Q", "Gln", Array("CAA", "CAG"))
  case ARGININE extends AminoAcid("R", "Arg", Array("CGU", "CGC", "CGA", "CGG", "AGA", "AGG"))
  case SERINE extends AminoAcid("S", "Ser", Array("UCU", "UCC", "UCA", "UCG", "AGU", "AGC"))
  case THREONINE extends AminoAcid("T", "Thr", Array("ACU", "ACC", "ACA", "ACG"))
  case VALINE extends AminoAcid("V", "Val", Array("GUU", "GUC", "GUA", "GUG"))
  case TRYPTOPHAN extends AminoAcid("W", "Trp", Array("UGG"))
  case TYROSINE extends AminoAcid("Y", "Tyr", Array("UAU, UAC"))
  case STOP extends AminoAcid("-", "Stp", Array("UAA", "UAG", "UGA"))
  case ANY extends AminoAcid("-", "Any", Array())
  case GAP extends AminoAcid("-", "GAP", Array())
}

object AminoAcid {
  def fromLetter(letter: Char): AminoAcid = {
    letter match
      case 'A' => ALANINE
      case 'B' => ASPARAGINE
      case 'C' => CYSTEINE
      case 'D' => ASPARTIC_ACID
      case 'E' => GLUTAMIC_ACID
      case 'F' => PHENYLALANINE
      case 'G' => GLYCINE
      case 'H' => HISTIDINE
      case 'I' => ISOLEUCINE
      case 'K' => LYSINE
      case 'L' => LEUCINE
      case 'M' => METHIONINE
      case 'N' => ASPARAGINE
      case 'P' => PROLINE
      case 'Q' => GLUTAMINE
      case 'R' => ARGININE
      case 'S' => SERINE
      case 'T' => THREONINE
      case 'V' => VALINE
      case 'W' => TRYPTOPHAN
      case 'Y' => TYROSINE
      case 'Z' => GLUTAMIC_ACID
      case 'X' => ANY
      case '*' => STOP
      case '-' => GAP
      case letter => throw new IllegalArgumentException("AminoAcid of given letter: "+letter+" not found")
  }
}