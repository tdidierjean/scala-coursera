object Rationals {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  val res= x.sub(y).sub(z)

  y.add(y)

  class Rational (x: Int, y: Int) {
    require(y != 0, "cant be zero")

    // secondary constructor
    def this (x:Int) = this(x, 1)

    def numer = x
    def denom = y

    def add (that: Rational) =
      new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
      )

    def neg = new Rational(-numer, denom)

    def sub (that: Rational) = add(that.neg)

    override def toString = numer + "/" + denom
  }
}

