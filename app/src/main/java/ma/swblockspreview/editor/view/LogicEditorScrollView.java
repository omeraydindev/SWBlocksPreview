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
        this.a(var1);
    }

    public LogicEditorScrollView(Context var1, AttributeSet var2) {
        super(var1, var2);
        this.a(var1);
    }

    public final void a(Context var1) {
        this.c = ViewConfiguration.get(var1).getScaledTouchSlop();
    }

    public boolean a() {
        if (this.getChildCount() <= 0) {
            return false;
        } else {
            boolean var1 = this.f;
            boolean var2 = false;
            if (var1) {
                if (!this.e) {
                    return false;
                }

                View var3 = this.getChildAt(0);
                int var4 = var3.getWidth();
                int var5 = var3.getHeight();
                if (this.getWidth() >= var4 + this.getPaddingLeft() + this.getPaddingRight()) {
                    int var6 = this.getHeight();
                    int var7 = var5 + this.getPaddingTop() + this.getPaddingBottom();
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

    public void addView(View var1) {
        if (this.getChildCount() <= 1) {
            super.addView(var1);
        } else {
            throw new IllegalStateException("BothDirectionScrollView should have child View only one");
        }
    }

    public boolean getScrollEnabled() {
        return this.e;
    }

    public boolean getUseScroll() {
        return this.f;
    }

    public boolean onInterceptTouchEvent(MotionEvent var1) {
        if (!this.a()) {
            return false;
        } else {
            int var2 = var1.getAction();
            if (var2 == 2 && this.d) {
                return true;
            } else {
                float var3 = var1.getX();
                float var4 = var1.getY();
                if (var2 != 0) {
                    if (var2 != 1) {
                        if (var2 == 2) {
                            int var5 = (int) Math.abs(this.a - var3);
                            int var6 = (int) Math.abs(this.b - var4);
                            int var7 = this.c;
                            if (var5 > var7 || var6 > var7) {
                                this.d = true;
                            }
                        }
                    } else {
                        this.d = false;
                    }
                } else {
                    this.a = var3;
                    this.b = var4;
                    this.d = false;
                }

                return this.d;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent var1) {
        if (!this.a()) {
            return false;
        } else {
            View var2 = this.getChildAt(0);
            int var3 = var1.getAction();
            float var4 = var1.getX();
            float var5 = var1.getY();
            if (var3 != 0) {
                if (var3 == 1) {
                    this.g = -1.0F;
                    this.h = -1.0F;
                    return true;
                }

                if (var3 != 2) {
                    return true;
                }

                if (this.g < 0.0F) {
                    this.g = var4;
                }

                if (this.h < 0.0F) {
                    this.h = var5;
                }

                int var6 = (int) (this.g - var4);
                int var7 = (int) (this.h - var5);
                this.g = var4;
                this.h = var5;
                int var9;
                if (var6 <= 0) {
                    if (this.getScrollX() <= 0) {
                        var6 = 0;
                    }

                    var9 = Math.max(0 - this.getScrollX(), var6);
                } else {
                    int var8 = var2.getRight() - this.getScrollX() - this.getWidth() - this.getPaddingRight();
                    if (var8 > 0) {
                        var9 = Math.min(var8, var6);
                    } else {
                        var9 = 0;
                    }
                }

                int var11;
                if (var7 <= 0) {
                    if (this.getScrollY() <= 0) {
                        var7 = 0;
                    }

                    var11 = Math.max(0 - this.getScrollY(), var7);
                } else {
                    int var10 = var2.getBottom() - this.getScrollY() - this.getHeight() - this.getPaddingBottom();
                    var11 = 0;
                    if (var10 > 0) {
                        var11 = Math.min(var10, var7);
                    }
                }

                if (var9 != 0 || var11 != 0) {
                    this.scrollBy(var9, var11);
                    return true;
                }
            } else {
                this.g = var4;
                this.h = var5;
            }

            return true;
        }
    }

    public void setScrollEnabled(boolean var1) {
        this.e = var1;
    }

    public void setUseScroll(boolean var1) {
        this.f = var1;
    }
}
