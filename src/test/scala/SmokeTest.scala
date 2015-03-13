package suffuse
package tests

import osxfuse._, org.bridj._, Pointer._
import java.nio.file.Files
import org.junit.Test
import org.junit.Assert._

class SmokeTest {
  @Test
  def makeDirectory(): Unit = {
    val path = Files createTempDirectory "suffuse"
    Files delete path

    assertTrue(!path.toFile.exists)
    val result = OsxfuseLibrary mkdir pointerToCString(path.toString)
    assertTrue(result == 0)
    assertTrue(path.toFile.isDirectory)
  }
}
