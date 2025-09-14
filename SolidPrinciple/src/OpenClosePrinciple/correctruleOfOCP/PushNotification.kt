package OpenClosePrinciple.correctruleOfOCP

/**
 * Push Notification implementation
 * This demonstrates OCP - we can add new notification types
 * without modifying existing code (EmailNotification, SmsNotification)
 */
class PushNotification: NotificationStrategy {
    override fun sendMessage(message: String) {
        println("🔔 Sending Push Notification: $message")
    }
}
