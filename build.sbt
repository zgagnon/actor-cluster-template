import NativePackagerKeys._

name := "sharding-test"

version := "1"

scalaVersion := "2.11.2"

libraryDependencies ++= List(
  "com.typesafe.akka" %% "akka-cluster" % "2.3.9",
  "com.typesafe.akka" %% "akka-kernel" % "2.3.9",
  "com.typesafe.akka" %% "akka-contrib" % "2.3.9")

enablePlugins(JavaAppPackaging)