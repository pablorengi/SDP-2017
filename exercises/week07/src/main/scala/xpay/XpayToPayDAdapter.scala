package xpay

/**
  * Created by pabloren on 04/03/2017.
  */
class XpayToPayDAdapter(var payment: Xpay) extends PayD {

  override def getCustCardNo: String = payment.getCreditCardNo

  override def setCustCardNo(custCardNo: String): Unit = payment.setCreditCardNo(custCardNo)

  override def getCardOwnerName: String = payment.getCustomerName

  override def setCardOwnerName(cardOwnerName: String): Unit = payment.setCustomerName(cardOwnerName)

  override def getCardExpMonthDate: String = payment.getCardExpMonth

  override def setCardExpMonthDate(cardExpMonthDate: String): Unit = payment.setCardExpMonth(cardExpMonthDate)

  override def getCVVNo: Integer = payment.getCardCVVNo

  override def setCVVNo(cVVNo: Integer): Unit = payment.setCardCVVNo(cVVNo.toShort)

  override def getTotalAmount: Double = payment.getAmount

  override def setTotalAmount(totalAmount: Double): Unit = payment.setAmount(totalAmount)

}
