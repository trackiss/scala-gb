lazy val scalaTestV = "3.2.9"

lazy val globalSettings = Seq(
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-Xlint",
    "-Wdead-code"
  ),
  scalaVersion := "2.13.6"
)

lazy val root = (project in file("."))
  .aggregate(domain, infrastructure)
  .settings(globalSettings: _*)
  .settings(
    name := "scala-gb",
    version := "0.0.1"
  )
  .dependsOn(domain, infrastructure)

lazy val domain = (project in file("domain"))
  .settings(globalSettings: _*)
  .settings(
    name := "domain",
    version := "0.0.1"
  )
  .dependsOn(infrastructure)

lazy val infrastructure = (project in file("infrastructure"))
  .settings(globalSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % scalaTestV % Test
    ),
    name := "infrastructure",
    version := "0.0.1"
  )
