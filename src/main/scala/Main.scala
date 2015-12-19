import cl.{add, bye, hello, maybe}
/**
 * Created by Mnenmenth Alkaborin
 * Please refer to LICENSE file if included
 * for licensing information
 * https://github.com/Mnenmenth
 */
object Main {
  def main(args: Array[String]): Unit = {
    hello.printhello()
    maybe.printMaybe()
    bye.printBye()
    println(add.add(30, 30) + add.fac(10))
  }
}