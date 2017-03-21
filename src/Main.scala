import scala.io._
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

/**
  * Created by dblock on 3/21/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val filename = args.head
    // read
    println(s"Reading ${args.head} ...")
    val json = Source.fromFile(filename)
    // parse
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    val parsedJson = mapper.readValue[Map[String, Object]](json.reader())
    println(parsedJson)
  }
}
