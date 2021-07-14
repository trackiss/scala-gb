package com.github.trackiss.scalagb.infrastructure

import com.github.trackiss.scalagb.infrastructure.Implicits.Literals
import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class UShortSpec extends AnyFreeSpecLike with Matchers {
  "UShort" - {
    "UShort" in {
      UShort(10).toInt shouldBe 10
    }

    "toBinaryString" in {
      UShort(b"0000_0000_0000_1111").toBinaryString shouldBe "0000000000001111"
      UShort(b"1111_0000_0000_0000").toBinaryString shouldBe "1111000000000000"
    }

    "toHexString" in {
      UShort(0x000f).toHexString shouldBe "000f"
      UShort(0xf000).toHexString shouldBe "f000"
    }

    "signed" in {
      UShort(b"1111_1111_1111_1111").signed shouldBe -1.toShort
    }

    "toChar" in {
      UShort('あ'.toInt).toChar shouldBe 'あ'
    }

    "toInt" in {
      UShort(50).toInt shouldBe 50
    }

    "toLong" in {
      UShort(50).toLong shouldBe 50
    }

    "isHigh" in {
      (15 to 0 by -1).map(UByte(b"1010_1010_1010_1010").isHigh(_)) shouldBe
        Seq(true, false, true, false, true, false, true, false, true, false,
          true, false, true, false, true, false)
    }

    "isLow" in {
      (15 to 0 by -1).map(UByte(b"1010_1010_1010_1010").isLow(_)) shouldBe
        Seq(false, true, false, true, false, true, false, true, false, true,
          false, true, false, true, false, true)
    }

    ">" in {
      (UShort(10) > UShort(5)) shouldBe true
      (UShort(10) > UShort(10)) shouldBe false
    }

    ">=" in {
      (UShort(10) >= UShort(5)) shouldBe true
      (UShort(10) >= UShort(10)) shouldBe true
    }

    "<" in {
      (UShort(5) < UShort(10)) shouldBe true
      (UShort(10) < UShort(10)) shouldBe false
    }

    "<=" in {
      (UShort(5) <= UShort(10)) shouldBe true
      (UShort(10) <= UShort(10)) shouldBe true
    }

    "+" in {
      (UShort(10) + UShort(5)) shouldBe UShort(15)
      (UShort(0xffff) + UShort(1)) shouldBe UShort(0)
    }

    "-" in {
      (UShort(10) - UShort(5)) shouldBe UShort(5)
      (UShort(0) - UShort(1)) shouldBe UShort(0xffff)
    }

    "increment" in {
      UShort(10).increment shouldBe UShort(11)
      UShort(0xffff).increment shouldBe UShort(0)
    }

    "decrement" in {
      UShort(10).decrement shouldBe UShort(9)
      UShort(0).decrement shouldBe UShort(0xffff)
    }

    "&" in {
      (UShort(b"1010_1010_1010_1010") & UShort(b"1111_1111_0000_0000")) shouldBe
        UShort(b"1010_1010_0000_0000")
    }

    "|" in {
      (UShort(b"1010_1010_1010_1010") | UShort(b"1111_1111_0000_0000")) shouldBe
        UShort(b"1111_1111_1010_1010")
    }

    "^" in {
      (UShort(b"1010_1010_1010_1010") ^ UShort(b"1111_1111_0000_0000")) shouldBe
        UShort(b"0101_0101_1010_1010")
    }

    "unary_-" in {
      (-UShort(50)) shouldBe -50
    }

    "unary_~" in {
      (~UShort(b"1010_1010_1010_1010")) shouldBe UShort(b"0101_0101_0101_0101")
    }

    "<<" in {
      (UShort(b"0011_0000_0000_0000") << 2) shouldBe
        UShort(b"1100_0000_0000_0000")

      (UShort(b"1100_0000_0000_0000") << 2) shouldBe
        UShort(b"0000_0000_0000_0000")
    }

    ">>" in {
      (UShort(b"0000_0000_0000_1100") >> 2) shouldBe
        UShort(b"0000_0000_0000_0011")

      (UShort(b"0000_0000_0000_0011") >> 2) shouldBe
        UShort(b"0000_0000_0000_0000")

      (UShort(b"1100_0000_0000_0000") >> 2) shouldBe
        UShort(b"1111_0000_0000_0000")
    }

    ">>>" in {
      (UShort(b"0000_0000_0000_1100") >>> 2) shouldBe
        UShort(b"0000_0000_0000_0011")

      (UShort(b"0000_0000_0000_0011") >>> 2) shouldBe
        UShort(b"0000_0000_0000_0000")

      (UShort(b"1100_0000_0000_0000") >>> 2) shouldBe
        UShort(b"0011_0000_0000_0000")
    }
  }
}
