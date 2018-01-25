object Currying {

  def general (f: Int => Int, algo: (Int, Int) => Int, default: Int)(a: Int, b: Int): Int = {
    if (a > b) default
    else algo(f(a), general(f, algo, default)(a + 1, b))
  }

  def product (f: Int => Int)(a: Int, b: Int): Int = general(f, (x, y) => x * y, 1)(a, b)

//  {
//    if (a > b) 1
//    else f(a) * product(f)(a + 1, b)
//  }

  product(x => x)(1, 5)

  def fact(n: Int): Int = {
    product(x => x)(1, n)
  }

  fact(4)

  def add (a: Int): Int => Int = {
    b:Int => a + b
  }

  add(3)(4)

  //  general(x: Int => x, (y: Int, z: Int) => y + z, 0)(1, 3)

  def sqrt(x: Double): Int = {
    fixedPoint(averageDamp(y => x / y), 1)(x)
  }
}