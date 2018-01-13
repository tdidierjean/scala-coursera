package funsets

object Main extends App {
  import FunSets._

  val s1 = singletonSet(23)
  val s2 = singletonSet(50)
  val s3 = union(s1, s2)

  println("forall > 20: " + forall(s3, x => x > 20))
  println("forall > 30: " + forall(s1, x => x > 30))

  println("exists > 20: " + exists(s3, x => x > 20))
  println("exists > 30: " + exists(s3, x => x > 30))
  println("exists > 60: " + exists(s3, x => x > 60))

  printSet(map(s3, x => x * 2))
}
