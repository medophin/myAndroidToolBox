package com.onemanworkshop.com.addview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    val container: ConstraintLayout by lazy {
        this.findViewById(R.id.mycontainer) as ConstraintLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container.addView(CustomView(context = this))


    }
}
