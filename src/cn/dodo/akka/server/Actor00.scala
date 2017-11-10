package cn.dodo.akka.server

import cn.dodo.akka.server.bean.Student
import akka.actor.Actor
import cn.dodo.akka.server.bean.Person

class Actor00 extends Actor {
  def receive = {
    case msg: String  => println("Actor00:" + msg)
    case msg: Student => println("Actor00:" + msg.namex)
    case msg:Person =>println("Actor00:" +msg.namex+"~~~"+msg.agex)
  }
}