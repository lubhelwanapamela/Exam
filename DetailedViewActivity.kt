package com.campsite.commander

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

/**
 * DetailedViewActivity: Displays the full list of gear with
 * Item, Category, Quantity, and Comments for each entry.
 * Uses a loop to build the list dynamically from parallel arrays.
 */
class DetailedViewActivity : AppCompatActivity() {

    private lateinit var containerGearList: LinearLayout
    private lateinit var btnBackToBase: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        containerGearList = findViewById(R.id.containerGearList)
        btnBackToBase     = findViewById(R.id.btnBackToBase)

        // "Back to Base" navigates back to Main Screen
        btnBackToBase.setOnClickListener {
            finish()
        }

        loadGearList()
    }

    /**
     * Loops through all parallel arrays and dynamically builds
     * a card-style TextView for each gear item.
     */
    private fun loadGearList() {
        containerGearList.removeAllViews()

        if (GearData.size() == 0) {
            val emptyMsg = TextView(this).apply {
                text = "No gear packed yet. Head back and add some!"
                setTextColor(ContextCompat.getColor(context, R.color.forest_green))
                textSize = 16f
                setPadding(16, 16, 16, 16)
            }
            containerGearList.addView(emptyMsg)
            return
        }

        // Loop through parallel arrays to build UI rows
        for (i in 0 until GearData.size()) {
            val card = TextView(this).apply {
                text = """
                    🏕 ${GearData.itemNames[i]}
                    📂 Category : ${GearData.categories[i]}
                    🔢 Quantity : ${GearData.quantities[i]}
                    📝 Notes    : ${if (GearData.comments[i].isNotEmpty()) GearData.comments[i] else "—"}
                """.trimIndent()

                textSize = 14f
                setTextColor(ContextCompat.getColor(context, R.color.cream_white))
                setBackgroundColor(ContextCompat.getColor(context, R.color.dark_card))
                setPadding(28, 24, 28, 24)

                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(0, 0, 0, 20)
                layoutParams = params
            }
            containerGearList.addView(card)
        }
    }
}
