package OpenClosePrinciple.correctruleOfOCP

class SmsNotification: NotificationStrategy {
    override fun sendMessage(message: String) {
        println("📱 Sending SMS: $message")
    }
}
