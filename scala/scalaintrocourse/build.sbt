name := "scalaintrocourse"

organization := "org.hablapps"

scalaVersion := "2.11.7"

unmanagedSourceDirectories in Test ++= Seq(
  baseDirectory.value / "src" / "main" / "scala" / "org" / "hablapps" / "curso" / "exercise1-oo" / "test",
  baseDirectory.value / "src" / "main" / "scala" / "org" / "hablapps" / "curso" / "exercise2-funcional" / "test",
  baseDirectory.value / "src" / "main" / "scala" / "org" / "hablapps" / "curso" / "exercise3-genericidad" / "test"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6"
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-language:higherKinds")

initialCommands in console := """
  | import org.hablapps.scalaintro._
  | import intro.templates._
  | import oo.templates._
  | import funcional.templates._
  | import azucar.templates._
  | import implicitos.templates._
  | import genericidad.templates._
  |""".stripMargin
