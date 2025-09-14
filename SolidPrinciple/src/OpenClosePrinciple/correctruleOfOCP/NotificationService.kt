package OpenClosePrinciple.correctruleOfOCP

/**
 * Notification Service - CLOSED for modification
 * This class should NOT be modified when adding new notification types
 * It's OPEN for extension through the NotificationStrategy interface
 */
class NotificationService {
    
    /**
     * Send notification using any strategy
     * This method is CLOSED for modification but OPEN for extension
     */
    fun sendNotification(strategy: NotificationStrategy, message: String) {
        println("🚀 Notification Service: Processing notification...")
        strategy.sendMessage(message)
        println("✅ Notification sent successfully!")
        println()
    }
    
    /**
     * Send bulk notifications
     * This method is also CLOSED for modification
     */
    fun sendBulkNotifications(strategies: List<NotificationStrategy>, message: String) {
        println("📢 Sending bulk notifications to ${strategies.size} channels...")
        strategies.forEach { strategy ->
            sendNotification(strategy, message)
        }
        println("🎉 All bulk notifications completed!")
    }
}
