package suffuse
package tests

import osxfuse._, org.bridj._, Pointer._
import java.nio.file.Files
import org.junit.Test
import org.junit.Assert._
import scala.reflect.ClassTag

/** Not clear on why stat is being generated as an abstract class.
 *  new stat{} leads to failures, whereas this works as expected.
 */
class struct_stat extends stat { }

class SmokeTest {
  def alloc[A: ClassTag]              = Pointer allocate classOf[A]
  def classOf[A: ClassTag] : Class[A] = implicitly[ClassTag[A]].runtimeClass.asInstanceOf[Class[A]]
  def describe[A: ClassTag]           = BridJ describe classOf[A]
  def sizeOf[A: ClassTag]             = BridJ sizeOf classOf[A]
  def octal(s: String): Short         = BigInt(s, 8).toShort

  def pointerTo[T <: NativeObject](value: T): Pointer[T] = Pointer pointerTo (BridJ protectFromGC value)

  implicit def liftString(s: String): Pointer[java.lang.Byte] = Pointer.pointerToCString(s)

  @Test
  def mkdirTest(): Unit = {
    val path = Files createTempDirectory "suffuse"
    Files delete path

    assertTrue(!path.toFile.exists)
    val result = OsxfuseLibrary.mkdir(path.toString, octal("555"))
    assertTrue(result == 0)
    assertTrue(path.toFile.isDirectory)
  }

  @Test
  def statTest(): Unit = {
    val path = Files createTempDirectory "suffuse"
    val st: stat  = new struct_stat
    val ptr = pointerTo(st)

    println( describe[struct_stat] )
    OsxfuseLibrary.stat( path.toString, ptr)
    println( path )
    println( st )
    assertTrue(st == ptr.get)
  }
}
