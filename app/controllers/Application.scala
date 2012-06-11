package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import views._
import models._

object Application extends Controller {

  
  val loginForm = Form(
      mapping(
          "username" -> text,
          "password" -> text
      )(User.apply)(User.unapply)
  )
      
  val registrationForm = Form(
      mapping(
          "username" -> text,
          "password" -> text
      )(User.apply)(User.unapply)
  )
      
  def index = Action {
    val users = User.findAll
    Ok(html.index(loginForm, registrationForm, users))
  }
  
  def registerUser = Action { implicit request =>
    val users = User.findAll
    registrationForm.bindFromRequest.fold(
        formWithErrors => BadRequest(views.html.index(loginForm, formWithErrors, users)),
        {
          case User(username, password) =>  {
	          User.create(username, password)
	          Redirect(routes.Application.index())
	        }
        }
      )
    }
  
  
  
}
