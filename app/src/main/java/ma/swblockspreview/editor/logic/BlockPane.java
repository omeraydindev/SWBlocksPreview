package ma.swblockspreview.editor.logic;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import ma.swblockspreview.bean.BlockBean;
import ma.swblockspreview.editor.Rs;
import ma.swblockspreview.editor.Ss;
import ma.swblockspreview.editor.Ts;
import ma.swblockspreview.util.Gx;
import ma.swblockspreview.util.LayoutUtils;
import ma.swblockspreview.util.mq;

public class BlockPane extends RelativeLayout {
    public Context a;
    public int[] b = new int[2];
    public Ts c;
    public Rs d;
    public ArrayList e = new ArrayList<>();
    public Object[] f = null;
    public int g = 10;
    public float h = LayoutUtils.getDip(getContext(), 1.0F);

    public BlockPane(Context var1) {
        super(var1);
        a(var1);
    }

    public Rs a(int var1) {
        return findViewWithTag(Integer.valueOf(var1));
    }

    public Rs a(Rs var1, int var2, int var3) {
        getLocationOnScreen(b);
        if (var1.getBlockType() == 1) {
            Context var4 = getContext();
            int var5 = g;
            g = var5 + 1;
            Rs var6 = new Rs(var4, var5, var1.T, var1.b, var1.c, var1.U);
            var1 = var6;
        }

        var1.pa = this;
        addView(var1);
        var1.setX((float) (var2 - b[0] - getPaddingLeft()));
        var1.setY((float) (var3 - b[1] - getPaddingTop()));
        return var1;
    }

    public Rs a(Rs var1, int var2, int var3, boolean var4) {
        Rs var5;
        if (!var4) {
            var5 = a(var1, var2, var3);
        } else {
            var1.setX((float) (var2 - b[0] - getPaddingLeft()));
            var1.setY((float) (var3 - b[1] - getPaddingTop()));
            var5 = var1;
        }

        Object[] var6 = f;
        if (var6 == null) {
            var5.p().k();
            b();
            return var5;
        } else {
            if (var1.fa) {
                ((Ts) var6[1]).E.a((Ts) var6[1], var5);
            } else {
                Rs var7 = (Rs) var6[1];
                int var8 = ((Integer) var6[2]).intValue();
                if (var8 != 0) {
                    if (var8 != 1) {
                        if (var8 != 2) {
                            if (var8 != 3) {
                                if (var8 == 4) {
                                    var7.d(var5);
                                }
                            } else {
                                var7.f(var5);
                            }
                        } else {
                            var7.e(var5);
                        }
                    } else {
                        var7.c(var5);
                    }
                } else {
                    var7.b(var5);
                }
            }

            var5.p().k();
            b();
            return var5;
        }
    }

    public Rs a(String var1) {
        return findViewWithTag(Integer.valueOf(var1));
    }

    public final void a() {
        if (c == null) {
            c = new Ts(a, " ", true);
        }

        c.a(10.0F, 10.0F, false);
        addView(c);
        d();
    }

    public void a(Rs var1) {
        boolean var2 = var1.h().ga;
        boolean var3;
        var3 = var1.b() && -1 == var1.ia;

        boolean var4 = var1.fa;
        a(var1.getTag().toString(), var2, var3, var4, var1.getHeight(), var1.f());
        f = null;
    }

    public void a(Rs var1, int var2) {
        while (true) {
            if (var1 != null) {
                var1.setVisibility(var2);

                for (View var7 : var1.V) {
                    if (var7 instanceof Rs) {
                        a((Rs) var7, var2);
                    }
                }

                if (var1.b()) {
                    int var6 = var1.ia;
                    if (var6 != -1) {
                        a(findViewWithTag(Integer.valueOf(var6)), var2);
                    }
                }

                if (var1.c()) {
                    int var5 = var1.ja;
                    if (var5 != -1) {
                        a(findViewWithTag(Integer.valueOf(var5)), var2);
                    }
                }

                int var4 = var1.ha;
                if (var4 != -1) {
                    var1 = findViewWithTag(Integer.valueOf(var4));
                    continue;
                }
            }

            return;
        }
    }

    public final void a(Rs var1, String var2) {
        while (true) {
            if (var1 != null) {
                if (!var1.ea) {
                    for (int var6 = 0; var6 < var1.V.size(); ++var6) {
                        View var7 = var1.V.get(var6);
                        boolean var8 = var7 instanceof Rs;
                        if ((var8 || var7 instanceof Ss) && (!var8 || !var7.getTag().toString().equals(var2))) {
                            int[] var9 = new int[2];
                            var7.getLocationOnScreen(var9);
                            a(var9, var7, 0);
                            if (var8) {
                                a((Rs) var7, var2);
                            }
                        }
                    }
                }

                int var3 = var1.ia;
                if (var3 != -1) {
                    a(findViewWithTag(Integer.valueOf(var3)), var2);
                }

                int var4 = var1.ja;
                if (var4 != -1) {
                    a(findViewWithTag(Integer.valueOf(var4)), var2);
                }

                int var5 = var1.ha;
                if (var5 != -1) {
                    var1 = findViewWithTag(Integer.valueOf(var5));
                    continue;
                }
            }

            return;
        }
    }

    public void a(Rs var1, ArrayList var2) {
        if (var2.size() <= 0) {
            a(var1);
        } else {
            BlockBean var3;
            BlockBean var4;
            byte var7;
            label64:
            {
                var3 = (BlockBean) var2.get(0);
                var4 = (BlockBean) var2.get(var2.size() - 1);
                String var5 = var3.type;
                int var6 = var5.hashCode();
                if (var6 != 97) {
                    if (var6 != 98) {
                        if (var6 != 100) {
                            if (var6 != 108) {
                                if (var6 != 112) {
                                    if (var6 != 115) {
                                        if (var6 == 118 && var5.equals("v")) {
                                            var7 = 3;
                                            break label64;
                                        }
                                    } else if (var5.equals("s")) {
                                        var7 = 1;
                                        break label64;
                                    }
                                } else if (var5.equals("p")) {
                                    var7 = 4;
                                    break label64;
                                }
                            } else if (var5.equals("l")) {
                                var7 = 5;
                                break label64;
                            }
                        } else if (var5.equals("d")) {
                            var7 = 2;
                            break label64;
                        }
                    } else if (var5.equals("b")) {
                        var7 = 0;
                        break label64;
                    }
                } else if (var5.equals("a")) {
                    var7 = 6;
                    break label64;
                }

                var7 = -1;
            }

            boolean var8;
            switch (var7) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    var8 = true;
                    break;
                default:
                    var8 = false;
            }

            boolean var9 = var4.type.equals("f");
            boolean var10;
            var10 = (var3.type.equals("c") || var3.type.equals("e")) && var3.subStack1 <= 0;

            a(var3.id, var9, var10, var8, var1.getHeight(), var1.f());
            f = null;
        }
    }

    public final void a(Rs var1, boolean var2) {
        while (var1.getVisibility() != View.GONE) {
            if (!var1.ga && (!var2 || -1 == var1.ha)) {
                int[] var8 = new int[2];
                var1.getLocationOnScreen(var8);
                var8[1] += var1.d();
                a(var8, var1, 0);
            }

            if (var1.b() && (!var2 || var1.ia == -1)) {
                int[] var7 = new int[2];
                var1.getLocationOnScreen(var7);
                var7[0] += var1.j;
                var7[1] += var1.f();
                a(var7, var1, 2);
            }

            if (var1.c() && (!var2 || var1.ja == -1)) {
                int[] var6 = new int[2];
                var1.getLocationOnScreen(var6);
                var6[0] += var1.j;
                var6[1] += var1.g();
                a(var6, var1, 3);
            }

            int var3 = var1.ia;
            if (var3 != -1) {
                a(findViewWithTag(Integer.valueOf(var3)), var2);
            }

            int var4 = var1.ja;
            if (var4 != -1) {
                a(findViewWithTag(Integer.valueOf(var4)), var2);
            }

            int var5 = var1.ha;
            if (var5 == -1) {
                return;
            }

            var1 = findViewWithTag(Integer.valueOf(var5));
        }

    }

    public final void a(Context var1) {
        a = var1;
        a();
    }

    public void a(BlockBean var1, boolean var2) {
        String var3 = var1.id;
        if (var3 != null && !var3.equals("")) {
            if (var1.id.equals("0")) {
                return;
            }

            Rs var4 = findViewWithTag(Integer.valueOf(var1.id));
            if (var4 == null) {
                return;
            }

            Rs var5 = var4.E;
            if (var4 != var5) {
                c(var4);
                removeView(var4);
            } else {
                removeView(var4);
            }

            if (var2 && var5 != null) {
                var5.p().k();
            }
        }

    }

    public void a(String var1, String var2) {
        d = new Rs(getContext(), 0, var1, "h", var2);
        d.pa = this;
        addView(d);
        float var5 = LayoutUtils.getDip(getContext(), 1.0F);
        float var7 = var5 * 8.0F;
        d.setX(var7);
        d.setY(var7);
    }

    public void a(String str, boolean z, boolean z2, boolean z3, int i, int i2) {
        e = new ArrayList<>();
        int i3 = (int) (3.0f * h);
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt instanceof Rs) {
                Rs rs = (Rs) childAt;
                if (rs.getVisibility() != View.GONE && rs.E == null) {
                    if (z3) {
                        a(rs, str);
                    } else if (!rs.fa) {
                        int[] iArr;
                        boolean z4 = true;
                        if (!(z || rs.ea)) {
                            iArr = new int[2];
                            rs.getLocationOnScreen(iArr);
                            iArr[1] = iArr[1] - (i - i3);
                            a(iArr, rs, 1);
                        }
                        if (z2 && !rs.ea) {
                            iArr = new int[2];
                            rs.getLocationOnScreen(iArr);
                            iArr[0] = iArr[0] - rs.j;
                            iArr[1] = iArr[1] - (i2 - i3);
                            a(iArr, rs, 4);
                        }
                        if (!z || z2) {
                            z4 = false;
                        }
                        a(rs, z4);
                    }
                }
            }
        }
    }

    public final void a(int[] var1, View var2, int var3) {
        Object[] var4 = new Object[]{var1, var2, Integer.valueOf(var3)};
        e.add(var4);
    }

    public final boolean a(Rs var1, View var2) {
        if (!var1.fa) {
            return true;
        } else {
            if (var2 instanceof Ts) {
                Gx var3 = var1.getClassInfo();
                if (var3 == null) {
                    return false;
                }

                Gx var4 = ((Ts) var2).getClassInfo();
                if (var4 == null) {
                    return false;
                }

                if (var3.a(var4)) {
                    return true;
                }

                return var2 instanceof Rs && var3.a(mq.b(((Rs) var2).ra));
            }

            return false;
        }
    }

    public void b() {
        int var1 = getChildCount();
        int var2 = getLayoutParams().width;
        int var3 = getLayoutParams().width;

        for (int var4 = 0; var4 < var1; ++var4) {
            View var5 = getChildAt(var4);
            if (var5 instanceof Rs) {
                float var6 = var5.getX();
                Rs var7 = (Rs) var5;
                var2 = Math.max(150 + (int) (var6 + (float) var7.getWidthSum()), var2);
                var3 = Math.max(150 + (int) (var5.getY() + (float) var7.getHeightSum()), var3);
            }
        }

        getLayoutParams().width = var2;
        getLayoutParams().height = var3;
    }

    public void b(Rs var1) {
        c(var1);

        for (Rs rs : var1.getAllChildren()) {
            removeView(rs);
        }

    }

    public boolean b(String var1) {
        int var2 = getChildCount();

        for (int var3 = 0; var3 < var2; ++var3) {
            View var4 = getChildAt(var3);
            if (var4 instanceof Rs) {
                BlockBean var5;
                byte var7;
                label112:
                {
                    var5 = ((Rs) var4).getBean();
                    String var6 = var5.opCode;
                    switch (var6.hashCode()) {
                        case -1998407506:
                            if (var6.equals("listSetData")) {
                                var7 = 15;
                                break label112;
                            }
                            break;
                        case -1384861688:
                            if (var6.equals("getAtListInt")) {
                                var7 = 9;
                                break label112;
                            }
                            break;
                        case -1384858251:
                            if (var6.equals("getAtListMap")) {
                                var7 = 21;
                                break label112;
                            }
                            break;
                        case -1384851894:
                            if (var6.equals("getAtListStr")) {
                                var7 = 10;
                                break label112;
                            }
                            break;
                        case -1271141237:
                            if (var6.equals("clearList")) {
                                var7 = 5;
                                break label112;
                            }
                            break;
                        case -1249347599:
                            if (var6.equals("getVar")) {
                                var7 = 0;
                                break label112;
                            }
                            break;
                        case -1139353316:
                            if (var6.equals("setListMap")) {
                                var7 = 23;
                                break label112;
                            }
                            break;
                        case -733318734:
                            if (var6.equals("strToListMap")) {
                                var7 = 17;
                                break label112;
                            }
                            break;
                        case -329562760:
                            if (var6.equals("insertListInt")) {
                                var7 = 18;
                                break label112;
                            }
                            break;
                        case -329559323:
                            if (var6.equals("insertListMap")) {
                                var7 = 22;
                                break label112;
                            }
                            break;
                        case -329552966:
                            if (var6.equals("insertListStr")) {
                                var7 = 19;
                                break label112;
                            }
                            break;
                        case -96313603:
                            if (var6.equals("containListInt")) {
                                var7 = 2;
                                break label112;
                            }
                            break;
                        case -96310166:
                            if (var6.equals("containListMap")) {
                                var7 = 4;
                                break label112;
                            }
                            break;
                        case -96303809:
                            if (var6.equals("containListStr")) {
                                var7 = 3;
                                break label112;
                            }
                            break;
                        case 134874756:
                            if (var6.equals("listSetCustomViewData")) {
                                var7 = 16;
                                break label112;
                            }
                            break;
                        case 389111867:
                            if (var6.equals("spnSetData")) {
                                var7 = 14;
                                break label112;
                            }
                            break;
                        case 762282303:
                            if (var6.equals("indexListInt")) {
                                var7 = 11;
                                break label112;
                            }
                            break;
                        case 762292097:
                            if (var6.equals("indexListStr")) {
                                var7 = 12;
                                break label112;
                            }
                            break;
                        case 1160674468:
                            if (var6.equals("lengthList")) {
                                var7 = 1;
                                break label112;
                            }
                            break;
                        case 1252547704:
                            if (var6.equals("listMapToStr")) {
                                var7 = 6;
                                break label112;
                            }
                            break;
                        case 1764351209:
                            if (var6.equals("deleteList")) {
                                var7 = 13;
                                break label112;
                            }
                            break;
                        case 2090179216:
                            if (var6.equals("addListInt")) {
                                var7 = 7;
                                break label112;
                            }
                            break;
                        case 2090182653:
                            if (var6.equals("addListMap")) {
                                var7 = 20;
                                break label112;
                            }
                            break;
                        case 2090189010:
                            if (var6.equals("addListStr")) {
                                var7 = 8;
                                break label112;
                            }
                    }

                    var7 = -1;
                }

                switch (var7) {
                    case 0:
                        if (var5.spec.equals(var1)) {
                            return true;
                        }
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        if (var5.parameters.get(0).equals(var1)) {
                            return true;
                        }
                        break;
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        if (var5.parameters.get(1).equals(var1)) {
                            return true;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        if (var5.parameters.get(2).equals(var1)) {
                            return true;
                        }
                        break;
                    case 22:
                    case 23:
                        if (var5.parameters.get(3).equals(var1)) {
                            return true;
                        }
                }
            }
        }

        return false;
    }

    public Object[] b(Rs var1, int var2, int var3) {
        byte var4;
        if (var1.fa) {
            var4 = 40;
        } else {
            var4 = 60;
        }

        int var5 = 100000;
        Object[] var6 = null;
        Point var7 = new Point(var2, var3);

        for (int var8 = 0; var8 < e.size(); ++var8) {
            Object[] var9 = (Object[]) e.get(var8);
            int[] var10 = (int[]) var9[0];
            Point var11 = new Point(var7.x - var10[0], var7.y - var10[1]);
            int var12 = Math.abs(var11.x / 2) + Math.abs(var11.y);
            if (var12 < var5 && var12 < var4 && a(var1, (View) var9[1])) {
                var6 = var9;
                var5 = var12;
            }
        }

        return var6;
    }

    public void c() {
        d();
        e = new ArrayList<>();
        f = null;
    }

    public void c(Rs var1) {
        Rs var2 = var1.E;
        if (var2 != null) {
            if (var2 != null) {
                var2.g(var1);
                var1.E = null;
            }

        }
    }

    public void c(Rs rs, int i, int i2) {
        Object[] objArr;
        int intValue;
        getLocationOnScreen(b);
        f = b(rs, i, i2);
        if (rs.b() && -1 == rs.ia) {
            objArr = f;
            if (objArr != null) {
                Rs rs2 = (Rs) objArr[1];
                intValue = ((Integer) objArr[2]).intValue();
                if (intValue == 0) {
                    rs2 = findViewWithTag(Integer.valueOf(rs2.ha));
                } else if (intValue == 2) {
                    rs2 = findViewWithTag(Integer.valueOf(rs2.ia));
                } else if (intValue == 3) {
                    rs2 = findViewWithTag(Integer.valueOf(rs2.ja));
                }
            }
        }
        objArr = f;
        if (objArr != null) {
            int[] iArr = (int[]) objArr[0];
            View view = (View) objArr[1];
            c.setX((float) (iArr[0] - b[0]));
            c.setY((float) (iArr[1] - b[1]));
            c.bringToFront();
            c.setVisibility(View.VISIBLE);
            if (rs.fa) {
                if (view instanceof Rs) {
                    c.a((Rs) view, true, false, 0);
                }
                if (view instanceof Ss) {
                    c.a((Ss) view, true, false, 0);
                    return;
                }
                return;
            }
            int intValue2 = ((Integer) f[2]).intValue();
            intValue = intValue2 == 4 ? ((Rs) view).getHeightSum() : 0;
            boolean z = intValue2 != 1 && intValue2 != 4;
            c.a(rs, false, z, intValue);
            return;
        }
        d();
    }

    public boolean c(String var1) {
        int var2 = getChildCount();

        for (int var3 = 0; var3 < var2; ++var3) {
            View var4 = getChildAt(var3);
            if (var4 instanceof Rs) {
                BlockBean var5;
                byte var7;
                label97:
                {
                    var5 = ((Rs) var4).getBean();
                    String var6 = var5.opCode;
                    switch (var6.hashCode()) {
                        case -2120571577:
                            if (var6.equals("mapIsEmpty")) {
                                var7 = 13;
                                break label97;
                            }
                            break;
                        case -1920517885:
                            if (var6.equals("setVarBoolean")) {
                                var7 = 1;
                                break label97;
                            }
                            break;
                        case -1384858251:
                            if (var6.equals("getAtListMap")) {
                                var7 = 19;
                                break label97;
                            }
                            break;
                        case -1377080719:
                            if (var6.equals("decreaseInt")) {
                                var7 = 5;
                                break label97;
                            }
                            break;
                        case -1249347599:
                            if (var6.equals("getVar")) {
                                var7 = 0;
                                break label97;
                            }
                            break;
                        case -1081400230:
                            if (var6.equals("mapGet")) {
                                var7 = 8;
                                break label97;
                            }
                            break;
                        case -1081391085:
                            if (var6.equals("mapPut")) {
                                var7 = 7;
                                break label97;
                            }
                            break;
                        case -329559323:
                            if (var6.equals("insertListMap")) {
                                var7 = 16;
                                break label97;
                            }
                            break;
                        case 152967761:
                            if (var6.equals("mapClear")) {
                                var7 = 12;
                                break label97;
                            }
                            break;
                        case 168740282:
                            if (var6.equals("mapToStr")) {
                                var7 = 17;
                                break label97;
                            }
                            break;
                        case 442768763:
                            if (var6.equals("mapGetAllKeys")) {
                                var7 = 14;
                                break label97;
                            }
                            break;
                        case 463560551:
                            if (var6.equals("mapContainKey")) {
                                var7 = 9;
                                break label97;
                            }
                            break;
                        case 657721930:
                            if (var6.equals("setVarInt")) {
                                var7 = 2;
                                break label97;
                            }
                            break;
                        case 747168008:
                            if (var6.equals("mapCreateNew")) {
                                var7 = 6;
                                break label97;
                            }
                            break;
                        case 754442829:
                            if (var6.equals("increaseInt")) {
                                var7 = 4;
                                break label97;
                            }
                            break;
                        case 836692861:
                            if (var6.equals("mapSize")) {
                                var7 = 11;
                                break label97;
                            }
                            break;
                        case 845089750:
                            if (var6.equals("setVarString")) {
                                var7 = 3;
                                break label97;
                            }
                            break;
                        case 1431171391:
                            if (var6.equals("mapRemoveKey")) {
                                var7 = 10;
                                break label97;
                            }
                            break;
                        case 1775620400:
                            if (var6.equals("strToMap")) {
                                var7 = 18;
                                break label97;
                            }
                            break;
                        case 2090182653:
                            if (var6.equals("addListMap")) {
                                var7 = 15;
                                break label97;
                            }
                    }

                    var7 = -1;
                }

                switch (var7) {
                    case 0:
                        if (var5.spec.equals(var1)) {
                            return true;
                        }
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        if (var5.parameters.get(0).equals(var1)) {
                            return true;
                        }
                        break;
                    case 18:
                        if (var5.parameters.get(1).equals(var1)) {
                            return true;
                        }
                        break;
                    case 19:
                        if (var5.parameters.get(2).equals(var1)) {
                            return true;
                        }
                }
            }
        }

        return false;
    }

    public void d() {
        c.setVisibility(View.GONE);
    }

    public int getAddTargetId() {
        Object[] var1 = getNearestTarget();
        int var2 = -1;
        if (var1 != null && var1[2] != null) {
            int var3 = ((Integer) var1[2]).intValue();
            if ((var3 == 0 || var3 == 2 || var3 == 3 || var3 == 5) && var1[1] != null) {
                View var4 = (View) var1[1];
                if (var4 instanceof Rs) {
                    Rs var5 = (Rs) var4;
                    if (var5.fa) {
                        var2 = ((Integer) var5.E.getTag()).intValue();
                    } else {
                        var2 = ((Integer) ((Rs) var1[1]).getTag()).intValue();
                    }
                }

                if (var4 instanceof Ss) {
                    var2 = ((Integer) ((Ss) var4).E.getTag()).intValue();
                }
            }
        }

        return var2;
    }

    public ArrayList<BlockBean> getBlocks() {
        ArrayList<BlockBean> var1 = new ArrayList<>();
        Rs var2 = findViewWithTag(Integer.valueOf(d.ha));
        if (var2 != null) {
            for (Rs rs : var2.getAllChildren()) {
                var1.add(rs.getBean());
            }
        }
        return var1;
    }

    public Object[] getNearestTarget() {
        return f;
    }

    public Rs getRoot() {
        return d;
    }
}
