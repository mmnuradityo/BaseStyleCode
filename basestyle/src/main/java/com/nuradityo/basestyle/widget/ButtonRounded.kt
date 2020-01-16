package com.nuradityo.basestyle.widget

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.PointerIcon
import android.widget.RemoteViews.RemoteView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.nuradityo.basestyle.R


@RemoteView
class ButtonRounded : AppCompatTextView {

    private var layoutWidth: Int = 0
    private var layoutHeight: Int = 0

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(
        context,
        attrs,
        android.R.attr.buttonStyle
    )

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs, defStyleAttr)
    }


    @SuppressLint("ResourceType")
    private fun init(context: Context, attrs: AttributeSet?, defStyle: Int) {

        val a = context.obtainStyledAttributes(attrs, R.styleable.ButtonRounded, defStyle, 0)

        setTextColor(a.getColor(R.styleable.ButtonRounded_textColor, Color.WHITE))

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
