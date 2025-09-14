package OpenClosePrinciple.correctruleOfOCP

/**
 * WhatsApp Notification implementation
 * Demonstrates OCP - we can keep adding new notification types
 * without touching the existing EmailNotification, SmsNotification classes
 */
class WhatsAppNotification: NotificationStrategy {
    override fun sendMessage(message: String) {
        println("📲 Sending WhatsApp message: $message")
    }
}
