package polimerasa

enum AminoAcids(val short: String, val abbrev:String, val codons: Array[String]){
  case ALANINE extends AminoAcids("A", "Ala", Array("GCU", "GCC", "GCA", "GCG"))
  case CYSTEINE extends AminoAcids("C", "Cys", Array("UGU", "UGC"))
  case ASPARTIC_ACID extends AminoAcids("D", "Asp", Array("GAU", "GAC"))
  case GLUTAMIC_ACID extends AminoAcids("E", "Glu", Array("GAA", "GAG"))
  case PHENYLALANINE extends AminoAcids("F", "Phe", Array("UUU", "UUC"))
  case GLYCINE extends AminoAcids("G", "Gly", Array("GGU", "GGC", "GGA", "GGG"))
  case HISTIDINE extends AminoAcids("H", "His", Array("CAU","CAC"))
  case ISOLEUCINE extends AminoAcids("I", "Ile", Array(	"AUU", "AUC", "AUA"))
  case LYSINE extends AminoAcids("K", "Ala", Array("AAA","AAG"))
  case LEUCINE extends AminoAcids("L", "Leu", Array("UUA", "UUG", "CUU", "CUC", "CUA", "CUG"))
  case METHIONINE extends AminoAcids("M", "Met", Array("AUG")) // START
  case ASPARAGINE extends AminoAcids("N", "Asn", Array("AAU", "AAC"))
  case PROLINE extends AminoAcids("P", "Pro", Array("CCU", "CCC", "CCA", "CCG"))
  case GLUTAMINE extends AminoAcids("Q", "Gln", Array("CAA", "CAG"	))
  case ARGININE extends AminoAcids("R", "Arg", Array("CGU", "CGC", "CGA", "CGG", "AGA", "AGG"))
  case SERINE extends AminoAcids("S", "Ser", Array("UCU", "UCC", "UCA", "UCG", "AGU", "AGC"))
  case THREONINE extends AminoAcids("T", "Thr", Array("ACU", "ACC", "ACA", "ACG"))
  case VALINE extends AminoAcids("V", "Val", Array("GUU", "GUC", "GUA", "GUG"))
  case TRYPTOPHAN extends AminoAcids("W", "Trp", Array("UGG"))
  case TYROSINE extends AminoAcids("Y", "Tyr", Array("UAU, UAC"))
  case STOP extends AminoAcids("-", "Stp", Array("UAA", "UAG", "UGA"))
}
