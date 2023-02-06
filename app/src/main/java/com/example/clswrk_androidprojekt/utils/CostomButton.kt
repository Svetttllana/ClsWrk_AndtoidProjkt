package com.example.clswrk_androidprojekt.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.Button
import java.text.AttributedCharacterIterator.Attribute


class CostomButton @JvmOverloads constructor(
    context:Context,attribute:AttributeSet?=null,style:Int=0
): androidx.appcompat.widget.AppCompatButton(context,attribute,style) {

val painter = Paint().apply {
    color = Color.BLUE
    isAntiAlias = true
}

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRect(Rect(0,0,width,height),painter)
    }
}


































