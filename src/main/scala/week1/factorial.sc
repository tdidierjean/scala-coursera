object Factorial {
  def factorial (n: Int): Int = {
    def loop(n: Int, total: Int): Int =
      if (n == 0) total else loop(n - 1, total * n)

    loop (n, 1)
  }

  factorial(5)
}