import sbt._

object MasterBuild extends Build {
  lazy val root = Project(id = "root",
                          base = file(".")) aggregate(frontend, backend, common)

  lazy val frontend = Project(id = "front-end",
                              base = file("front-end")) dependsOn(common % "test->test;compile->compile")

  lazy val backend = Project(id = "back-end",
                             base = file("back-end")) dependsOn(common % "test->test;compile->compile")

  lazy val common = Project(id = "common",
                            base = file("common"))
}