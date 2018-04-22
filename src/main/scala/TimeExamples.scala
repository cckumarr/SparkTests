import java.time.{LocalDate,Period}

object TimeExamples extends App {
  println("time examples")
  var startDate = LocalDate.parse("2018-03-30")
  var endDate = LocalDate.parse("2018-04-03")
  var days = Period.between(startDate,endDate).getDays + 1
  println(days)
  //println(Days.daysBetween(startDate,endDate).getDays + 1)

  var dateBeingProcessed = startDate
  dateBeingProcessed = dateBeingProcessed.plusDays(2)
  println(dateBeingProcessed)
  //var days = Period.fieldDifference(startDate, endDate)
  //println(days)
}

