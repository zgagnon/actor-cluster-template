
enablePlugins(JavaServerAppPackaging)

mappings in Universal <+= (packageBin in Compile, sourceDirectory) map {(_, src) =>
  val conf = src / "main" / "resources" / "reference.conf"
  conf -> "conf/application.conf"
}

// Change this to your backend main class with package structure
mainClass in Compile := Some("Frontend")
