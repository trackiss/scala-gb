package com.github.trackiss.scalagb.infrastructure

import com.github.trackiss.scalagb.infrastructure.Implicits.*
import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class ImplicitsSpec extends AnyFreeSpecLike with Matchers:
  "UByteExtension" - {
    "toBooleans" in {
      UByte(b"1010_1010").toBooleans shouldBe
        Seq(true, false, true, false, true, false, true, false)
    }

    "toMap" in {
      UByte(b"1010_1010").toMap shouldBe
        Map(
          7 -> true,
          6 -> false,
          5 -> true,
          4 -> false,
          3 -> true,
          2 -> false,
          1 -> true,
          0 -> false
        )
    }

    "mask" in {
      UByte(b"1010_1010").mask(UByte(b"0011_1000")) shouldBe b"101"
    }
  }

end ImplicitsSpec
