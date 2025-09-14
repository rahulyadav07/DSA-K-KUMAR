package OpenClosePrinciple.correctruleOfOCP

/**
 * Slack Notification implementation
 * Another example of OCP - extending functionality without modifying existing code
 */
class SlackNotification: NotificationStrategy {
    override fun sendMessage(message: String) {
        println("💬 Sending Slack message: $message")
    }
}
