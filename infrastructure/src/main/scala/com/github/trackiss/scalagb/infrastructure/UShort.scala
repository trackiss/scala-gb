package com.github.trackiss.scalagb.infrastructure

import com.github.trackiss.scalagb.infrastructure.UByte

opaque type UShort = Short

object UShort:
  def MaxValue: UShort = UShort(0xffff)

  def MinValue: UShort = UShort(0)

  def apply(value: Int): UShort = value.toShort

  def from(high: UByte, low: UByte): UShort = UShort(((high.toInt << 8) + low.toInt).toByte)
  
  extension (self: UShort)
    def toString: String = self.toInt.toString
  
    def toBinaryString: String =
      val bin = self.toInt.toBinaryString
  
      if self > 0 then
        ("0" * (16 - bin.length)) + bin
      else
        bin.takeRight(16)
  
    def toHexString: String =
      val hex = self.toInt.toHexString
  
      if self > 0 then
        ("0" * (4 - hex.length)) + hex
      else
        hex.takeRight(4)
  
    def signed: Short = self
  
    def toChar: Char = self.toInt.toChar
  
    def toInt: Int = if self < 0 then self + (0xffff + 1) else self
  
    def toLong: Long = self.toInt
  
    def isHigh(bit: Int): Boolean = (((self & 0xffff) >>> (bit & 15)) & 1) == 1
  
    def isLow(bit: Int): Boolean = !isHigh(bit)
  
    def >(other: UShort): Boolean = self.toInt > other.toInt
  
    def >=(other: UShort): Boolean = self.toInt >= other.toInt
  
    def <(other: UShort): Boolean = self.toInt < other.toInt
  
    def <=(other: UShort): Boolean = self.toInt <= other.toInt
  
    def +(other: UShort): UShort = UShort((self + other).toShort)
  
    def -(other: UShort): UShort = UShort((self - other).toShort)
  
    def increment: UShort = UShort((self + 1).toShort)
  
    def decrement: UShort = UShort((self - 1).toShort)
  
    def &(other: UShort): UShort = UShort((self & other).toShort)
  
    def |(other: UShort): UShort = UShort((self | other).toShort)
  
    def ^(other: UShort): UShort = UShort((self ^ other).toShort)
  
    def unary_- : Int = -toInt
  
    def unary_~ : UShort = UShort((~self).toShort)
  
    def <<(shift: Int): UShort = UShort((self << (shift & 15)).toShort)
  
    def >>(shift: Int): UShort = UShort((self >> (shift & 15)).toShort)
  
    def >>>(shift: Int): UShort = UShort(((self & 0xffff) >>> (shift & 15)).toShort)

end UShort
