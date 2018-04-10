name := "SparkTests"

version := "0.1"

scalaVersion := "2.11.8"

/*
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.1"
instead of repeating library dependencies like so use the seq method like below
the %% will force sbt to use the current scala version as specified above*/
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.2.1",
  "org.apache.spark" %% "spark-sql" % "2.2.1",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "joda-time" % "joda-time" % "2.9.9"
)
resolvers += Resolver.mavenLocal