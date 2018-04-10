import org.joda.time.format.DateTimeFormat
import org.joda.time.{Days, LocalDate, Period}

object HelloWorld extends App {
    println("hello world")
    val formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
    var startDate = LocalDate.parse("2018-03-30", formatter)
    var endDate = LocalDate.parse("2018-04-03", formatter)
    println(Days.daysBetween(startDate,endDate).getDays + 1)

  var dateBeingProcessed = startDate
  dateBeingProcessed = dateBeingProcessed.plusDays(2)
  println(dateBeingProcessed)
    //var days = Period.fieldDifference(startDate, endDate)
    //println(days)
}
