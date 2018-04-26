//is a character a vowel or not
def isVowel(checkChar: Char): Boolean ={
  checkChar =='a' || checkChar == 'e' || checkChar == 'i'|| checkChar == 'o'|| checkChar == 'u'
}
isVowel('g')

def isVowel2(checkChar: Char): Boolean = {
  "aeiou".contains(checkChar)
}
isVowel2('a')

//if vowels are in a string
def stringsVowels(str:String): String ={
  var s = ""
  for(ch <- str){
    if("aeiou".contains(ch))
      s = s + ch
  }
  s
}
stringsVowels("hello")

//with yield and guard var s can be removed and the return s too
def stringVowels2(str:String): String={
  var s = for(ch <- str if("aeiou".contains(ch))) yield ch
  s
}
stringVowels2("hello")

//recursive
// for recursion you need to distinguish 2 cases, 1st is the base case and the recursive case
def stringVowelsrec(str:String): String ={
  //base case
  if(str.length == 0){
    return ""
  }
  else{
    val ch = str(0)
    val rest = stringVowelsrec(str.substring(1))
    if(isVowel2(ch)) ch + rest else rest
  }
}
stringVowelsrec("helloo")

//vowels with default parameters
def vowelsdefault(str: String, vowelChars: String ="aeiou", ignoreCase: Boolean = true): String ={
  for(ch <- str.toLowerCase if(vowelChars.contains(ch))) yield ch
}
vowelsdefault("hello")