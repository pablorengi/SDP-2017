package xpay

/**
  * Created by pabloren on 04/03/2017.
  */
object TestPayD extends App {

  var paymentXpay: Xpay = new XpayImpl
  var paymentPayD: PayD = new XpayToPayDAdapter(paymentXpay)
  paymentPayD.setCustCardNo("93004324")
  println(paymentPayD.getCustCardNo)
}

