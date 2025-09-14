/**
 * Example usage and test cases for Generic LRU Cache implementation in Kotlin
 */
fun main() {
    println("=== Generic LRU Cache Implementation Demo (Kotlin) ===\n")
    
    // Test Case 1: Basic operations with Int keys and values
    println("Test Case 1: Basic operations with Int keys and values (capacity 2)")
    val cache1 = LRUCache<Int, Int>(2)
    
    cache1.put(1, 1)
    println("put(1, 1)")
    cache1.printCache()
    
    cache1.put(2, 2)
    println("put(2, 2)")
    cache1.printCache()
    
    println("get(1) = ${cache1.get(1)}") // returns 1
    cache1.printCache()
    
    cache1.put(3, 3) // evicts key 2
    println("put(3, 3) - evicts key 2")
    cache1.printCache()
    
    println("get(2) = ${cache1.get(2)}") // returns null (not found)
    cache1.printCache()
    
    cache1.put(4, 4) // evicts key 1
    println("put(4, 4) - evicts key 1")
    cache1.printCache()
    
    println("get(1) = ${cache1.get(1)}") // returns null (not found)
    println("get(3) = ${cache1.get(3)}") // returns 3
    println("get(4) = ${cache1.get(4)}") // returns 4
    cache1.printCache()
    
    println("\n${"=".repeat(50)}\n")
    
    // Test Case 2: Edge cases
    println("Test Case 2: Edge cases with capacity 1")
    val cache2 = LRUCache<Int, Int>(1)
    
    cache2.put(2, 1)
    println("put(2, 1)")
    cache2.printCache()
    
    println("get(2) = ${cache2.get(2)}") // returns 1
    cache2.printCache()
    
    cache2.put(3, 2) // evicts key 2
    println("put(3, 2) - evicts key 2")
    cache2.printCache()
    
    println("get(2) = ${cache2.get(2)}") // returns null (not found)
    println("get(3) = ${cache2.get(3)}") // returns 2
    cache2.printCache()
    
    println("\n${"=".repeat(50)}\n")
    
    // Test Case 3: Update existing key
    println("Test Case 3: Update existing key with capacity 3")
    val cache3 = LRUCache<Int, Int>(3)
    
    cache3.put(1, 10)
    cache3.put(2, 20)
    cache3.put(3, 30)
    println("Initial cache:")
    cache3.printCache()
    
    cache3.put(2, 200) // Update existing key
    println("put(2, 200) - update existing key")
    cache3.printCache()
    
    println("get(2) = ${cache3.get(2)}") // returns 200
    cache3.printCache()
    
    cache3.put(4, 40) // evicts key 1 (least recently used)
    println("put(4, 40) - evicts key 1")
    cache3.printCache()
    
    println("\n${"=".repeat(50)}\n")
    
    // Test Case 4: Cache operations
    println("Test Case 4: Cache utility methods")
    val cache4 = LRUCache<Int, Int>(2)
    
    println("Initial size: ${cache4.size()}")
    println("Is empty: ${cache4.isEmpty()}")
    
    cache4.put(1, 100)
    cache4.put(2, 200)
    println("After adding 2 items:")
    println("Size: ${cache4.size()}")
    println("Is empty: ${cache4.isEmpty()}")
    cache4.printCache()
    
    cache4.clear()
    println("After clearing:")
    println("Size: ${cache4.size()}")
    println("Is empty: ${cache4.isEmpty()}")
    cache4.printCache()
    
    println("\n${"=".repeat(50)}\n")
    
    // Test Case 5: Additional utility methods
    println("Test Case 5: Additional utility methods")
    val cache5 = LRUCache<Int, Int>(3)
    
    cache5.put(1, 10)
    cache5.put(2, 20)
    cache5.put(3, 30)
    
    println("Keys in cache: ${cache5.getKeys()}")
    println("Values in cache: ${cache5.getValues()}")
    println("All key-value pairs: ${cache5.getAll()}")
    println("Contains key 2: ${cache5.containsKey(2)}")
    println("Contains key 5: ${cache5.containsKey(5)}")
    
    cache5.printCache()
    
    println("\n${"=".repeat(50)}\n")
    
    // Test Case 6: String keys and values
    println("Test Case 6: String keys and values")
    val stringCache = LRUCache<String, String>(3)
    
    stringCache.put("apple", "red")
    stringCache.put("banana", "yellow")
    stringCache.put("cherry", "red")
    
    println("Initial string cache:")
    stringCache.printCache()
    
    println("get('apple') = ${stringCache.get("apple")}")
    stringCache.printCache()
    
    stringCache.put("date", "brown") // Should evict "banana"
    println("After adding 'date' - should evict 'banana':")
    stringCache.printCache()
    
    println("\n${"=".repeat(50)}\n")
    
    // Test Case 7: Mixed types
    println("Test Case 7: Mixed types - String keys, Int values")
    val mixedCache = LRUCache<String, Int>(2)
    
    mixedCache.put("score1", 100)
    mixedCache.put("score2", 200)
    
    println("Initial mixed cache:")
    mixedCache.printCache()
    
    mixedCache.put("score3", 300) // Should evict "score1"
    println("After adding score3 - should evict score1:")
    mixedCache.printCache()
    
    println("get('score1') = ${mixedCache.get("score1")}") // null
    println("get('score2') = ${mixedCache.get("score2")}") // 200
    println("get('score3') = ${mixedCache.get("score3")}") // 300
    
    println("\n=== Demo completed successfully! ===")
}

/**
 * Additional test function to demonstrate LRU behavior with custom data types
 */
fun testLRUWithCustomTypes() {
    println("\n=== Testing LRU with Custom Data Types ===")
    
    // Test with custom data class
    data class User(val id: Int, val name: String)
    
    val userCache = LRUCache<Int, User>(3)
    
    userCache.put(1, User(1, "Alice"))
    userCache.put(2, User(2, "Bob"))
    userCache.put(3, User(3, "Charlie"))
    
    println("Initial user cache:")
    userCache.printCache()
    
    userCache.get(1) // Access Alice - makes it most recent
    println("After accessing user 1 (Alice):")
    userCache.printCache()
    
    userCache.put(4, User(4, "David")) // Should evict Bob (key 2)
    println("After adding user 4 (David) - should evict Bob:")
    userCache.printCache()
}

/**
 * Performance test function
 */
fun performanceTest() {
    println("\n=== Performance Test ===")
    
    val capacity = 1000
    val cache = LRUCache<Int, Int>(capacity)
    
    val startTime = System.currentTimeMillis()
    
    // Insert 2000 items (should evict 1000)
    repeat(2000) { i ->
        cache.put(i, i * 2)
    }
    
    // Access some items
    repeat(1000) { i ->
        cache.get(i)
    }
    
    val endTime = System.currentTimeMillis()
    
    println("Performance test completed:")
    println("Capacity: $capacity")
    println("Operations: 3000 (2000 puts + 1000 gets)")
    println("Time taken: ${endTime - startTime} ms")
    println("Final cache size: ${cache.size()}")
}
