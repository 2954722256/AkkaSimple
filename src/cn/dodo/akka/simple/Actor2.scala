package cn.dodo.akka.simple

import akka.actor.Actor

class Actor2 extends Actor {
	  def receive: Actor.Receive = {
	    case msg:String => println("Actor2打印："+msg)
    }
  }