package org.hyperskill.calculator.tip

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val slider = findViewById<Slider>(R.id.slider)
        val editText = findViewById<EditText>(R.id.edit_text)
        val textView = findViewById<TextView>(R.id.text_view)

        slider.addOnChangeListener { _, value, _ ->
            if (editText.text.isNotBlank()) {
                textView.text = tipCalculation(editText.text.toString().toBigDecimal(), value.toBigDecimal())
            }
        }

        editText.addTextChangedListener { text ->
            if (text != null) {
                if (text.isNotBlank()) {
                    textView.text = tipCalculation(text.toString().toBigDecimal(), slider.value.toBigDecimal())
                }else{
                    textView.text = ""
                }
            }
        }
    }
}