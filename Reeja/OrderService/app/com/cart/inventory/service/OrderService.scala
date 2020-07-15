package com.cart.inventory.service


import com.cart.inventory.bo.CartInfo
import com.cart.inventory.model.CartItems
import com.cart.inventory.transformer.StateTransformer

import scala.concurrent.Future
import javax.inject.Inject
import com.cart.inventory.const.AppConst.STATE_ORDERED

class OrderService @Inject()( stateTransformer: StateTransformer) {

  def processOrder(cartItems: CartItems) = {
    val order:CartInfo= CartInfo(0,STATE_ORDERED,cartItems.items,"","")
    stateTransformer.process(order)
  }
}