package com.github.trackiss.scalagb.infrastructure

import com.github.trackiss.scalagb.infrastructure.UByte

object Implicits:
  extension (sc: StringContext)
    def b(args: Any*): Int =
      require(sc.parts.nonEmpty)

      val binStr = sc.parts(0).replace("_", "")

      require(binStr.nn.length <= 32)
      require(binStr.nn.forall(c => c == '0' || c == '1'))

      Integer.parseInt(binStr, 2)

  extension (ub: UByte)
    def toBooleans: Seq[Boolean] = (7 to 0 by -1).map(ub.isHigh)

    def toMap: Map[Int, Boolean] =
      (7 to 0 by -1).map(i => (i, ub.isHigh(i))).toMap

    def mask(mask: UByte): Int =
      if mask == UByte(0) then
        ub.toInt
      else
        val maskIndexes = (7 to 0 by -1).filter(mask.isHigh)
        Integer.parseInt(
          maskIndexes.map(ub.toBinaryString.reverse(_)).mkString,
          2
        )

end Implicits
