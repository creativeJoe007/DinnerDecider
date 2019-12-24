package com.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var lastSelected : String = ""
    var listOfAvaliableFood = arrayListOf("Burger King", "Chicken", "Shawarma", "Chips", "Chinese", "Prawns")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // randomly generate an initial meal
        selectedFoodText.text = decideFood()

        decideBtn.setOnClickListener {
            selectedFoodText.text = decideFood()
        }
        addFoodBtn.setOnClickListener {
            if(addFoodTxt.text.toString() !== null) {
                listOfAvaliableFood.add(addFoodTxt.text.toString())
                addFoodTxt.text.clear()
            }
        }
    }
    fun decideFood(): String {
        val randomlyGenerated: Int = Random.nextInt(0, listOfAvaliableFood.count())
        val temp = listOfAvaliableFood[randomlyGenerated]
        if (!lastSelected.equals(temp)){
            lastSelected = temp
            return temp
        }
        return decideFood()
    }
}
