package xpay

class XpayImpl extends Xpay {
  private var creditCardNo: String = null
  private var customerName: String = null
  private var cardExpMonth: String = null
  private var cardExpYear: String = null
  private var cardCVVNo: Short = 0
  private var amount: Double = .0

  def getCreditCardNo: String = {
    creditCardNo
  }

  def setCreditCardNo(creditCardNo: String) {
    this.creditCardNo = creditCardNo
  }

  def getCustomerName: String = {
    customerName
  }

  def setCustomerName(customerName: String) {
    this.customerName = customerName
  }

  def getCardExpMonth: String = {
    return cardExpMonth
  }

  def setCardExpMonth(cardExpMonth: String) {
    this.cardExpMonth = cardExpMonth
  }

  def getCardExpYear: String = {
    cardExpYear
  }

  def setCardExpYear(cardExpYear: String) {
    this.cardExpYear = cardExpYear
  }

  def getCardCVVNo: Short = {
    cardCVVNo
  }

  def setCardCVVNo(cardCVVNo: Short) {
    this.cardCVVNo = cardCVVNo
  }

  def getAmount: Double = {
    amount
  }

  def setAmount(amount: Double) {
    this.amount = amount
  }
}
