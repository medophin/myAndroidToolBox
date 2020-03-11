package com.onemanworkshop.com.addview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout

internal class CustomView(context: Context?) :
    ConstraintLayout(context) {

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view,this,true)
    }

}