package com.github.trackiss.scalagb.infrastructure

opaque type UByte = Byte

object UByte:
  def MaxValue: UByte = UByte(0xff)

  def MinValue: UByte = UByte(0x00)

  def apply(value: Int): UByte = value.toByte

  extension (self: UByte)
    def toString: String = self.toInt.toString

    def toBinaryString: String =
      val bin = self.toInt.toBinaryString

      if self > 0 then
        ("0" * (8 - bin.length)) + bin
      else
        bin.takeRight(8)

    def toHexString: String =
      val hex = self.toInt.toHexString

      if self > 0 then
        ("0" * (2 - hex.length)) + hex
      else
        hex.takeRight(2)

    def signed: Byte = self

    def toShort: Short = self.toInt.toShort

    def toUShort: UShort = UShort(self.toInt)

    def toChar: Char = self.toInt.toChar

    def toInt: Int = if self < 0 then self + (0xff + 1) else self

    def toLong: Long = self.toInt

    def isHigh(bit: Int): Boolean = (((self & 0xff) >>> (bit & 7)) & 1) == 1

    def isLow(bit: Int): Boolean = !isHigh(bit)

    def >(other: UByte): Boolean = self.toInt > other.toInt

    def >=(other: UByte): Boolean = self.toInt >= other.toInt

    def <(other: UByte): Boolean = self.toInt < other.toInt

    def <=(other: UByte): Boolean = self.toInt <= other.toInt

    def +(other: UByte): UByte = UByte((self + other).toByte)

    def -(other: UByte): UByte = UByte((self - other).toByte)

    def increment: UByte = UByte((self + 1).toByte)

    def decrement: UByte = UByte((self - 1).toByte)

    def &(other: UByte): UByte = UByte((self & other).toByte)

    def |(other: UByte): UByte = UByte((self | other).toByte)

    def ^(other: UByte): UByte = UByte((self ^ other).toByte)

    def unary_- : Int = -(self.toInt)

    def unary_~ : UByte = UByte((~self).toByte)

    def <<(shift: Int): UByte = UByte((self << (shift & 7)).toByte)

    def >>(shift: Int): UByte = UByte((self >> (shift & 7)).toByte)

    def >>>(shift: Int): UByte = UByte(((self & 0xff) >>> (shift & 7)).toByte)

end UByte
