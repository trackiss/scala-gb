package com.github.trackiss.scalagb.infrastructure

import com.github.trackiss.scalagb.infrastructure.Implicits.*
import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class UByteSpec extends AnyFreeSpecLike with Matchers:
  "UByte" - {
    "UByte" in {
      UByte(10).toInt shouldBe 10
    }

    "toBinaryString" in {
      UByte(b"0000_1111").toBinaryString shouldBe "00001111"
      UByte(b"1111_0000").toBinaryString shouldBe "11110000"
    }

    "toHexString" in {
      UByte(0x0f).toHexString shouldBe "0f"
      UByte(0xf0).toHexString shouldBe "f0"
    }

    "signed" in {
      UByte(b"1111_1111").signed shouldBe -1.toShort
    }

    "toShort" in {
      UByte(50).toShort shouldBe 50.toShort
    }

    "toUShort" in {
      UByte(50).toUShort shouldBe UShort(50)
    }

    "toChar" in {
      UByte('A'.toInt).toChar shouldBe 'A'
    }

    "toInt" in {
      UByte(50).toInt shouldBe 50
    }

    "toLong" in {
      UByte(50).toLong shouldBe 50
    }

    "isHigh" in {
      (7 to 0 by -1).map(UByte(b"1010_1010").isHigh(_)) shouldBe
        Seq(true, false, true, false, true, false, true, false)
    }

    "isLow" in {
      (7 to 0 by -1).map(UByte(b"1010_1010").isLow(_)) shouldBe
        Seq(false, true, false, true, false, true, false, true)
    }

    ">" in {
      (UByte(10) > UByte(5)) shouldBe true
      (UByte(10) > UByte(10)) shouldBe false
    }

    ">=" in {
      (UByte(10) >= UByte(5)) shouldBe true
      (UByte(10) >= UByte(10)) shouldBe true
    }

    "<" in {
      (UByte(5) < UByte(10)) shouldBe true
      (UByte(10) < UByte(10)) shouldBe false
    }

    "<=" in {
      (UByte(5) <= UByte(10)) shouldBe true
      (UByte(10) <= UByte(10)) shouldBe true
    }

    "+" in {
      (UByte(10) + UByte(5)) shouldBe UByte(15)
      (UByte(0xff) + UByte(1)) shouldBe UByte(0)
    }

    "-" in {
      (UByte(10) - UByte(5)) shouldBe UByte(5)
      (UByte(0) - UByte(1)) shouldBe UByte(0xff)
    }

    "increment" in {
      UByte(10).increment shouldBe UByte(11)
      UByte(0xff).increment shouldBe UByte(0)
    }

    "decrement" in {
      UByte(10).decrement shouldBe UByte(9)
      UByte(0).decrement shouldBe UByte(0xff)
    }

    "&" in {
      (UByte(b"1010_1010") & UByte(b"1111_0000")) shouldBe UByte(b"1010_0000")
    }

    "|" in {
      (UByte(b"1010_1010") | UByte(b"1111_0000")) shouldBe UByte(b"1111_1010")
    }

    "^" in {
      (UByte(b"1010_1010") ^ UByte(b"1111_0000")) shouldBe UByte(b"0101_1010")
    }

    "unary_-" in {
      (-UByte(50)) shouldBe -50
    }

    "unary_~" in {
      (~UByte(b"1010_1010")) shouldBe UByte(b"0101_0101")
    }

    "<<" in {
      (UByte(b"0011_0000") << 2) shouldBe UByte(b"1100_0000")
      (UByte(b"1100_0000") << 2) shouldBe UByte(b"0000_0000")
    }

    ">>" in {
      (UByte(b"0000_1100") >> 2) shouldBe UByte(b"0000_0011")
      (UByte(b"0000_0011") >> 2) shouldBe UByte(b"0000_0000")
      (UByte(b"1100_0000") >> 2) shouldBe UByte(b"1111_0000")
    }

    ">>>" in {
      (UByte(b"0000_1100") >>> 2) shouldBe UByte(b"0000_0011")
      (UByte(b"0000_0011") >>> 2) shouldBe UByte(b"0000_0000")
      (UByte(b"1100_0000") >>> 2) shouldBe UByte(b"0011_0000")
    }
  }

end UByteSpec
