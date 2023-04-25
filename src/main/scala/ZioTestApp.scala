import zio._
import zio.Console._

import java.io.IOException

object ZioTestApp extends ZIOAppDefault {

  def run: ZIO[Any, IOException, Unit] = myAppLogic

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