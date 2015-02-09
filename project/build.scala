import sbt._

object MasterBuild extends Build {
  lazy val root = Project(id = "root",
                          base = file(".")) aggregate(frontend, backend, api)

  lazy val frontend = Project(id = "front-end",
                              base = file("front-end")) dependsOn(api % "test->test;compile->compile")

  lazy val backend = Project(id = "back-end",
                             base = file("back-end")) dependsOn(api % "test->test;compile->compile")

  lazy val api = Project(id = "api",
                            base = file("api"))
}