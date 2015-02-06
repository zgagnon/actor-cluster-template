import sbt._

object MasterBuild extends Build {
  lazy val root = Project(id = "root",
                          base = file(".")) aggregate(frontend, backend)

  lazy val frontend = Project(id = "front-end",
                              base = file("front-end"))

  lazy val backend = Project(id = "back-end",
                             base = file("back-end"))
}