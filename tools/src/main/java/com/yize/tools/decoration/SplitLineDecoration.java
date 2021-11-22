package com.yize.tools.decoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @Desc: 通用列表分隔线（仅限LinearLayoutManager布局管理器使用）
 * @Date: 2021年11月18日
 * @Time: 13:34
 * @Author: 李易泽
 */
public class SplitLineDecoration extends RecyclerView.ItemDecoration {
    /**
     * 间隔（默认1像素）
     */
    private int mSpace = 1;
    private Rect mRect;
    private Paint mPaint;
    private int mOrientation;

    public SplitLineDecoration(@RecyclerView.Orientation int orientation) {
        this(orientation, 1);
    }

    public SplitLineDecoration(@RecyclerView.Orientation int orientation, int space) {
        this(orientation, Color.GRAY, space);
    }

    public SplitLineDecoration(@RecyclerView.Orientation int orientation, @ColorInt int color, int space) {
        mOrientation = orientation;
        mRect = new Rect(0, 0, 0, 0);
        mPaint = new Paint();
        if (space > 0) {
            mSpace = space;
        }
        mPaint.setColor(color);
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOrientation == LinearLayoutManager.VERTICAL) {
            drawVerticalSplitLine(c, parent);
        } else {
            drawHorizontalSplitLine(c, parent);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (mOrientation == LinearLayoutManager.VERTICAL) {
            outRect.set(0, 0, 0, mSpace);
        } else {
            outRect.set(0, 0, mSpace, 0);
        }
    }

    /**
     * 绘制竖向分割线
     *
     * @param c      Canvas对象
     * @param parent RecyclerView对象
     */
    private void drawVerticalSplitLine(@NonNull Canvas c, @NonNull RecyclerView parent) {
        int left, right;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            left = parent.getPaddingStart();
            right = parent.getWidth() - parent.getPaddingEnd();
        } else {
            left = parent.getPaddingLeft();
            right = parent.getWidth() - parent.getPaddingRight();
        }
        int childCount = (parent.getChildCount() - 1);
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            mRect.set(left, top, right, (top + mSpace));
            c.drawRect(mRect, mPaint);
        }
    }

    /**
     * 绘制横向分割线
     *
     * @param c      Canvas对象
     * @param parent RecyclerView对象
     */
    private void drawHorizontalSplitLine(@NonNull Canvas c, @NonNull RecyclerView parent) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        int childCount = (parent.getChildCount() - 1);
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                int left = child.getRight() + params.getMarginEnd();
                mRect.set(left, top, (left + mSpace), bottom);
            } else {
                int left = child.getRight() + params.rightMargin;
                mRect.set(left, top, (left + mSpace), bottom);
            }
            c.drawRect(mRect, mPaint);
        }
    }
}
