import scala.io._
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

import net.liftweb.json._
/**
  * Created by dblock on 3/21/17.
  */
object Main {
  def parseWithJackson(json: BufferedSource): Map[String, Object] = {
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    mapper.readValue[Map[String, Object]](json.reader())
  }

  def parseWithLiftweb(json: BufferedSource): JValue = {
    net.liftweb.json.parse(json.mkString)
  }

  def main(args: Array[String]): Unit = {
    val filename = args.head
    // read
    println(s"Reading ${args.head} ...")
    println(parseWithJackson(Source.fromFile(filename)))
    println(parseWithLiftweb(Source.fromFile(filename)))
  }
}
