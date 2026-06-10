package com.campsite.commander

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

/**
 * AddGearActivity: Allows users to add new camping gear items.
 * Validates input and provides constructive error feedback.
 */
class AddGearActivity : AppCompatActivity() {

    private lateinit var etItemName: EditText
    private lateinit var spinnerCategory: Spinner
    private lateinit var etQuantity: EditText
    private lateinit var etComments: EditText
    private lateinit var btnSaveGear: Button
    private lateinit var btnBackToBase: Button

    // Available categories for the spinner
    private val categories = arrayOf(
        "Shelter", "Food", "Safety", "First Aid", "Cooking", "Other"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_gear)

        etItemName      = findViewById(R.id.etItemName)
        spinnerCategory = findViewById(R.id.spinnerCategory)
        etQuantity      = findViewById(R.id.etQuantity)
        etComments      = findViewById(R.id.etComments)
        btnSaveGear     = findViewById(R.id.btnSaveGear)
        btnBackToBase   = findViewById(R.id.btnBackToBase)

        // Populate category spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter

        // Save gear with validation
        btnSaveGear.setOnClickListener {
            saveGear()
        }

        // Navigate back to Main Screen
        btnBackToBase.setOnClickListener {
            finish()
        }
    }

    /**
     * Validates all inputs and saves the new gear item to GearData.
     * Provides constructive feedback on errors.
     */
    private fun saveGear() {
        val name     = etItemName.text.toString().trim()
        val category = spinnerCategory.selectedItem.toString()
        val qtyStr   = etQuantity.text.toString().trim()
        val comment  = etComments.text.toString().trim()

        // --- Input Validation ---
        if (name.isEmpty()) {
            etItemName.error = "Please enter an item name."
            etItemName.requestFocus()
            return
        }

        if (qtyStr.isEmpty()) {
            etQuantity.error = "Please enter a quantity."
            etQuantity.requestFocus()
            return
        }

        val quantity = qtyStr.toIntOrNull()
        if (quantity == null || quantity <= 0) {
            etQuantity.error = "Quantity must be a positive number (e.g., 1, 2, 3)."
            etQuantity.requestFocus()
            return
        }

        // --- All valid: add to data store ---
        GearData.addItem(name, category, quantity, comment)

        Toast.makeText(this, "\"$name\" added to your pack!", Toast.LENGTH_SHORT).show()

        // Clear fields for next entry
        etItemName.text.clear()
        etQuantity.text.clear()
        etComments.text.clear()
        spinnerCategory.setSelection(0)
    }
}
