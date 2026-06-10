package com.campsite.commander

/**
 * GearData: Singleton object that holds all camping gear data.
 * Uses parallel arrays to store item details, categories, quantities, and comments.
 */
object GearData {

    // Parallel arrays — each index represents one gear item
    val itemNames: MutableList<String> = mutableListOf(
        "Tent",
        "Marshmallows",
        "Flashlight",
        "First Aid Kit",
        "Sleeping Bag",
        "Water Bottle"
    )

    val categories: MutableList<String> = mutableListOf(
        "Shelter",
        "Food",
        "Safety",
        "First Aid",
        "Shelter",
        "Cooking"
    )

    val quantities: MutableList<Int> = mutableListOf(
        1,
        3,
        2,
        1,
        2,
        4
    )

    val comments: MutableList<String> = mutableListOf(
        "4-person waterproof",
        "For S'mores (Mega size)",
        "Check batteries (AA)",
        "Include bandages and antiseptic",
        "Rated -5°C",
        "1L stainless steel"
    )

    /**
     * Calculates the total number of items packed using a loop.
     * @return total quantity of all items combined
     */
    fun getTotalItemsPacked(): Int {
        var total = 0
        for (qty in quantities) {
            total += qty
        }
        return total
    }

    /**
     * Adds a new gear item to all parallel arrays.
     */
    fun addItem(name: String, category: String, quantity: Int, comment: String) {
        itemNames.add(name)
        categories.add(category)
        quantities.add(quantity)
        comments.add(comment)
    }

    /**
     * Returns the number of unique gear items (rows).
     */
    fun size(): Int = itemNames.size
}
