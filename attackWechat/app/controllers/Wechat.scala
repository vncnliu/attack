package controllers

import config.Contants
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
    val params = Array(timestamp,nonce+"",Contants.WECHAT_TOKEN).sorted.mkString
    val md = java.security.MessageDigest.getInstance("SHA-1")
    val sh1 = md.digest(params.getBytes("UTF-8")).map("%02x".format(_)).mkString
    if(signature.equals(sh1)){
      Ok(echostr)
    }else{
      Forbidden
    }
  }
}
