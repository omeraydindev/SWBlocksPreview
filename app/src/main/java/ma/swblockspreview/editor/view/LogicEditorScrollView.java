package ma.swblockspreview.editor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

public class LogicEditorScrollView extends FrameLayout {
    public float a = 0.0F;
    public float b = 0.0F;
    public int c = 0;
    public boolean d = false;
    public boolean e = true;
    public boolean f = true;
    public float g = -1.0F;
    public float h = -1.0F;

    public LogicEditorScrollView(Context var1) {
        super(var1);
        a(var1);
    }

    public LogicEditorScrollView(Context var1, AttributeSet var2) {
        super(var1, var2);
        a(var1);
    }

    public final void a(Context var1) {
        c = ViewConfiguration.get(var1).getScaledTouchSlop();
    }

    public boolean a() {
        if (getChildCount() <= 0) {
            return false;
        } else {
            boolean var1 = f;
            boolean var2 = false;
            if (var1) {
                if (!e) {
                    return false;
                }

                View var3 = getChildAt(0);
                int var4 = var3.getWidth();
                int var5 = var3.getHeight();
                if (getWidth() >= var4 + getPaddingLeft() + getPaddingRight()) {
                    int var6 = getHeight();
                    int var7 = var5 + getPaddingTop() + getPaddingBottom();
                    var2 = false;
                    if (var6 >= var7) {
                        return var2;
                    }
                }

                var2 = true;
            }

            return var2;
        }
    }

    @Override
    public void addView(View var1) {
        if (getChildCount() <= 1) {
            super.addView(var1);
        } else {
            throw new IllegalStateException("BothDirectionScrollView should have child View only one");
        }
    }

    public boolean getScrollEnabled() {
        return e;
    }

    public boolean getUseScroll() {
        return f;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent var1) {
        if (!a()) {
            return false;
        } else {
            int var2 = var1.getAction();
            if (var2 == 2 && d) {
                return true;
            } else {
                float var3 = var1.getX();
                float var4 = var1.getY();
                if (var2 != 0) {
                    if (var2 != 1) {
                        if (var2 == 2) {
                            int var5 = (int) Math.abs(a - var3);
                            int var6 = (int) Math.abs(b - var4);
                            int var7 = c;
                            if (var5 > var7 || var6 > var7) {
                                d = true;
                            }
                        }
                    } else {
                        d = false;
                    }
                } else {
                    a = var3;
                    b = var4;
                    d = false;
                }

                return d;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!a()) {
            return false;
        } else {
            View var2 = getChildAt(0);
            int var3 = motionEvent.getAction();
            float var4 = motionEvent.getX();
            float var5 = motionEvent.getY();
            if (var3 != 0) {
                if (var3 == 1) {
                    g = -1.0F;
                    h = -1.0F;
                    return true;
                }

                if (var3 != 2) {
                    return true;
                }

                if (g < 0.0F) {
                    g = var4;
                }

                if (h < 0.0F) {
                    h = var5;
                }

                int var6 = (int) (g - var4);
                int var7 = (int) (h - var5);
                g = var4;
                h = var5;
                int var9;
                if (var6 <= 0) {
                    if (getScrollX() <= 0) {
                        var6 = 0;
                    }

                    var9 = Math.max(-getScrollX(), var6);
                } else {
                    int var8 = var2.getRight() - getScrollX() - getWidth() - getPaddingRight();
                    if (var8 > 0) {
                        var9 = Math.min(var8, var6);
                    } else {
                        var9 = 0;
                    }
                }

                int var11;
                if (var7 <= 0) {
                    if (getScrollY() <= 0) {
                        var7 = 0;
                    }

                    var11 = Math.max(-getScrollY(), var7);
                } else {
                    int var10 = var2.getBottom() - getScrollY() - getHeight() - getPaddingBottom();
                    var11 = 0;
                    if (var10 > 0) {
                        var11 = Math.min(var10, var7);
                    }
                }

                if (var9 != 0 || var11 != 0) {
                    scrollBy(var9, var11);
                    return true;
                }
            } else {
                g = var4;
                h = var5;
            }

            return true;
        }
    }

    public void setScrollEnabled(boolean var1) {
        e = var1;
    }

    public void setUseScroll(boolean var1) {
        f = var1;
    }
}
