package com.github.trackiss.scalagb.infrastructure

final class UShort private (private val value: Short) extends AnyVal {
  override def toString: String = toInt.toString

  def toBinaryString: String = {
    val bin = toInt.toBinaryString

    if (value > 0)
      ("0" * (16 - bin.length)) + bin
    else
      bin.takeRight(16)
  }

  def toHexString: String = {
    val hex = toInt.toHexString

    if (value > 0)
      ("0" * (4 - hex.length)) + hex
    else
      hex.takeRight(4)
  }

  def signed: Short = value

  def toChar: Char = toInt.toChar

  def toInt: Int = if (value < 0) value + (0xffff + 1) else value

  def toLong: Long = toInt

  def isHigh(bit: Int): Boolean = (((value & 0xffff) >>> (bit & 15)) & 1) == 1

  def isLow(bit: Int): Boolean = !isHigh(bit)

  def >(that: UShort): Boolean = this.toInt > that.toInt

  def >=(that: UShort): Boolean = this.toInt >= that.toInt

  def <(that: UShort): Boolean = this.toInt < that.toInt

  def <=(that: UShort): Boolean = this.toInt <= that.toInt

  def +(that: UShort): UShort = new UShort((this.value + that.value).toShort)

  def -(that: UShort): UShort = new UShort((this.value - that.value).toShort)

  def increment: UShort = new UShort((value + 1).toShort)

  def decrement: UShort = new UShort((value - 1).toShort)

  def &(that: UShort): UShort = new UShort((this.value & that.value).toShort)

  def |(that: UShort): UShort = new UShort((this.value | that.value).toShort)

  def ^(that: UShort): UShort = new UShort((this.value ^ that.value).toShort)

  def unary_- : Int = -toInt

  def unary_~ : UShort = new UShort((~value).toShort)

  def <<(shift: Int): UShort = new UShort((value << (shift & 15)).toShort)

  def >>(shift: Int): UShort = new UShort((value >> (shift & 15)).toShort)

  def >>>(shift: Int): UShort = new UShort(
    ((value & 0xffff) >>> (shift & 15)).toShort
  )
}

object UShort {
  def MaxValue: UShort = UShort(0xffff)

  def MinValue: UShort = UShort(0)

  def apply(value: Int): UShort = {
    require(value >= 0)
    new UShort(value.toShort)
  }

  def from(high: UByte, low: UByte): UShort = new UShort(
    ((high.toInt << 8) + low.toInt).toByte
  )
}
