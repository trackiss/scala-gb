package com.github.trackiss.scalagb.infrastructure

final class UByte private (private val value: Byte) extends AnyVal {
  override def toString: String = toInt.toString

  def toBinaryString: String = {
    val bin = toInt.toBinaryString

    if (value > 0)
      ("0" * (8 - bin.length)) + bin
    else
      bin.takeRight(8)
  }

  def toHexString: String = {
    val hex = toInt.toHexString

    if (value > 0)
      ("0" * (2 - hex.length)) + hex
    else
      hex.takeRight(2)
  }

  def signed: Byte = value

  def toShort: Short = toInt.toShort

  def toUShort: UShort = UShort(toInt)

  def toChar: Char = toInt.toChar

  def toInt: Int = if (value < 0) value + (0xff + 1) else value

  def toLong: Long = toInt

  def isHigh(bit: Int): Boolean = (((value & 0xff) >>> (bit & 7)) & 1) == 1

  def isLow(bit: Int): Boolean = !isHigh(bit)

  def >(that: UByte): Boolean = this.toInt > that.toInt

  def >=(that: UByte): Boolean = this.toInt >= that.toInt

  def <(that: UByte): Boolean = this.toInt < that.toInt

  def <=(that: UByte): Boolean = this.toInt <= that.toInt

  def +(that: UByte): UByte = new UByte((this.value + that.value).toByte)

  def -(that: UByte): UByte = new UByte((this.value - that.value).toByte)

  def increment: UByte = new UByte((value + 1).toByte)

  def decrement: UByte = new UByte((value - 1).toByte)

  def &(that: UByte): UByte = new UByte((this.value & that.value).toByte)

  def |(that: UByte): UByte = new UByte((this.value | that.value).toByte)

  def ^(that: UByte): UByte = new UByte((this.value ^ that.value).toByte)

  def unary_- : Int = -toInt

  def unary_~ : UByte = new UByte((~value).toByte)

  def <<(shift: Int): UByte = new UByte((value << (shift & 7)).toByte)

  def >>(shift: Int): UByte = new UByte((value >> (shift & 7)).toByte)

  def >>>(shift: Int): UByte = new UByte(
    ((value & 0xff) >>> (shift & 7)).toByte
  )
}

object UByte {
  def MaxValue: UByte = UByte(0xff)

  def MinValue: UByte = UByte(0x00)

  def apply(value: Int): UByte = {
    require(value >= 0)
    new UByte(value.toByte)
  }
}
