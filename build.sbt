                        name :=  "java-suffuse"
                 description :=  "suffuse java bindings based on bridj"
                organization :=  "org.improving"
                     version :=  "0.0.1-SNAPSHOT"
                scalaVersion :=  "2.11.8"
                 logBuffered :=  false
  initialCommands in console +=  "import org.bridj._, suffuse._, osxfuse._, OsxfuseLibrary._, Pointer._"
         libraryDependencies +=  "com.nativelibs4java" % "bridj" % "0.7.0"
         libraryDependencies +=  "com.nativelibs4java" % "jnaerator-runtime" % "0.12"
         libraryDependencies +=  "com.novocode" % "junit-interface" % "0.11"  % "test"
         testOptions in Test +=  Tests.Argument(TestFrameworks.JUnit, "-v")
 sourceGenerators in Compile <+= generateBridj

def generateBridj = Def.task[Seq[File]] {
  val outdir = (sourceManaged in Compile).value / "c"
  val config = (resourceDirectory in Compile).value / "config.jnaerator"
  val cmd    = s"$config -f -o $outdir" split "\\s+"

  com.ochafik.lang.jnaerator.JNAerator main cmd

  (outdir ** "*.java").get
}
