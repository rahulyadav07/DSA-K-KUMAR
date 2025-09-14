/**
 * Open/Closed Principle (OCP) Demonstration
 * 
 * The Open/Closed Principle states that:
 * - Software entities should be OPEN for extension
 * - But CLOSED for modification
 * 
 * This example shows a payment processing system where:
 * - The base PaymentProcessor is CLOSED for modification
 * - New payment methods can be added by EXTENSION (implementing the interface)
 * - No existing code needs to be changed when adding new payment types
 */

/**
 * Payment interface - CLOSED for modification
 * This defines the contract that all payment methods must follow
 */
interface PaymentMethod {
    fun processPayment(amount: Double): PaymentResult
    fun getPaymentType(): String
    fun validatePayment(amount: Double): Boolean
}

/**
 * Payment result data class
 */
data class PaymentResult(
    val success: Boolean,
    val transactionId: String,
    val message: String,
    val amount: Double,
    val paymentType: String
)

/**
 * Base Payment Processor - CLOSED for modification
 * This class should NOT be modified when adding new payment methods
 */
class PaymentProcessor {
    
    /**
     * Process payment using any payment method
     * This method is CLOSED for modification but OPEN for extension
     */
    fun processPayment(paymentMethod: PaymentMethod, amount: Double): PaymentResult {
        return try {
            if (!paymentMethod.validatePayment(amount)) {
                PaymentResult(
                    success = false,
                    transactionId = "",
                    message = "Payment validation failed",
                    amount = amount,
                    paymentType = paymentMethod.getPaymentType()
                )
            } else {
                paymentMethod.processPayment(amount)
            }
        } catch (e: Exception) {
            PaymentResult(
                success = false,
                transactionId = "",
                message = "Payment processing failed: ${e.message}",
                amount = amount,
                paymentType = paymentMethod.getPaymentType()
            )
        }
    }
    
    /**
     * Get payment summary - CLOSED for modification
     */
    fun getPaymentSummary(result: PaymentResult): String {
        return if (result.success) {
            "✅ Payment successful: ${result.paymentType} - Amount: $${result.amount} - Transaction ID: ${result.transactionId}"
        } else {
            "❌ Payment failed: ${result.paymentType} - Amount: $${result.amount} - Error: ${result.message}"
        }
    }
}
