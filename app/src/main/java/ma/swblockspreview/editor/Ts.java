package ma.swblockspreview.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.RelativeLayout;

import ma.swblockspreview.util.Gx;
import ma.swblockspreview.util.mq;
import ma.swblockspreview.util.wB;

public class Ts extends RelativeLayout {
    public int A;
    public int B;
    public int C;
    public float D;
    public Rs E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public Paint M;
    public Paint N;
    public Paint O;
    public int P;
    public int Q;
    public int R;
    public Gx S;
    public Context a;
    public String b;
    public String c;
    public int d;
    public int e;
    public Paint f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public Ts(Context var1, String var2, String var3, boolean var4) {
        super(var1);
        h = 3;
        i = 12;
        j = 15;
        k = 3;
        l = 2;
        m = 15;
        n = 15;
        o = 15;
        int var5 = o;
        int var6 = h;
        p = var5 + var6;
        q = 10 + p;
        r = var6 + q;
        s = 6;
        t = 60;
        u = 2;
        v = 2;
        w = 3;
        x = 0;
        y = 2;
        int var7 = i;
        B = var7;
        C = var7;
        E = null;
        F = 100;
        G = 14;
        H = 15;
        I = 6;
        J = 4;
        K = false;
        L = false;
        P = 1;
        Q = 1;
        R = 805306368;
        S = null;
        a = var1;
        b = var2;
        if (var3 != null && var3.indexOf(".") > 0) {
            c = var3.substring(0, var3.indexOf("."));
        } else {
            c = var3;
        }

        byte var10;
        label86:
        {
            a();
            String var8 = b;
            int var9 = var8.hashCode();
            if (var9 != 32) {
                if (var9 != 104) {
                    if (var9 != 112) {
                        if (var9 != 115) {
                            if (var9 != 118) {
                                switch (var9) {
                                    case 97:
                                        if (var8.equals("a")) {
                                            var10 = 13;
                                            break label86;
                                        }
                                        break;
                                    case 98:
                                        if (var8.equals("b")) {
                                            var10 = 1;
                                            break label86;
                                        }
                                        break;
                                    case 99:
                                        if (var8.equals("c")) {
                                            var10 = 4;
                                            break label86;
                                        }
                                        break;
                                    case 100:
                                        if (var8.equals("d")) {
                                            var10 = 2;
                                            break label86;
                                        }
                                        break;
                                    case 101:
                                        if (var8.equals("e")) {
                                            var10 = 5;
                                            break label86;
                                        }
                                        break;
                                    case 102:
                                        if (var8.equals("f")) {
                                            var10 = 6;
                                            break label86;
                                        }
                                        break;
                                    default:
                                        switch (var9) {
                                            case 108:
                                                if (var8.equals("l")) {
                                                    var10 = 12;
                                                    break label86;
                                                }
                                                break;
                                            case 109:
                                                if (var8.equals("m")) {
                                                    var10 = 8;
                                                    break label86;
                                                }
                                                break;
                                            case 110:
                                                if (var8.equals("n")) {
                                                    var10 = 3;
                                                    break label86;
                                                }
                                        }
                                }
                            } else if (var8.equals("v")) {
                                var10 = 10;
                                break label86;
                            }
                        } else if (var8.equals("s")) {
                            var10 = 9;
                            break label86;
                        }
                    } else if (var8.equals("p")) {
                        var10 = 11;
                        break label86;
                    }
                } else if (var8.equals("h")) {
                    var10 = 7;
                    break label86;
                }
            } else if (var8.equals(" ")) {
                var10 = 0;
                break label86;
            }

            var10 = -1;
        }

        switch (var10) {
            case 0:
                u = 4;
                d = 4;
                break;
            case 1:
                w = 8;
                x = 5;
                d = 2;
                break;
            case 2:
                d = 3;
                w = 4;
                break;
            case 3:
                d = 3;
                break;
            case 4:
                u = 4;
                d = 10;
                break;
            case 5:
                u = 4;
                d = 12;
                break;
            case 6:
                u = 4;
                d = 5;
                break;
            case 7:
                u = 8;
                d = 7;
                break;
            case 8:
                d = 9;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                d = 1;
        }

        e = R;
        g = var4;
        setWillNotDraw(false);
        a(var1);
    }

    public Ts(Context var1, String var2, boolean var3) {
        this(var1, var2, "", var3);
    }

    private float[] getBooleanReflections() {
        float[] var1 = new float[8];
        int var2 = A / 2;
        int var3 = P;
        var1[0] = (float) (0 + var3 / 2);
        float var4 = (float) var2;
        var1[1] = var4;
        var1[2] = var4;
        var1[3] = (float) (0 + var3 / 2);
        var1[4] = var4;
        var1[5] = (float) (0 + var3 / 2);
        var1[6] = (float) (z - var2);
        var1[7] = (float) (0 + var3 / 2);
        return var1;
    }

    private float[] getBooleanShadows() {
        float[] var1 = new float[8];
        int var2 = A;
        int var3 = var2 / 2;
        int var4 = z;
        int var5 = P;
        var1[0] = (float) (var4 - var5 / 2);
        float var6 = (float) var3;
        var1[1] = var6;
        var1[2] = (float) (var4 - var3);
        var1[3] = (float) (var2 - var5 / 2);
        var1[4] = (float) (var4 - var3);
        var1[5] = (float) (var2 - var5 / 2);
        var1[6] = var6;
        var1[7] = (float) (var2 - var5 / 2);
        return var1;
    }

    private float[] getNumberBottomShadows() {
        float[] var1 = new float[4];
        int var2 = A;
        int var3 = var2 / 2;
        var1[0] = (float) (z - var3);
        int var4 = P;
        var1[1] = (float) (var2 - var4 / 2);
        var1[2] = (float) var3;
        var1[3] = (float) (var2 - var4 / 2);
        return var1;
    }

    private float[] getNumberTopReflections() {
        float[] var1 = new float[4];
        int var2 = A / 2;
        var1[0] = (float) var2;
        int var3 = P;
        var1[1] = (float) (0 + var3 / 2);
        var1[2] = (float) (z - var2);
        var1[3] = (float) (0 + var3 / 2);
        return var1;
    }

    private float[] getRectReflections() {
        float[] var1 = new float[8];
        var1[0] = 0.0F;
        int var2 = P;
        var1[1] = (float) (0 + var2 / 2);
        var1[2] = (float) (z - var2 / 2);
        var1[3] = (float) (0 + var2 / 2);
        var1[4] = (float) (0 + var2 / 2);
        var1[5] = 0.0F;
        var1[6] = (float) (0 + var2 / 2);
        var1[7] = (float) (A - var2 / 2);
        return var1;
    }

    private float[] getRectShadows() {
        float[] var1 = new float[8];
        int var2 = z;
        int var3 = P;
        var1[0] = (float) (var2 - var3 / 2);
        var1[1] = 0.0F;
        var1[2] = (float) (var2 - var3 / 2);
        int var4 = A;
        var1[3] = (float) (var4 - var3 / 2);
        var1[4] = (float) (var2 - var3 / 2);
        var1[5] = (float) (var4 - var3 / 2);
        var1[6] = 0.0F;
        var1[7] = (float) (var4 - var3 / 2);
        return var1;
    }

    public void a() {
        S = mq.a(b, c);
    }

    public void a(float var1, float var2, boolean var3) {
        if (d == 9) {
            z = (int) var1 + H;
        } else {
            z = (int) var1;
        }

        A = (int) var2;
        if (var3) {
            e();
        }

    }

    public void a(Ts var1, boolean var2, boolean var3, int var4) {
        e = -16777216;
        d = var1.d;
        z = var1.z;
        A = var1.A;
        B = var1.B;
        C = var1.C;
        if (!var2) {
            if (var3) {
                d = 4;
                A = (int) (6.0F * D);
            } else if (var4 > 0) {
                B = var4 - h;
            }
        }

        e();
    }

    public final void a(Context var1) {
        D = wB.a(var1, 1.0F);
        float var2 = (float) h;
        float var3 = D;
        h = (int) (var2 * var3);
        i = (int) (var3 * (float) i);
        j = (int) (var3 * (float) j);
        m = (int) (var3 * (float) m);
        n = (int) (var3 * (float) n);
        k = (int) (var3 * (float) k);
        l = (int) (var3 * (float) l);
        o = (int) (var3 * (float) o);
        p = (int) (var3 * (float) p);
        q = (int) (var3 * (float) q);
        r = (int) (var3 * (float) r);
        s = (int) (var3 * (float) s);
        t = (int) (var3 * (float) t);
        B = (int) (var3 * (float) B);
        C = (int) (var3 * (float) C);
        w = (int) (var3 * (float) w);
        u = (int) (var3 * (float) u);
        x = (int) (var3 * (float) x);
        v = (int) (var3 * (float) v);
        y = (int) (var3 * (float) y);
        F = (int) (var3 * (float) F);
        G = (int) (var3 * (float) G);
        I = (int) (var3 * (float) I);
        J = (int) (var3 * (float) J);
        H = (int) (var3 * (float) H);
        P = (int) (var3 * (float) P);
        Q = (int) (var3 * (float) Q);
        if (P < 2) {
            P = 2;
        }

        if (Q < 2) {
            Q = 2;
        }

        f = new Paint();
        if (!g) {
            K = true;
            L = true;
        }

        M = new Paint();
        M.setColor(-536870912);
        M.setStrokeWidth((float) P);
        N = new Paint();
        N.setColor(-1610612736);
        N.setStyle(Paint.Style.STROKE);
        N.setStrokeWidth((float) P);
        O = new Paint();
        O.setColor(-1593835521);
        O.setStyle(Paint.Style.STROKE);
        O.setStrokeWidth((float) Q);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        a((float) F, (float) (G + u + v), false);
    }

    public final void a(Canvas var1) {
        Path var2 = new Path();
        int var3 = A;
        int var4 = var3 / 2;
        float var5 = (float) var4;
        var2.moveTo(var5, (float) var3);
        var2.lineTo(0.0F, var5);
        var2.lineTo(var5, 0.0F);
        var2.lineTo((float) (z - var4), 0.0F);
        var2.lineTo((float) z, var5);
        var2.lineTo((float) (z - var4), (float) A);
        var1.drawPath(var2, f);
        if (K) {
            var1.drawLines(getBooleanShadows(), N);
        }

        if (L) {
            var1.drawLines(getBooleanReflections(), O);
        }

    }

    public final void a(Path var1) {
        var1.moveTo(0.0F, (float) k);
        var1.lineTo((float) k, 0.0F);
        var1.lineTo((float) o, 0.0F);
        var1.lineTo((float) p, (float) h);
        var1.lineTo((float) q, (float) h);
        var1.lineTo((float) r, 0.0F);
        var1.lineTo((float) (z - k), 0.0F);
        var1.lineTo((float) z, (float) k);
    }

    public final void a(Path var1, int var2) {
        var1.lineTo((float) j, (float) (var2 - l));
        float var3 = (float) (j + l);
        float var4 = (float) var2;
        var1.lineTo(var3, var4);
        var1.lineTo((float) (z - k), var4);
        var1.lineTo((float) z, (float) (var2 + k));
    }

    public final void a(Path var1, int var2, boolean var3, int var4) {
        var1.lineTo((float) z, (float) (var2 - k));
        float var5 = (float) (z - k);
        float var6 = (float) var2;
        var1.lineTo(var5, var6);
        if (var3) {
            var1.lineTo((float) (var4 + r), var6);
            var1.lineTo((float) (var4 + q), (float) (var2 + h));
            var1.lineTo((float) (var4 + p), (float) (var2 + h));
            var1.lineTo((float) (var4 + o), var6);
        }

        if (var4 > 0) {
            var1.lineTo((float) (var4 + l), var6);
            var1.lineTo((float) var4, (float) (var2 + l));
        } else {
            var1.lineTo((float) (var4 + k), var6);
            var1.lineTo(0.0F, (float) (var2 - k));
        }
    }

    public final float[] a(int var1) {
        float[] var2 = new float[24];
        int var3 = P;
        var2[0] = (float) (0 + var3 / 2);
        int var4 = k;
        var2[1] = (float) (var1 - var4);
        var2[2] = (float) (0 + var3 / 2);
        var2[3] = (float) var4;
        var2[4] = (float) (0 + var3 / 2);
        var2[5] = (float) var4;
        var2[6] = (float) var4;
        var2[7] = (float) (0 + var3 / 2);
        var2[8] = (float) var4;
        var2[9] = (float) (0 + var3 / 2);
        var2[10] = (float) o;
        var2[11] = (float) (0 + var3 / 2);
        var2[12] = (float) p;
        int var5 = h;
        var2[13] = (float) (var5 + var3 / 2);
        int var6 = q;
        var2[14] = (float) var6;
        var2[15] = (float) (var5 + var3 / 2);
        var2[16] = (float) var6;
        var2[17] = (float) (var5 + var3 / 2);
        int var7 = r;
        var2[18] = (float) var7;
        var2[19] = (float) (0 + var3 / 2);
        var2[20] = (float) var7;
        var2[21] = (float) (0 + var3 / 2);
        var2[22] = (float) (z - var4);
        var2[23] = (float) (0 + var3 / 2);
        return var2;
    }

    public final float[] a(int var1, int var2) {
        float[] var3 = new float[8];
        int var4 = j;
        int var5 = l;
        var3[0] = (float) (var4 + var5);
        int var6 = P;
        var3[1] = (float) (var1 - var6 / 2);
        var3[2] = (float) (var4 - var6 / 2);
        var3[3] = (float) (var1 + var5);
        var3[4] = (float) (var4 - var6 / 2);
        var3[5] = (float) (var1 + var5);
        var3[6] = (float) (var4 - var6 / 2);
        var3[7] = (float) (var2 - var5);
        return var3;
    }

    public final float[] a(int var1, boolean var2, int var3) {
        float[] var4;
        if (var2) {
            var4 = new float[24];
        } else {
            var4 = new float[8];
        }

        int var5 = z;
        var4[0] = (float) var5;
        int var6 = k;
        int var7 = var1 - var6;
        int var8 = P;
        var4[1] = (float) (var7 - var8 / 2);
        var4[2] = (float) (var5 - var6);
        var4[3] = (float) (var1 - var8 / 2);
        if (var2) {
            var4[4] = (float) (var5 - var6);
            var4[5] = (float) (var1 - var8 / 2);
            int var9 = r;
            var4[6] = (float) (var3 + var9);
            var4[7] = (float) (var1 - var8 / 2);
            var4[8] = (float) (var9 + var3);
            var4[9] = (float) (var1 - var8 / 2);
            int var10 = q;
            var4[10] = (float) (var3 + var10);
            int var11 = h;
            var4[11] = (float) (var1 + var11 - var8 / 2);
            var4[12] = (float) (var10 + var3);
            var4[13] = (float) (var1 + var11 - var8 / 2);
            int var12 = p;
            var4[14] = (float) (var3 + var12);
            var4[15] = (float) (var1 + var11 - var8 / 2);
            var4[16] = (float) (var12 + var3);
            var4[17] = (float) (var11 + var1 - var8 / 2);
            int var13 = o;
            var4[18] = (float) (var3 + var13);
            var4[19] = (float) (var1 - var8 / 2);
            if (var3 > 0) {
                var4[20] = (float) (var13 + var3);
                var4[21] = (float) (var1 - var8 / 2);
                var4[22] = (float) (var3 + l);
                var4[23] = (float) (var1 - var8 / 2);
                return var4;
            } else {
                var4[20] = (float) (var13 + var3);
                var4[21] = (float) (var1 - var8 / 2);
                var4[22] = (float) (var3 + var6);
                var4[23] = (float) (var1 - var8 / 2);
                return var4;
            }
        } else if (var3 > 0) {
            var4[4] = (float) (var5 - var6);
            var4[5] = (float) (var1 - var8 / 2);
            var4[6] = (float) (var3 + l);
            var4[7] = (float) (var1 - var8 / 2);
            return var4;
        } else {
            var4[4] = (float) (var5 - var6);
            var4[5] = (float) (var1 - var8 / 2);
            var4[6] = (float) (var3 + var6);
            var4[7] = (float) (var1 - var8 / 2);
            return var4;
        }
    }

    public final void b(Canvas var1) {
        Path var2 = new Path();
        a(var2);
        int var3 = A;
        int var4 = d;
        boolean var5 = true;
        boolean var6;
        var6 = var4 != 5;

        a(var2, var3, var6, 0);
        var1.drawPath(var2, f);
        if (K) {
            var1.drawLines(b(0, A), N);
            int var7 = A;
            if (d == 5) {
                var5 = false;
            }

            var1.drawLines(a(var7, var5, 0), N);
        }

        if (L) {
            var1.drawLines(a(A), O);
        }

    }

    public boolean b() {
        return d >= 10;
    }

    public final float[] b(int var1, int var2) {
        float[] var3 = new float[4];
        int var4 = z;
        int var5 = P;
        var3[0] = (float) (var4 - var5 / 2);
        int var6 = k;
        var3[1] = (float) (var1 + var6);
        var3[2] = (float) (var4 - var5 / 2);
        var3[3] = (float) (var2 - var6);
        return var3;
    }

    public final void c(Canvas var1) {
        var1.drawRect(new Rect(0, 0, z, A), f);
        Path var2 = new Path();
        int var3 = z;
        int var4 = J;
        var2.moveTo((float) (var3 - var4), (float) var4);
        int var5 = z;
        int var6 = J;
        int var7 = var5 - var6;
        int var8 = I;
        var2.lineTo((float) (var7 - var8 / 2), (float) (var6 + var8));
        int var9 = z;
        int var10 = J;
        var2.lineTo((float) (var9 - var10 - I), (float) var10);
        var1.drawPath(var2, M);
    }

    public boolean c() {
        return d == 12;
    }

    public final float[] c(int var1, int var2) {
        float[] var3 = new float[4];
        var3[0] = (float) (var2 + l);
        int var4 = P;
        var3[1] = (float) (var1 + var4 / 2);
        var3[2] = (float) (z - k);
        var3[3] = (float) (var1 + var4 / 2);
        return var3;
    }

    public int d() {
        return getTotalHeight() - h;
    }

    public final void d(Canvas var1) {
        Path var2 = new Path();
        var2.moveTo(0.0F, (float) s);
        var2.arcTo(new RectF(0.0F, 0.0F, (float) t, (float) (2 * s)), 180.0F, 180.0F);
        var2.lineTo((float) (z - k), (float) s);
        var2.lineTo((float) z, (float) (s + k));
        a(var2, A, true, 0);
        var1.drawPath(var2, f);
        if (K) {
            var1.drawLines(b(s, A), N);
            var1.drawLines(a(A, true, 0), N);
        }

    }

    public void e() {
        requestLayout();
    }

    public final void e(Canvas var1) {
        Path var2 = new Path();
        int var3 = A + B;
        int var4 = h;
        int var5 = var3 - var4;
        int var6 = var5 + n + C - var4;
        a(var2);
        a(var2, A, true, j);
        a(var2, var5);
        a(var2, var5 + n, true, j);
        a(var2, var6);
        a(var2, var6 + m, true, 0);
        var1.drawPath(var2, f);
        if (K) {
            var1.drawLines(b(0, A), N);
            var1.drawLines(a(A, true, j), N);
            var1.drawLines(a(A, var5), N);
            var1.drawLines(b(var5, var5 + n), N);
            var1.drawLines(a(var5 + n, true, j), N);
            var1.drawLines(a(var5 + n, var6), N);
            var1.drawLines(b(var6, var6 + m), N);
            var1.drawLines(a(var6 + m, true, 0), N);
        }

        if (L) {
            var1.drawLines(a(var6 + m), O);
            var1.drawLines(c(var5, j), O);
            var1.drawLines(c(var6, j), O);
        }

    }

    public int f() {
        return A;
    }

    public final void f(Canvas var1) {
        Path var2 = new Path();
        int var3 = A + B - h;
        a(var2);
        int var4 = A;
        int var5 = j;
        boolean var6 = true;
        a(var2, var4, var6, var5);
        a(var2, var3);
        int var7 = var3 + m;
        boolean var8;
        var8 = d == 10;

        a(var2, var7, var8, 0);
        var1.drawPath(var2, f);
        if (K) {
            var1.drawLines(b(0, A), N);
            var1.drawLines(a(A, var6, j), N);
            var1.drawLines(a(A, var3), N);
            var1.drawLines(b(var3, var3 + m), N);
            int var9 = var3 + m;
            if (d != 10) {
                var6 = false;
            }

            var1.drawLines(a(var9, var6, 0), N);
        }

        if (L) {
            var1.drawLines(a(var3 + m), O);
            var1.drawLines(c(var3, j), O);
        }

    }

    public int g() {
        return A + B + n - h;
    }

    public final void g(Canvas var1) {
        Path var2 = new Path();
        int var3 = A;
        int var4 = var3 / 2;
        var2.moveTo((float) var4, (float) var3);
        int var5 = A;
        var2.arcTo(new RectF(0.0F, 0.0F, (float) var5, (float) var5), 90.0F, 180.0F);
        var2.lineTo((float) (z - var4), 0.0F);
        int var6 = z;
        int var7 = A;
        var2.arcTo(new RectF((float) (var6 - var7), 0.0F, (float) var6, (float) var7), 270.0F, 180.0F);
        var1.drawPath(var2, f);
        if (K) {
            int var16 = z;
            int var17 = A;
            float var18 = (float) (var16 - var17);
            int var19 = P;
            var1.drawArc(new RectF(var18, 0.0F, (float) (var16 - var19 / 2), (float) (var17 - var19 / 2)), 330.0F, 120.0F, false, N);
            var1.drawLines(getNumberBottomShadows(), N);
            int var20 = P;
            float var21 = (float) (0 + var20 / 2);
            int var22 = A;
            var1.drawArc(new RectF(var21, 0.0F, (float) var22, (float) (var22 - var20 / 2)), 90.0F, 30.0F, false, N);
        }

        if (L) {
            int var8 = P;
            float var9 = (float) (0 + var8 / 2);
            float var10 = (float) (0 + var8 / 2);
            int var11 = A;
            var1.drawArc(new RectF(var9, var10, (float) var11, (float) var11), 150.0F, 120.0F, false, O);
            var1.drawLines(getNumberTopReflections(), O);
            int var12 = z;
            int var13 = A;
            float var14 = (float) (var12 - var13);
            int var15 = P;
            var1.drawArc(new RectF(var14, (float) (0 + var15 / 2), (float) (var12 - var15 / 2), (float) var13), 270.0F, 30.0F, false, O);
        }

    }

    public Gx getClassInfo() {
        if (S == null) {
            a();
        }

        return S;
    }

    public int getTopH() {
        return A;
    }

    public int getTotalHeight() {
        int var1 = A;
        if (b()) {
            var1 += n + B - h;
        }

        if (c()) {
            var1 += m + C - h;
        }

        int var2 = d;
        if (var2 == 4 || var2 == 7 || var2 == 10 || var2 == 12) {
            var1 += h;
        }

        return var1;
    }

    public int getTotalWidth() {
        return z;
    }

    public int getW() {
        return z;
    }

    public final void h(Canvas var1) {
        var1.drawRect(new Rect(0, 0, z, A), f);
        if (K) {
            var1.drawLines(getRectShadows(), N);
        }

        if (L) {
            var1.drawLines(getRectReflections(), O);
        }

    }

    public void onDraw(Canvas var1) {
        f.setColor(e);
        switch (d) {
            case 1:
                h(var1);
                break;
            case 2:
                a(var1);
                break;
            case 3:
                g(var1);
                break;
            case 4:
            case 5:
                b(var1);
            case 6:
            case 8:
            default:
                break;
            case 7:
                d(var1);
                break;
            case 9:
                c(var1);
                break;
            case 10:
            case 11:
                f(var1);
                break;
            case 12:
                e(var1);
        }

        super.onDraw(var1);
    }

    public void onMeasure(int var1, int var2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(getTotalWidth(), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(getTotalHeight(), MeasureSpec.EXACTLY));
    }

    public void setSubstack1Height(int var1) {
        int var2 = Math.max(var1, i);
        if (var2 != B) {
            B = var2;
        }

    }

    public void setSubstack2Height(int var1) {
        int var2 = Math.max(var1, i);
        if (var2 != C) {
            C = var2;
        }

    }
}
