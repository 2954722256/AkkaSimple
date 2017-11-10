package cn.dodo.akka

import java.util.HashMap
import java.util.ArrayList

object ConfigHelper {
  def getConf(port: String): HashMap[String, Object] = {
    val conf = new HashMap[String, Object]()
    val list = new ArrayList[String]()
    list.add("akka.remote.netty.tcp")
    conf.put("akka.remote.enabled-transports", list) //参数是个集合
    conf.put("akka.actor.provider", "akka.remote.RemoteActorRefProvider")
    conf.put("akka.remote.netty.tcp.hostname", "127.0.0.1")
    conf.put("akka.remote.netty.tcp.port", port)
    conf
  }
}