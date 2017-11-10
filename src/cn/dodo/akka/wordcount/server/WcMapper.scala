package cn.dodo.akka.wordcount.server

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props
import cn.dodo.akka.wordcount.actor.WcMapperActor
import cn.dodo.akka.ConfigHelper

object WcMapper {
  
  def main(args: Array[String]): Unit = {
    val conf = ConfigHelper.getConf("44443")

		val wcMapperSys = ActorSystem("wcMapperSys",ConfigFactory.parseMap(conf));
    wcMapperSys.actorOf(Props[WcMapperActor], "wcMapperActor");
  }
}