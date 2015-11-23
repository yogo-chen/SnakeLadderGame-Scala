lazy val root = (project in file(".")).
settings(
  name := "UlarTangga",
  scalaSource in Compile := baseDirectory.value / "src",
  scalacOptions in (Compile,doc) := Seq("-groups", "-implicits"),
  mainClass in (Compile, packageBin) := Some("Main")
  )
