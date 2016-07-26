package controllers

import controllers.Application._
import play.api.mvc.Action
import play.mvc.Controller

/**
  * add description
  * created at 2016/7/26
  *
  * @author vncnliu
  * @version default 1.0.0
  */
object Wechat extends Controller{

  def access(signature:String,timestamp: String,nonce: Int,echostr: String) = Action {
    Ok(echostr)
  }
}
