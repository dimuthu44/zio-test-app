import zio._
import zio.Console._

import java.io.IOException

object ZioTestApp extends ZIOAppDefault {

  def run: ZIO[Any, IOException, Unit] = myAppLogic
  
/**
* 
* The ZIO[R, E, A] data type has three type parameters: R => Either[E, A]

* R - Environment Type. The effect requires an environment of type R. If this type parameter is Any, it means the effect has no requirements, because we can run the effect with any value (for example, the unit value ()).
* E - Failure Type. The effect may fail with a value of type E. Some applications will use Throwable. If this type parameter is Nothing, it means the effect cannot fail, because there are no values of type Nothing.
* A - Success Type. The effect may succeed with a value of type A. If this type parameter is Unit, it means the effect produces no useful information, while if it is Nothing, it means the effect runs forever (or until failure).
*/
  val myAppLogic =
    for {
      _ <- printLine("Hello! What is your name?")
      name <- readLine
      _ <- printLine(s"Hello, $name, welcome to ZIO!")
    } yield ()

  val x: ZIO[Any, Nothing, Int] = ZIO.succeed(42)
  val y: ZIO[Any, String, Nothing] = ZIO.fail("failed")
  val z: IO[IOException, Nothing] = ZIO.fail(new IOException("Error"))

  val zioOption: IO[Option[Nothing], Int] = ZIO.fromOption(Some(2))
}
