import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession


object SparkMeApp {
  def main(args: Array[String]): Unit = {
    /*val conf = new SparkConf().setAppName("SparkMe Application")
    val sc = new SparkContext(conf)

    val sqlContext = new org.apache.spark.sql.SQLContext(sc)*/

    val spark = SparkSession.builder().appName("sparkTest").getOrCreate();


    // for implicit conversions like converting rdds to data frames
    import spark.implicits._



  }
}
