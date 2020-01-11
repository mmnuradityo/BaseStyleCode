package com.example.basestyle.widget

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.PointerIcon
import android.widget.RemoteViews.RemoteView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.basestyle.R

@RemoteView
open class ButtonRounded : TextView {

    companion object {
        private val DEFAULT_STYLE = R.style.BaseStyleTheme_CustomButton
        private val ATTR_STYLE = R.attr.buttonRoundedStyle
    }

    private var layoutWidth: Int = 0
    private var layoutHeight: Int = 0

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, ATTR_STYLE)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr,
        DEFAULT_STYLE
    ) {
        init(context, attrs, defStyleAttr)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context, attrs, defStyleAttr)
    }


    private fun init(context: Context, attrs: AttributeSet?, defStyle: Int) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.ButtonRounded, defStyle, 0)

        val colorBackground = a.getColor(
            R.styleable.ButtonRounded_backgroundColor,
            ContextCompat.getColor(context, R.color.colorAccent)
        )

        val widthStroke = a.getInt(
            R.styleable.ButtonRounded_strokeSize,
            0
        )
        val colorStroke = a.getColor(
            R.styleable.ButtonRounded_strokeColor,
            ContextCompat.getColor(context, R.color.colorAccent)
        )

        backgroundColor(widthStroke, colorStroke, colorBackground)
        a.recycle()
    }

    @SuppressLint("ResourceAsColor")
    private fun backgroundColor(widthStroke: Int, colorStroke: Int, colorBackground: Int) {
        val gradientDrawable = GradientDrawable()
        gradientDrawable.setColor(colorBackground)
        gradientDrawable.shape = GradientDrawable.RECTANGLE
        gradientDrawable.cornerRadius = 60F
        gradientDrawable.setSize(widthSize(), heightSize())
        gradientDrawable.setStroke(widthStroke, colorStroke)
        gradientDrawable.setStroke(widthStroke, colorStroke)
        val drawable = RippleDrawable(
            ColorStateList.valueOf(R.color.baseStyle_blackTransparent).withAlpha(60),
            gradientDrawable, null
        )
        background = drawable

    }

    private fun heightSize(): Int {
        val minHeight = TypedValue
            .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40F, resources.displayMetrics)
        return if (layoutHeight > minHeight.toInt()) {
            layoutHeight
        } else {
            minHeight.toInt()
        }
    }

    private fun widthSize(): Int {
        val minWidth = TypedValue
            .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20F, resources.displayMetrics)
        return if (layoutWidth > minWidth.toInt()) {
            layoutWidth
        } else {
            minWidth.toInt()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        layoutWidth = MeasureSpec.getSize(widthMeasureSpec)
        layoutHeight = MeasureSpec.getSize(heightMeasureSpec)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun getAccessibilityClassName(): CharSequence {
        return ButtonRounded::class.java.name
    }

    @SuppressLint("NewApi")
    override fun onResolvePointerIcon(event: MotionEvent, pointerIndex: Int): PointerIcon {
        return if (pointerIcon == null && isClickable && isEnabled) {
            PointerIcon.getSystemIcon(context, PointerIcon.TYPE_HAND)
        } else super.onResolvePointerIcon(event, pointerIndex)
    }

}
