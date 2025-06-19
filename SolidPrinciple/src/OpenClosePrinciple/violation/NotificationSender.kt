package OpenClosePrinciple.violation



class NotificationSender {
    fun sendNotification(message:String, type: String) {
        when(type) {
            "email" -> print("Sending mail : $message")
            "sms"-> print("Sending SMS : $message")
        }
    }
}
/**
 * What's Problem in this code according to Open close Principle
 *
 * Whenever new type of notification will introduce like (whatsapp , Push notification), For handling type
 *  you need to modify Notification Sender according to OCP Class should be open for extension close for modification
 */