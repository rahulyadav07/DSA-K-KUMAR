package OpenClosePrinciple.correctruleOfOCP



class EmailNotification: NotificationStrategy {
    override fun sendMessage(message: String) {
        print("Sending sms: $message")
    }

}
