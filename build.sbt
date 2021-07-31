lazy val scalaTestV = "3.2.9"

lazy val globalSettings = Seq(
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-Yexplicit-nulls"
  ),
  scalaVersion := "3.0.1"
)

lazy val root = (project in file("."))
  .settings(globalSettings)
  .settings(
    name := "scala-gb",
    version := "0.0.1"
  )
  .aggregate(cpu, infrastructure)
  .dependsOn(cpu, infrastructure)

lazy val cpu = (project in file("cpu"))
  .settings(globalSettings)
  .settings(
    name := "cpu",
    version := "0.0.1"
  )
  .dependsOn(infrastructure)

lazy val memory = (project in file("memory"))
  .settings(globalSettings)
  .settings(
    name := "memory",
    version := "0.0.1"
  )
  .dependsOn(infrastructure)

lazy val infrastructure = (project in file("infrastructure"))
  .settings(globalSettings)
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % scalaTestV % Test
    ),
    name := "infrastructure",
    version := "0.0.1"
  )
