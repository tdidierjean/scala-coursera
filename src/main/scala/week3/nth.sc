import week3._
import java.util.NoSuchElementException

object nth {
  trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
  }

  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
  }

  class Nil[T] extends List[T] {
    def isEmpty: Boolean = true
    def head: Nothing = throw new NoSuchElementException("Nil.head")
    def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  }

  def nth[T](x: Int, xs: List[T]): T = {
    if (x == 0) return xs.head

    nth[T](x - 1, xs.tail)
  }

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

  nth(3, list)
}

//def nth[T](val x: Int, val list: List[T]): T = {
//  return list.head()
//}