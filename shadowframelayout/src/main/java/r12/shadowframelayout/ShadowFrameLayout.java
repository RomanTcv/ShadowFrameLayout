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
    private Drawable mTopDrawable;
    private int mTopShadowHeight;
    private Drawable mBottomDrawable;
    private int mBottomShadowHeight;

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
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShadowFrameLayout);
            mTopShadowHeight = typedArray.getDimensionPixelOffset(R.styleable.ShadowFrameLayout_shadowTopHeight, DEFAULT_SHADOW_HEIGHT);
            mBottomShadowHeight = typedArray.getDimensionPixelOffset(R.styleable.ShadowFrameLayout_shadowBottomHeight, DEFAULT_SHADOW_HEIGHT);
            typedArray.recycle();
        }
        mTopDrawable = ContextCompat.getDrawable(context, R.drawable.bg_top_shadow);
        mBottomDrawable = ContextCompat.getDrawable(context, R.drawable.bg_bottom_shadow);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mTopDrawable.setBounds(0, 0, canvas.getWidth(), mTopShadowHeight);
        mTopDrawable.draw(canvas);
        mBottomDrawable.setBounds(0, canvas.getHeight() - mBottomShadowHeight, canvas.getWidth(), canvas.getHeight());
        mBottomDrawable.draw(canvas);
    }
}
