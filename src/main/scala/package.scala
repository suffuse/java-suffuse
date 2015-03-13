import org.bridj._

package object suffuse {
  type CTag[A] = scala.reflect.ClassTag[A]
  def ctag[A](implicit tag: CTag[A]): CTag[A] = tag

  implicit class PointerOps[A](val ptr: Pointer[A]) {
    def native(implicit tag: CTag[A]): A = ptr getNativeObject tag.runtimeClass
  }
}
