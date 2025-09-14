package OpenClosePrinciple.correctruleOfOCP

/**
 * Open/Closed Principle (OCP) Demonstration
 * 
 * This demo shows how OCP works:
 * 1. The NotificationService is CLOSED for modification
 * 2. We can add new notification types (Push, Slack, WhatsApp) by EXTENSION
 * 3. No existing code needs to be changed when adding new notification methods
 * 4. The system is OPEN for extension but CLOSED for modification
 */
fun main() {
    println("=== Open/Closed Principle (OCP) Demo ===\n")
    
    val notificationService = NotificationService()
    
    // Original notification types (existing code - CLOSED for modification)
    println("1. Using EXISTING notification types (Email & SMS):")
    val emailNotification = EmailNotification()
    val smsNotification = SmsNotification()
    
    notificationService.sendNotification(emailNotification, "Welcome to our service!")
    notificationService.sendNotification(smsNotification, "Your order has been confirmed!")
    
    println("${"=".repeat(50)}\n")
    
    // New notification types (EXTENSION - OPEN for extension)
    println("2. Using NEW notification types (Push, Slack, WhatsApp) - EXTENDED without modifying existing code:")
    val pushNotification = PushNotification()
    val slackNotification = SlackNotification()
    val whatsAppNotification = WhatsAppNotification()
    
    notificationService.sendNotification(pushNotification, "New message received!")
    notificationService.sendNotification(slackNotification, "Team meeting in 10 minutes!")
    notificationService.sendNotification(whatsAppNotification, "Happy Birthday! 🎉")
    
    println("${"=".repeat(50)}\n")
    
    // Bulk notifications using all types
    println("3. Bulk notifications using ALL types (existing + new):")
    val allNotificationTypes = listOf(
        emailNotification,      // Existing
        smsNotification,        // Existing
        pushNotification,       // New
        slackNotification,      // New
        whatsAppNotification    // New
    )
    
    notificationService.sendBulkNotifications(allNotificationTypes, "System maintenance scheduled for tonight!")
    
    println("${"=".repeat(50)}\n")
    
    // Demonstrate that we can easily add more notification types
    println("4. Adding ANOTHER new notification type (Discord) - still no modification needed:")
    val discordNotification = DiscordNotification()
    notificationService.sendNotification(discordNotification, "Gaming session starting now! 🎮")
    
    println("\n🎯 OCP Principle demonstrated successfully!")
    println("✅ Existing code (EmailNotification, SmsNotification, NotificationService) was NOT modified")
    println("✅ New functionality (Push, Slack, WhatsApp, Discord) was added by EXTENSION")
    println("✅ System is OPEN for extension but CLOSED for modification")
}

/**
 * Another new notification type - Discord
 * This shows how easy it is to extend the system
 * without modifying any existing code
 */
class DiscordNotification: NotificationStrategy {
    override fun sendMessage(message: String) {
        println("🎮 Sending Discord message: $message")
    }
}
