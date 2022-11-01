package com.example.abdassignment
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        //val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)
        var flag ="aa"
        val spinnerVal : Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("usd","sar","aed","eur")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )


        button.setOnClickListener{ view ->
            var x: Float = edtxt1.text.toString().toFloat();
            if(flag =="usd")
                resultTV.text = usd(x).toString();
            else if (flag=="sar")
                resultTV.text = sar(x).toString();
            else if (flag=="aed")
                resultTV.text = aed(x).toString();
            else if (flag=="eur")
                resultTV.text = eur(x).toString();
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
public fun usd(a: Float): Double {
    return a*1.408
}
public fun sar(a: Float): Double {
    return a*5.32
}
public fun aed(a: Float): Double {
    return a*5.19
}
public fun eur(a: Float): Double {
    return a*1.415
}
