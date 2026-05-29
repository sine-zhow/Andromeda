package ad

import chisel3._

/**
  * 参数化位宽加法器
  * @param width 数据位宽
  */
class Adder(val width: Int) extends Module {
  val io = IO(new Bundle {
    val a   = Input(UInt(width.W))
    val b   = Input(UInt(width.W))
    val sum = Output(UInt(width.W))
  })

  // 组合逻辑连线
  io.sum := io.a + io.b
}