/**
 * Generic LRU (Least Recently Used) Cache Implementation in Kotlin
 * 
 * This implementation uses a combination of HashMap and Doubly Linked List
 * to achieve O(1) time complexity for both get and put operations.
 * 
 * @param K The type of keys stored in the cache
 * @param V The type of values stored in the cache
 * 
 * Time Complexity: O(1) for both get and put operations
 * Space Complexity: O(capacity)
 */
class LRUCache<K, V>(private val capacity: Int) {
    
    // Node class for doubly linked list
    private data class Node<K, V>(
        val key: K,
        var value: V,
        var prev: Node<K, V>? = null,
        var next: Node<K, V>? = null
    )
    
    private val cache = mutableMapOf<K, Node<K, V>>()
    private val head = Node<K, V>(null as K, null as V) // Dummy head node
    private val tail = Node<K, V>(null as K, null as V) // Dummy tail node
    
    init {
        // Initialize dummy head and tail nodes
        head.next = tail
        tail.prev = head
    }
    
    /**
     * Get the value of the key if it exists in the cache
     * @param key The key to look up
     * @return The value associated with the key, or null if not found
     */
    fun get(key: K): V? {
        val node = cache[key] ?: return null
        
        // Move the accessed node to the head (most recently used)
        moveToHead(node)
        return node.value
    }
    
    /**
     * Put a key-value pair into the cache
     * @param key The key to store
     * @param value The value to store
     */
    fun put(key: K, value: V) {
        val existingNode = cache[key]
        
        if (existingNode != null) {
            // Key exists, update the value and move to head
            existingNode.value = value
            moveToHead(existingNode)
        } else {
            // Key doesn't exist, create new node
            val newNode = Node(key, value)
            
            if (cache.size >= capacity) {
                // Cache is full, remove the least recently used item (tail)
                val tailNode = removeTail()
                cache.remove(tailNode.key)
            }
            
            // Add new node to cache and move to head
            cache[key] = newNode
            addToHead(newNode)
        }
    }
    
    /**
     * Add a node right after the head
     * @param node The node to add
     */
    private fun addToHead(node: Node<K, V>) {
        node.prev = head
        node.next = head.next
        head.next?.prev = node
        head.next = node
    }
    
    /**
     * Remove an existing node from the linked list
     * @param node The node to remove
     */
    private fun removeNode(node: Node<K, V>) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }
    
    /**
     * Move a node to the head (most recently used position)
     * @param node The node to move
     */
    private fun moveToHead(node: Node<K, V>) {
        removeNode(node)
        addToHead(node)
    }
    
    /**
     * Remove the tail node (least recently used)
     * @return The removed tail node
     */
    private fun removeTail(): Node<K, V> {
        val lastNode = tail.prev!!
        removeNode(lastNode)
        return lastNode
    }
    
    /**
     * Get the current size of the cache
     * @return Number of items currently in the cache
     */
    fun size(): Int = cache.size
    
    /**
     * Check if the cache is empty
     * @return true if cache is empty, false otherwise
     */
    fun isEmpty(): Boolean = cache.isEmpty()
    
    /**
     * Clear all items from the cache
     */
    fun clear() {
        cache.clear()
        head.next = tail
        tail.prev = head
    }
    
    /**
     * Print the current state of the cache (for debugging)
     */
    fun printCache() {
        print("Cache contents (most recent first): ")
        var current = head.next
        while (current != tail) {
            print("(${current!!.key},${current.value}) ")
            current = current.next
        }
        println()
    }
    
    /**
     * Get all keys in the cache (for testing purposes)
     * @return List of keys in order from most recent to least recent
     */
    fun getKeys(): List<K> {
        val keys = mutableListOf<K>()
        var current = head.next
        while (current != tail) {
            keys.add(current!!.key)
            current = current.next
        }
        return keys
    }
    
    /**
     * Get all values in the cache (for testing purposes)
     * @return List of values in order from most recent to least recent
     */
    fun getValues(): List<V> {
        val values = mutableListOf<V>()
        var current = head.next
        while (current != tail) {
            values.add(current!!.value)
            current = current.next
        }
        return values
    }
    
    /**
     * Check if a key exists in the cache
     * @param key The key to check
     * @return true if key exists, false otherwise
     */
    fun containsKey(key: K): Boolean = cache.containsKey(key)
    
    /**
     * Get all key-value pairs in the cache
     * @return Map of key-value pairs
     */
    fun getAll(): Map<K, V> {
        return cache.mapValues { it.value.value }
    }
}
