package r12.shadowframelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by R12 on 17.06.2017.
 */

public class ShadowFrameLayout extends FrameLayout {

    private static final int DEFAULT_SHADOW_HEIGHT = 0;

    private Drawable mShadowTopDrawable;
    private int mShadowTopHeight;

    private Drawable mShadowBottomDrawable;
    private int mShadowBottomHeight;

    private Drawable mShadowLeftDrawable;
    private int mShadowLeftHeight;

    private Drawable mShadowRightDrawable;
    private int mShadowRightHeight;


    public ShadowFrameLayout(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public ShadowFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ShadowFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ShadowFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.ShadowFrameLayout);
            mShadowTopHeight = styledAttrs.getDimensionPixelSize(R.styleable.ShadowFrameLayout_shadowTopHeight, DEFAULT_SHADOW_HEIGHT);
            mShadowBottomHeight = styledAttrs.getDimensionPixelSize(R.styleable.ShadowFrameLayout_shadowBottomHeight, DEFAULT_SHADOW_HEIGHT);
            mShadowLeftHeight = styledAttrs.getDimensionPixelSize(R.styleable.ShadowFrameLayout_shadowLeftHeight, DEFAULT_SHADOW_HEIGHT);
            mShadowRightHeight = styledAttrs.getDimensionPixelSize(R.styleable.ShadowFrameLayout_shadowRightHeight, DEFAULT_SHADOW_HEIGHT);
            styledAttrs.recycle();
        }

        mShadowTopDrawable = ContextCompat.getDrawable(getContext(), R.drawable.bg_top_shadow);
        mShadowBottomDrawable = ContextCompat.getDrawable(getContext(), R.drawable.bg_bottom_shadow);
        mShadowLeftDrawable = ContextCompat.getDrawable(getContext(), R.drawable.bg_left_shadow);
        mShadowRightDrawable = ContextCompat.getDrawable(getContext(), R.drawable.bg_right_shadow);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        drawShadow(canvas);
    }

    private void drawShadow(Canvas canvas) {
        mShadowTopDrawable.setBounds(0, 0, canvas.getWidth(), mShadowTopHeight);
        mShadowTopDrawable.draw(canvas);
        mShadowBottomDrawable.setBounds(0, canvas.getHeight() - mShadowBottomHeight, canvas.getWidth(), canvas.getHeight());
        mShadowBottomDrawable.draw(canvas);
        mShadowLeftDrawable.setBounds(0, 0, mShadowLeftHeight, canvas.getHeight());
        mShadowLeftDrawable.draw(canvas);
        mShadowRightDrawable.setBounds(canvas.getWidth() - mShadowRightHeight, 0, canvas.getWidth(), canvas.getHeight());
        mShadowRightDrawable.draw(canvas);
    }

    public void setShadowsHeight(int left, int top, int right, int bottom) {
        mShadowLeftHeight = left;
        mShadowTopHeight = top;
        mShadowRightHeight = right;
        mShadowBottomHeight = bottom;
        invalidate();
    }

}
