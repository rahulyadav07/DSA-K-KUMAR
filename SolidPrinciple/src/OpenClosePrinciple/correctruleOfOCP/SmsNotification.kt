package OpenClosePrinciple.correctruleOfOCP

class SmsNotification: NotificationStrategy {
    override fun sendMessage(message: String) {
        print("Sending sms: $message")
    }

}
