package OpenClosePrinciple.correctruleOfOCP

class EmailNotification: NotificationStrategy {
    override fun sendMessage(message: String) {
        println("📧 Sending email: $message")
    }
}
