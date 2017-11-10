package cn.dodo.akka.simple

import akka.actor.Props
import akka.actor.Actor

class Actor1 extends Actor {
  def receive: Actor.Receive = {
    case msg: String => {
      println("Actor1打印：" + msg)
      val a2 = context.actorOf(Props[Actor2])
      a2 ! msg
    }
  }
}