object sheet1{
  val answer = 9 * 5

  val intersection = "Hello".intersect("World")

  1.to(10)

  1 to 10

  val result = 1.+(10)

  "Hello".distinct

  "Hello".apply(4)

  "Hello"(4)

  6 * 7

  val a = 6 * 7

  def abs(x: Double) = if (x >= 0) x else -x

  abs(10.01)

  def fac(n: Int): Int = if(n <= 0) 1 else n * fac(n-1)

  fac(5)

  def fac2(n: Int): Int = {
    if(n<=0){
      1
    }
    else{
      n * fac(n-1)
    }
  }

  fac2(5)

  val x = 4
  if(x>0) 1 else 4

  for(i <- 1 to 3; j <- 1 to 3)
    print((10 * i + j) + " ")

  //with guards
  for(i <- 1 to 3; j <- 1 to 3 if i != j)
    print((10 * i + j) + " ")

  // adding yield to the for loop generates an collection
  val ret = for(i <- 1 to 10) yield i % 3

  // defaults in functions
  def decorate(str: String, left: String = "{{", right: String = "}}"): String = {
    left + str + right
  }
  decorate("hello")
  decorate("hello","<<",">>")

}