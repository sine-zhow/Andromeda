package ad

import chisel3._
// 👇 关键修改：将 chisel.simulator 改为 chisel3.simulator
import chisel3.simulator.EphemeralSimulator._ 
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class AdderTest extends AnyFlatSpec with Matchers {
  
  behavior of "Adder"

  it should "correctly add two numbers and handle overflow" in {
    // 现在 simulate 可以被正常识别了
    simulate(new Adder(8)) { dut =>
      // 测试用例 1: 常规加法 10 + 20 = 30
      dut.io.a.poke(10.U)
      dut.io.b.poke(20.U)
      dut.io.sum.expect(30.U)

      // 测试用例 2: 边界与溢出 250 + 10 = 260 -> 溢出截断为 4
      dut.io.a.poke(250.U)
      dut.io.b.poke(10.U)
      dut.io.sum.expect(4.U)
    }
  }
}