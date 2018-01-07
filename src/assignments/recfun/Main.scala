package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println(balance("(d(few))(ww)".toList))

    println(countChange(7, List(1,2,3)))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || r == 0 || r == c) 1
      else pascal(c-1, r-1) + pascal(c, r-1)
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      var count = 0

      if (chars.nonEmpty) processChar(chars)

      def processChar(subChars: List[Char]): Any = {
        if (subChars.head == '(') {
          count = count + 1
        }
        else if (subChars.head == ')')
        {
          count = count - 1
        }

        if (count >= 0 && subChars.tail.nonEmpty) processChar(subChars.tail)
      }

      if (count == 0) true
      else false
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {

      def processCoins(remainingMoney: Int, remainingCoins: List[Int]): Int = {
        if (remainingMoney > 0 && remainingCoins.nonEmpty) {
          processCoins(remainingMoney - remainingCoins.head, remainingCoins) + processCoins(remainingMoney, remainingCoins.tail)
        } else if (remainingMoney == 0) 1
        else 0
      }

      processCoins(money, coins)
    }
  }
