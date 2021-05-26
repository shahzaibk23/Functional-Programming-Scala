package Assignment3

object task10 extends App {

  import chisel3._
  import chisel3.stage.ChiselStage
  import chisel3.util._
  import chisel3.experimental.{BaseModule}

  trait ModuleIO {
    def in1: UInt
    def in2: UInt
    def out: UInt
  }

  class Add extends RawModule with ModuleIO {
    val in1 = IO(Input(UInt(8.W)))
    val in2 = IO(Input(UInt(8.W)))
    val out = IO(Output(UInt(8.W)))
    out := in1 + in2
  }

  class Sub extends RawModule with ModuleIO {
    val in1 = IO(Input(UInt(8.W)))
    val in2 = IO(Input(UInt(8.W)))
    val out = IO(Output(UInt(8.W)))
    out := in1 - in2
  }

  class Top [T <: BaseModule with ModuleIO] (gen1T: => T, gen2T: => T) extends Module {
    val io = IO(new Bundle{
      val in1 = Input(UInt(8.W))
      val in2 = Input(UInt(8.W))
      val out_1 = Output(UInt(8.W))
      val out_2 = Output(UInt(8.W))

    })
    val subModule1 = Module(gen1T)
    val subModule2 = Module(gen2T)

    io.out_1 := subModule1.out
    io.out_2 := subModule2.out

    subModule1.in1 := io.in1
    subModule1.in2 := io.in2

    subModule2.in1 := io.in1
    subModule2.in2 := io.in2


  }

  println(ChiselStage.emitVerilog(new Top(new Add, new Sub)))

}
