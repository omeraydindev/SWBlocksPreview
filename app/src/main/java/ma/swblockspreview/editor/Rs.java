package ma.swblockspreview.editor;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

import ma.swblockspreview.bean.BlockBean;
import ma.swblockspreview.editor.logic.BlockPane;
import ma.swblockspreview.util.FB;
import ma.swblockspreview.util.kq;

public class Rs extends Ts {
    public String T;
    public String U;
    public ArrayList V;
    public int W = 30;
    public int aa = 50;
    public int ba = 90;
    public int ca = 90;
    public int da = 4;
    public boolean ea = false;
    public boolean fa = false;
    public boolean ga = false;
    public int ha = -1;
    public int ia = -1;
    public int ja = -1;
    public ArrayList ka = new ArrayList();
    public ArrayList la = new ArrayList();
    public TextView ma = null;
    public int na = 0;
    public int oa = 0;
    public BlockPane pa = null;
    public String qa;
    public String ra;

    public Rs(Context var1, int var2, String var3, String var4, String var5) {
        super(var1, var4, false);
        this.setTag(Integer.valueOf(var2));
        this.T = var3;
        this.U = var5;
        this.l();
    }

    public Rs(Context var1, int var2, String var3, String var4, String var5, String var6) {
        super(var1, var4, var5, false);
        this.setTag(Integer.valueOf(var2));
        this.T = var3;
        this.U = var6;
        this.l();
    }

    public final int a(TextView var1) {
        Rect var2 = new Rect();
        var1.getPaint().getTextBounds(var1.getText().toString(), 0, var1.getText().length(), var2);
        return var2.width();
    }

    public final TextView a(String var1) {
        TextView var2 = new TextView(super.a);
        if (this.U.equals("getVar") || this.U.equals("getArg")) {
            String var3 = super.c;
            if (var3 != null && var3.length() > 0) {
                StringBuilder var5 = new StringBuilder();
                var5.append(super.c);
                var5.append(" : ");
                var5.append(var1);
                var1 = var5.toString();
            }
        }

        var2.setText(var1);
        var2.setTextSize(10.0F);
        var2.setPadding(0, 0, 0, 0);
        var2.setGravity(16);
        var2.setTextColor(-1);
        var2.setTypeface((Typeface) null, Typeface.BOLD);
        LayoutParams var4 = new LayoutParams(-2, super.G);
        var4.setMargins(0, 0, 0, 0);
        var2.setLayoutParams(var4);
        return var2;
    }

    public final void a(Rs var1) {
        if (this.b() && -1 == this.ia) {
            this.e(var1);
        } else {
            Rs var2 = this.h();
            var2.ha = ((Integer) var1.getTag()).intValue();
            var1.E = var2;
        }
    }

    public void a(Ts var1, Rs var2) {
        int var3 = this.ka.indexOf(var1);
        if (var3 >= 0) {
            boolean var4 = var1 instanceof Rs;
            if (var4) {
                Rs var6 = (Rs) var1;
                var2.qa = var6.qa;
                var2.ra = var6.ra;
            } else if (var1 instanceof Ss) {
                var2.qa = var1.b;
                var2.ra = var1.c;
            }

            if (!var4) {
                this.removeView(var1);
            }

            this.ka.set(var3, var2);
            var2.E = this;
            this.i();
            this.o();
            if (var1 != var2 && var4) {
                var1.E = null;
                var1.setX(10.0F + this.getX() + (float) this.getWidthSum());
                var1.setY(5.0F + this.getY());
                ((Rs) var1).k();
            }

        }
    }

    public final void a(String var1, int var2) {
        ArrayList var3 = FB.c(var1);
        this.ka = new ArrayList();
        this.la = new ArrayList();

        for (int var4 = 0; var4 < var3.size(); ++var4) {
            View var5 = this.b((String) var3.get(var4), var2);
            if (var5 instanceof Ts) {
                ((Ts) var5).E = this;
            }

            this.ka.add(var5);
            String var7;
            if (var5 instanceof Ss) {
                var7 = (String) var3.get(var4);
            } else {
                var7 = "icon";
            }

            if (var5 instanceof TextView) {
                var7 = "label";
            }

            this.la.add(var7);
        }

    }

    public final View b(String var1, int var2) {
        if (var1.length() >= 2 && var1.charAt(0) == 37) {
            char var3 = var1.charAt(1);
            String var4 = "";
            if (var3 == 98) {
                return new Ss(super.a, "b", var4);
            }

            if (var3 == 100) {
                return new Ss(super.a, "d", var4);
            }

            if (var3 == 109) {
                return new Ss(super.a, "m", var1.substring(3));
            }

            if (var3 == 115) {
                Context var5 = super.a;
                if (var1.length() > 2) {
                    var4 = var1.substring(3);
                }

                return new Ss(var5, "s", var4);
            }
        }

        return this.a(FB.d(var1));
    }

    public void b(Rs var1) {
        View var2 = this.pa.findViewWithTag(Integer.valueOf(this.ha));
        if (var2 != null) {
            ((Rs) var2).E = null;
        }

        var1.E = this;
        this.ha = ((Integer) var1.getTag()).intValue();
        if (var2 != null) {
            var1.a((Rs) var2);
        }

    }

    public void c(Rs var1) {
        var1.setX(this.getX());
        var1.setY(this.getY() - (float) var1.getHeightSum() + (float) super.h);
        var1.h().b(this);
    }

    public void d(Rs var1) {
        var1.setX(this.getX() - (float) super.j);
        var1.setY(this.getY() - (float) this.f());
        super.E = var1;
        var1.ia = ((Integer) this.getTag()).intValue();
    }

    public void e(Rs var1) {
        View var2 = this.pa.findViewWithTag(Integer.valueOf(this.ia));
        if (var2 != null) {
            ((Rs) var2).E = null;
        }

        var1.E = this;
        this.ia = ((Integer) var1.getTag()).intValue();
        if (var2 != null) {
            var1.a((Rs) var2);
        }

    }

    public void f(Rs var1) {
        View var2 = this.pa.findViewWithTag(Integer.valueOf(this.ja));
        if (var2 != null) {
            ((Rs) var2).E = null;
        }

        var1.E = this;
        this.ja = ((Integer) var1.getTag()).intValue();
        if (var2 != null) {
            var1.a((Rs) var2);
        }

    }

    public void g(Rs var1) {
        if (this.ha == ((Integer) var1.getTag()).intValue()) {
            this.ha = -1;
        }

        if (this.ia == ((Integer) var1.getTag()).intValue()) {
            this.ia = -1;
        }

        if (this.ja == ((Integer) var1.getTag()).intValue()) {
            this.ja = -1;
        }

        if (var1.fa) {
            int var2 = this.ka.indexOf(var1);
            if (var2 < 0) {
                return;
            }

            var1.qa = "";
            var1.ra = "";
            View var3 = this.b((String) this.la.get(var2), super.e);
            if (var3 instanceof Ts) {
                ((Ts) var3).E = this;
            }

            this.ka.set(var2, var3);
            this.addView(var3);
            this.i();
            this.o();
        }

        this.p().k();
    }

    public ArrayList getAllChildren() {
        ArrayList var1 = new ArrayList();
        Rs var2 = this;

        while (true) {
            var1.add(var2);
            Iterator var4 = var2.ka.iterator();

            while (var4.hasNext()) {
                View var10 = (View) var4.next();
                if (var10 instanceof Rs) {
                    var1.addAll(((Rs) var10).getAllChildren());
                }
            }

            if (var2.b()) {
                int var8 = var2.ia;
                if (var8 != -1) {
                    var1.addAll(((Rs) this.pa.findViewWithTag(Integer.valueOf(var8))).getAllChildren());
                }
            }

            if (var2.c()) {
                int var6 = var2.ja;
                if (var6 != -1) {
                    var1.addAll(((Rs) this.pa.findViewWithTag(Integer.valueOf(var6))).getAllChildren());
                }
            }

            int var5 = var2.ha;
            if (var5 == -1) {
                return var1;
            }

            var2 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var5));
        }
    }

    public BlockBean getBean() {
        BlockBean var1 = new BlockBean(this.getTag().toString(), this.T, super.b, super.c, this.U);
        var1.color = super.e;
        Iterator var2 = this.V.iterator();

        while (var2.hasNext()) {
            View var3 = (View) var2.next();
            if (var3 instanceof Ss) {
                var1.parameters.add(((Ss) var3).getArgValue().toString());
            } else if (var3 instanceof Rs) {
                ArrayList var4 = var1.parameters;
                StringBuilder var5 = new StringBuilder();
                var5.append("@");
                var5.append(var3.getTag().toString());
                var4.add(var5.toString());
            }
        }

        var1.subStack1 = this.ia;
        var1.subStack2 = this.ja;
        var1.nextBlock = this.ha;
        return var1;
    }

    public int getBlockType() {
        return this.oa;
    }

    public int getDepth() {
        int var1 = 0;
        Rs var2 = this;

        while (true) {
            var2 = var2.E;
            if (var2 == null) {
                return var1;
            }

            ++var1;
        }
    }

    public int getHeightSum() {
        int var1 = 0;
        Rs var2 = this;

        while (true) {
            if (var1 > 0) {
                var1 -= super.h;
            }

            var1 += var2.getTotalHeight();
            int var3 = var2.ha;
            if (var3 == -1) {
                return var1;
            }

            var2 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var3));
        }
    }

    public int getWidthSum() {
        int var1 = 0;
        Rs var2 = this;

        while (true) {
            var1 = Math.max(var1, var2.getW());
            if (var2.b()) {
                int var5 = var2.ia;
                if (var5 != -1) {
                    var1 = Math.max(var1, super.j + ((Rs) this.pa.findViewWithTag(Integer.valueOf(var5))).getWidthSum());
                }
            }

            if (var2.c()) {
                int var4 = var2.ja;
                if (var4 != -1) {
                    var1 = Math.max(var1, super.j + ((Rs) this.pa.findViewWithTag(Integer.valueOf(var4))).getWidthSum());
                }
            }

            int var3 = var2.ha;
            if (var3 == -1) {
                return var1;
            }

            var2 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var3));
        }
    }

    public Rs h() {
        Rs var1 = this;

        while (true) {
            int var2 = var1.ha;
            if (var2 == -1) {
                return var1;
            }

            var1 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var2));
        }
    }

    public final void i() {
        this.V = new ArrayList();

        for (int var1 = 0; var1 < this.ka.size(); ++var1) {
            View var2 = (View) this.ka.get(var1);
            if (var2 instanceof Rs || var2 instanceof Ss) {
                this.V.add(var2);
            }
        }

    }

    public final void j() {
        TextView var1 = this.ma;
        if (var1 != null) {
            var1.bringToFront();
            this.ma.setX((float) super.w);
            this.ma.setY((float) (this.g() - super.n));
        }

    }

    public void k() {
        this.bringToFront();
        int var1 = super.w;

        for (int var2 = 0; var2 < this.ka.size(); ++var2) {
            View var12 = (View) this.ka.get(var2);
            var12.bringToFront();
            boolean var13 = var12 instanceof Rs;
            if (var13) {
                var12.setX(this.getX() + (float) var1);
            } else {
                var12.setX((float) var1);
            }

            int var14;
            if (((String) this.la.get(var2)).equals("label")) {
                var14 = this.a((TextView) var12);
            } else {
                var14 = 0;
            }

            if (var12 instanceof Ss) {
                var14 = ((Ss) var12).getW();
            }

            if (var13) {
                var14 = ((Rs) var12).getWidthSum();
            }

            var1 += var14 + this.da;
            if (var13) {
                float var15 = this.getY() + (float) super.u;
                int var16 = this.na;
                Rs var17 = (Rs) var12;
                var12.setY(var15 + (float) ((var16 - var17.na - 1) * super.y));
                var17.k();
            } else {
                var12.setY((float) (super.u + this.na * super.y));
            }
        }

        if (super.b.equals("b") || super.b.equals("d") || super.b.equals("s") || super.b.equals("a")) {
            var1 = Math.max(var1, this.W);
        }

        if (super.b.equals(" ") || super.b.equals("") || super.b.equals("f")) {
            var1 = Math.max(var1, this.aa);
        }

        if (super.b.equals("c") || super.b.equals("e")) {
            var1 = Math.max(var1, this.ca);
        }

        if (super.b.equals("h")) {
            var1 = Math.max(var1, this.ba);
        }

        this.a((float) (var1 + super.x), (float) (super.u + super.G + 2 * this.na * super.y + super.v), true);
        if (this.b()) {
            int var5 = super.i;
            int var6 = this.ia;
            if (var6 > -1) {
                Rs var11 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var6));
                var11.setX(this.getX() + (float) super.j);
                var11.setY(this.getY() + (float) this.f());
                var11.bringToFront();
                var11.k();
                var5 = var11.getHeightSum();
            }

            this.setSubstack1Height(var5);
            int var7 = super.i;
            int var8 = this.ja;
            if (var8 > -1) {
                Rs var9 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var8));
                var9.setX(this.getX() + (float) super.j);
                var9.setY(this.getY() + (float) this.g());
                var9.bringToFront();
                var9.k();
                int var10 = var9.getHeightSum();
                if (var9.h().ga) {
                    var7 = var10 + super.h;
                } else {
                    var7 = var10;
                }
            }

            this.setSubstack2Height(var7);
            this.j();
        }

        int var3 = this.ha;
        if (var3 > -1) {
            Rs var4 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var3));
            var4.setX(this.getX());
            var4.setY(this.getY() + (float) this.d());
            var4.bringToFront();
            var4.k();
        }

    }

    public void l() {
        byte var5;
        label84:
        {
            this.setDrawingCacheEnabled(false);
            float var1 = (float) this.W;
            float var2 = super.D;
            this.W = (int) (var1 * var2);
            this.aa = (int) (var2 * (float) this.aa);
            this.ba = (int) (var2 * (float) this.ba);
            this.ca = (int) (var2 * (float) this.ca);
            this.da = (int) (var2 * (float) this.da);
            String var3 = super.b;
            int var4 = var3.hashCode();
            if (var4 != 32) {
                if (var4 != 104) {
                    if (var4 != 108) {
                        if (var4 != 112) {
                            if (var4 != 115) {
                                if (var4 != 118) {
                                    switch (var4) {
                                        case 97:
                                            if (var3.equals("a")) {
                                                var5 = 7;
                                                break label84;
                                            }
                                            break;
                                        case 98:
                                            if (var3.equals("b")) {
                                                var5 = 1;
                                                break label84;
                                            }
                                            break;
                                        case 99:
                                            if (var3.equals("c")) {
                                                var5 = 8;
                                                break label84;
                                            }
                                            break;
                                        case 100:
                                            if (var3.equals("d")) {
                                                var5 = 3;
                                                break label84;
                                            }
                                            break;
                                        case 101:
                                            if (var3.equals("e")) {
                                                var5 = 9;
                                                break label84;
                                            }
                                            break;
                                        case 102:
                                            if (var3.equals("f")) {
                                                var5 = 10;
                                                break label84;
                                            }
                                    }
                                } else if (var3.equals("v")) {
                                    var5 = 4;
                                    break label84;
                                }
                            } else if (var3.equals("s")) {
                                var5 = 2;
                                break label84;
                            }
                        } else if (var3.equals("p")) {
                            var5 = 5;
                            break label84;
                        }
                    } else if (var3.equals("l")) {
                        var5 = 6;
                        break label84;
                    }
                } else if (var3.equals("h")) {
                    var5 = 11;
                    break label84;
                }
            } else if (var3.equals(" ")) {
                var5 = 0;
                break label84;
            }

            var5 = -1;
        }

        switch (var5) {
            case 0:
            case 8:
            case 9:
            default:
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                this.fa = true;
                break;
            case 10:
                this.ga = true;
                break;
            case 11:
                this.ea = true;
        }

            /*
     if(!this.ea && !this.U.equals("definedFunc") && !this.U.equals("getVar") && !this.U.equals("getArg")) {
     this.T = xB.b().a(this.getContext(), this.U);
     }
     */

            /*if(this.T.equals("")) {
     this.T = MakeBlock.getSpecBlock(this.U);
     }*/

        this.setSpec(this.T);

        int colorc = kq.a(this.U, super.b);

        if (colorc != -12289797) {
            super.e = colorc;
        }

        //super.e = /* MakeBlock.getColorBlock(*/kq.a(this.U, super.b);//, this.U);
    }

    public void m() {
        Rs var1 = this;

        do {
            var1.n();
            var1 = var1.E;
        } while (var1 != null);

    }

    public void n() {
        int var1 = super.w;

        for (int var2 = 0; var2 < this.ka.size(); ++var2) {
            View var4 = (View) this.ka.get(var2);
            int var5;
            if (((String) this.la.get(var2)).equals("label")) {
                var5 = this.a((TextView) var4);
            } else {
                var5 = 0;
            }

            if (var4 instanceof Ss) {
                var5 = ((Ss) var4).getW();
            }

            if (var4 instanceof Rs) {
                var5 = ((Rs) var4).getWidthSum();
            }

            var1 += var5 + this.da;
        }

        if (super.b.equals("b") || super.b.equals("d") || super.b.equals("s") || super.b.equals("a")) {
            var1 = Math.max(var1, this.W);
        }

        if (super.b.equals(" ") || super.b.equals("") || super.b.equals("o")) {
            var1 = Math.max(var1, this.aa);
        }

        if (super.b.equals("c") || super.b.equals("e")) {
            var1 = Math.max(var1, this.ca);
        }

        if (super.b.equals("h")) {
            var1 = Math.max(var1, this.ba);
        }

        TextView var3 = this.ma;
        if (var3 != null) {
            var1 = Math.max(var1, 2 + super.w + var3.getWidth());
        }

        this.a((float) (var1 + super.x), (float) (super.u + super.G + 2 * this.na * super.y + super.v), false);
    }

    public void o() {
        for (Rs var1 = this; var1 != null; var1 = var1.E) {
            int var2 = 0;
            Iterator var3 = var1.V.iterator();

            while (var3.hasNext()) {
                View var4 = (View) var3.next();
                if (var4 instanceof Rs) {
                    var2 = Math.max(var2, 1 + ((Rs) var4).na);
                }
            }

            var1.na = var2;
            var1.n();
            if (!var1.fa) {
                return;
            }
        }

    }

    public Rs p() {
        Rs var1 = this;

        while (true) {
            Rs var2 = var1.E;
            if (var2 == null) {
                return var1;
            }

            var1 = var2;
        }
    }

    public void setBlockType(int var1) {
        this.oa = var1;
    }

    public void setSpec(String var1) {
        this.T = var1;
        this.removeAllViews();
        this.a(this.T, super.e);
        Iterator var2 = this.ka.iterator();

        while (var2.hasNext()) {
            this.addView((View) var2.next());
        }

        this.i();
        if (super.b.equals("e") && this.U.equals("ifElse")) {
            this.ma = this.a("else");
            this.addView(this.ma);
        }

        if (super.b.equals("e") && this.U.equals("tryCatch")) {
            this.ma = this.a("Catch");
            this.addView(this.ma);
        }

        this.k();
    }
}
