import sbt._

object MasterBuild extends Build {
  lazy val root = Project(id = "root",
                          base = file(".")) aggregate(frontend)

  lazy val frontend = Project(id = "front-end",
                              base = file("front-end"))
}