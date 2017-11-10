package cn.dodo.akka.wordcount.server

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props
import cn.dodo.akka.ConfigHelper
import cn.dodo.akka.wordcount.actor.WcReducerActor

object WcReducer {
  
  
  def main(args: Array[String]): Unit = {
    val conf = ConfigHelper.getConf("44442")

		val wcReducerSys = ActorSystem("wcReducerSys",ConfigFactory.parseMap(conf));
    wcReducerSys.actorOf(Props[WcReducerActor], "wcReducerActor");
  }
}