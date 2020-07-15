package com.cart.inventory.controllers

import com.cart.inventory.model.CartItems
import com.cart.inventory.service.OrderService
import javax.inject._
import play.api.libs.json.Json
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to
 * place the order and update the status to the system
 */
import play.mvc.Controller

class OrderController @Inject()(cc: ControllerComponents,
                             orderService:OrderService
                              ) extends AbstractController(cc) {

  implicit val orderFormat = Json.format[CartItems]

  //Action is asynchronous
  //the type of the body is JsValue,
  // which makes it easier to work with the body since it’s no longer an Option.
  // The reason why it’s not an Option is because the json body parser will validate
  // that the request has a Content-Type of application/json,
  // and send back a 415 Unsupported Media Type response if the request doesn’t meet that expectation.
  // Hence we don’t need to check again in our action code.
  
  def placeOrder = Action(parse.json) {
    req => {
      var finRes: Result = null
      try {
        if (req.hasBody) {
		 println(req)
          val order = Json.fromJson[CartItems](req.body).get
		  println(order)
          orderService.processOrder(order)
          finRes = Ok("order placed")
          finRes
        }
        else {
          finRes = BadRequest("Please Give Valid Request Body")
         finRes
        }
      }catch
        {
          case e: Exception =>
            e.printStackTrace()
            finRes = InternalServerError(e.getMessage)
            finRes
        }
      }
    }
}


