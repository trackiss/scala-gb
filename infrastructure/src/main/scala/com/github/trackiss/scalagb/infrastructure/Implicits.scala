package com.github.trackiss.scalagb.infrastructure

object Implicits {
  implicit class Literals(private val sc: StringContext) extends AnyVal {
    def b(args: Any*): Int = {
      require(sc.parts.nonEmpty)

      val binStr = sc.parts(0).replace("_", "")

      require(binStr.length <= 32)
      require(binStr.forall(c => c == '0' || c == '1'))

      Integer.parseInt(binStr, 2)
    }
  }

  implicit class UByteExtension(private val ub: UByte) {
    def toBooleans: Seq[Boolean] = (7 to 0 by -1).map(ub.isHigh)

    def toMap: Map[Int, Boolean] =
      (7 to 0 by -1).map(i => (i, ub.isHigh(i))).toMap

    def mask(mask: UByte): Int =
      if (mask == UByte(0))
        ub.toInt
      else {
        val maskIndexes = (7 to 0 by -1).filter(mask.isHigh)
        Integer.parseInt(
          maskIndexes.map(ub.toBinaryString.reverse(_)).mkString,
          2
        )
      }
  }

  implicit object UByteOrdering extends Ordering[UByte] {
    override def compare(x: UByte, y: UByte): Int =
      if (x > y) 1 else if (x < y) -1 else 0
  }

  implicit object UShortOrdering extends Ordering[UShort] {
    override def compare(x: UShort, y: UShort): Int =
      if (x > y) 1 else if (x < y) -1 else 0
  }
}
