import NativePackagerKeys._

name := "My cluster project"

organization in ThisBuild := "My Org"

version in ThisBuild := "1.0"

scalaVersion in ThisBuild := "2.11.5"

libraryDependencies in ThisBuild ++= List(
  "com.typesafe.akka" %% "akka-cluster" % "2.3.9",
  "com.typesafe.akka" %% "akka-kernel" % "2.3.9",
  "com.typesafe.akka" %% "akka-contrib" % "2.3.9")


