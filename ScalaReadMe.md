# Scala notes

Type inference  
when scala figures out the datatype of the provided value based on the context

val - immutable 

var - can be changed to refer to different objects of the same type(strongly typed)

scala is statically typed one of the basic things it means is that issues will be caught at run time instead of compile 

you dont have to specify the data type to scala but u can if you want example
var greeting = "hello" is good but so is
var greeting: String = null

two ways to write methods
1.to 10   or
1 to 10

1 + 10
can be written as val result = 1.+(10) because all the operators are methods in scala

++ and -- operators are not there in scala use counter += 1

we know that methods operate on objects in scala
scala also has functions that dont operate on objects
example:
sqrt(2) //function
BigInt.probablePrime(100, scala.util.Random) //method

if the method is an accessor method then you dont use '()' brackets after but '()' are required for mutators
example "hello".distinct does not need the brackets

both these are equal
 "Hello".apply(4)
  "Hello"(4)
apply methods are special

You dont have to specify the return types for regular functions its optional but you have to specify it for recursive functions

def fac(n: Int): Int = if(n <= 0) 1 else n * fac(n-1) 

in scala if is an expression which holds value
example:

Datatype any is the equivalent of any in java

datatype unit is a type void in java

blocks are also expression in scala { ... } the last ecpression od the block is the value of the block

loops
does not have 3 part for loop
for(1 <- 1 to n)    no val or var in front of i
works with any collection
multiple generators too
for(i <- 1 to 3; j <- 1 to3)

default parameters
scala provides the functionality for providing default parameters in a function,
example is the decorator method in the scalaexamples worksheet

sum(1 to 10 : _*) would be read at  : would be consider this as '\_\*' would be a sequence of something

Notes and questions to self

why is apply method special