package ma.swblockspreview.util;

import ma.swblockspreview.BlockPreviewer;

public class Gx {
    public String a;
    public String[] b;

    public Gx(String var1) {
        a = var1;
        b = null;
        e();
    }

    public String a() {
        return a;
    }

    public boolean a(Gx var1) {
        return a(var1.a);
    }

    public boolean a(String var1) {
        if (var1.equals(a)) {
            return true;
        } else {
            String[] var2 = b;
            int var3 = var2.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                if (var2[var4].equals(var1)) {
                    return true;
                }
            }

            return false;
        }
    }

    public boolean b() {
        return a("List");
    }

    public boolean b(String var1) {
        return a.equals(var1);
    }

    public boolean c() {
        return a("Var");
    }

    public boolean d() {
        return a("View");
    }

    public final void e() {
        String var2;
        String var4;
        byte var5;
        label209:
        {
            String var1 = a;
            var2 = BV.a(var1);
            int var3 = var1.hashCode();
            var4 = "View";
            switch (var3) {
                case -2099895620:
                    if (var1.equals("Intent")) {
                        var5 = 26;
                        break label209;
                    }
                    break;
                case -1965257499:
                    if (var1.equals("Gyroscope")) {
                        var5 = 37;
                        break label209;
                    }
                    break;
                case -1936496017:
                    if (var1.equals("ListString")) {
                        var5 = 5;
                        break label209;
                    }
                    break;
                case -1908172204:
                    if (var1.equals("FirebaseStorage")) {
                        var5 = 38;
                        break label209;
                    }
                    break;
                case -1884914774:
                    if (var1.equals("TextToSpeech")) {
                        var5 = 43;
                        break label209;
                    }
                    break;
                case -1808118735:
                    if (var1.equals("String")) {
                        var5 = 2;
                        break label209;
                    }
                    break;
                case -1805606060:
                    if (var1.equals("Switch")) {
                        var5 = 17;
                        break label209;
                    }
                    break;
                case -1793532415:
                    if (var1.equals("MapView")) {
                        var5 = 21;
                        break label209;
                    }
                    break;
                case -1495589242:
                    if (var1.equals("ProgressBar")) {
                        var5 = 42;
                        break label209;
                    }
                    break;
                case -1406842887:
                    if (var1.equals("WebView")) {
                        var5 = 16;
                        break label209;
                    }
                    break;
                case -1325958191:
                    if (var1.equals("double")) {
                        var5 = 1;
                        break label209;
                    }
                    break;
                case -1125439882:
                    if (var1.equals("HorizontalScrollView")) {
                        var5 = 25;
                        break label209;
                    }
                    break;
                case -1042830870:
                    if (var1.equals("SpeechToText")) {
                        var5 = 44;
                        break label209;
                    }
                    break;
                case -1014653761:
                    if (var1.equals("RequestNetwork")) {
                        var5 = 41;
                        break label209;
                    }
                    break;
                case -938935918:
                    if (var1.equals("TextView")) {
                        var5 = 9;
                        break label209;
                    }
                    break;
                case -658531749:
                    if (var1.equals("SeekBar")) {
                        var5 = 18;
                        break label209;
                    }
                    break;
                case -596330166:
                    if (var1.equals("FilePicker")) {
                        var5 = 40;
                        break label209;
                    }
                    break;
                case -339785223:
                    if (var1.equals("Spinner")) {
                        var5 = 14;
                        break label209;
                    }
                    break;
                case -294086120:
                    if (var1.equals("LocationManager")) {
                        var5 = 46;
                        break label209;
                    }
                    break;
                case -188272861:
                    if (var1.equals("CalendarView")) {
                        var5 = 19;
                        break label209;
                    }
                    break;
                case -113680546:
                    if (var1.equals("Calendar")) {
                        var5 = 28;
                        break label209;
                    }
                    break;
                case 77116:
                    if (var1.equals("Map")) {
                        var5 = 3;
                        break label209;
                    }
                    break;
                case 2368702:
                    if (var1.equals("List")) {
                        var5 = 7;
                        break label209;
                    }
                    break;
                case 2666181:
                    if (var1.equals(var4)) {
                        var5 = 8;
                        break label209;
                    }
                    break;
                case 64711720:
                    if (var1.equals("boolean")) {
                        var5 = 0;
                        break label209;
                    }
                    break;
                case 80811813:
                    if (var1.equals("Timer")) {
                        var5 = 30;
                        break label209;
                    }
                    break;
                case 191354283:
                    if (var1.equals("SoundPool")) {
                        var5 = 33;
                        break label209;
                    }
                    break;
                case 225459311:
                    if (var1.equals("FirebaseAuth")) {
                        var5 = 36;
                        break label209;
                    }
                    break;
                case 1100433486:
                    if (var1.equals("FloatingActionButton")) {
                        var5 = 22;
                        break label209;
                    }
                    break;
                case 1125864064:
                    if (var1.equals("ImageView")) {
                        var5 = 12;
                        break label209;
                    }
                    break;
                case 1127291599:
                    if (var1.equals("LinearLayout")) {
                        var5 = 23;
                        break label209;
                    }
                    break;
                case 1170382393:
                    if (var1.equals("Vibrator")) {
                        var5 = 29;
                        break label209;
                    }
                    break;
                case 1236935621:
                    if (var1.equals("MediaPlayer")) {
                        var5 = 32;
                        break label209;
                    }
                    break;
                case 1410352259:
                    if (var1.equals("ListView")) {
                        var5 = 15;
                        break label209;
                    }
                    break;
                case 1512362620:
                    if (var1.equals("BluetoothConnect")) {
                        var5 = 45;
                        break label209;
                    }
                    break;
                case 1601505219:
                    if (var1.equals("CheckBox")) {
                        var5 = 13;
                        break label209;
                    }
                    break;
                case 1616304435:
                    if (var1.equals("SharedPreferences")) {
                        var5 = 27;
                        break label209;
                    }
                    break;
                case 1666676343:
                    if (var1.equals("EditText")) {
                        var5 = 11;
                        break label209;
                    }
                    break;
                case 1779003621:
                    if (var1.equals("FirebaseDB")) {
                        var5 = 35;
                        break label209;
                    }
                    break;
                case 1799376742:
                    if (var1.equals("ObjectAnimator")) {
                        var5 = 34;
                        break label209;
                    }
                    break;
                case 1846598225:
                    if (var1.equals("ListInt")) {
                        var5 = 4;
                        break label209;
                    }
                    break;
                case 1846601662:
                    if (var1.equals("ListMap")) {
                        var5 = 6;
                        break label209;
                    }
                    break;
                case 1955913096:
                    if (var1.equals("AdView")) {
                        var5 = 20;
                        break label209;
                    }
                    break;
                case 2001146706:
                    if (var1.equals("Button")) {
                        var5 = 10;
                        break label209;
                    }
                    break;
                case 2011082565:
                    if (var1.equals("Camera")) {
                        var5 = 39;
                        break label209;
                    }
                    break;
                case 2046749032:
                    if (var1.equals("Dialog")) {
                        var5 = 31;
                        break label209;
                    }
                    break;
                case 2059813682:
                    if (var1.equals("ScrollView")) {
                        var5 = 24;
                        break label209;
                    }
                    break;
                case 2059883587:
                    if (var1.equals("RadioButton")) {
                        var5 = 47;
                        break label209;
                    }
            }

            var5 = -1;
        }

        switch (var5) {
            case 0:
                var4 = "Var.boolean";
                break;
            case 1:
                var4 = "Var.double";
                break;
            case 2:
                var4 = "Var.String";
                break;
            case 3:
                var4 = "Var.Map";
                break;
            case 4:
                var4 = "List.ListInt";
                break;
            case 5:
                var4 = "List.ListString";
                break;
            case 6:
                var4 = "List.ListMap";
                break;
            case 7:
                var4 = "List";
            case 8:
                break;
            case 9:
                var4 = "View.Clickable.TextView";
                break;
            case 10:
                var4 = "View.Clickable.TextView.Button";
                break;
            case 11:
                var4 = "View.Clickable.TextView.EditText";
                break;
            case 12:
                var4 = "View.Clickable.ImageView";
                break;
            case 13:
                var4 = "View.Clickable.TextView.Button.CompoundButton.CheckBox";
                break;
            case 14:
                var4 = "View.AdapterView.AbsSpinner.Spinner";
                break;
            case 15:
                var4 = "View.AdapterView.AbsListView.ListView";
                break;
            case 16:
                var4 = "View.AbsoluteLayout.WebView";
                break;
            case 17:
                var4 = "View.Clickable.TextView.Button.CompoundButton.Switch";
                break;
            case 18:
                var4 = "View.SeekBar";
                break;
            case 19:
                var4 = "View.FrameLayout.CalendarView";
                break;
            case 20:
                var4 = "View.AdView";
                break;
            case 21:
                var4 = "View.MapView";
                break;
            case 22:
                var4 = "View.Clickable.FloatingActionButton";
                break;
            case 23:
                var4 = "View.Clickable.ViewGroup.LinearLayout";
                break;
            case 24:
                var4 = "View.ViewGroup.FrameLayout.ScrollView";
                break;
            case 25:
                var4 = "View.ViewGroup.FrameLayout.HorizontalScrollView";
                break;
            case 26:
                var4 = "Component.Intent";
                break;
            case 27:
                var4 = "Component.SharedPreferences";
                break;
            case 28:
                var4 = "Component.Calendar";
                break;
            case 29:
                var4 = "Component.Vibrator";
                break;
            case 30:
                var4 = "Component.Timer";
                break;
            case 31:
                var4 = "Component.Dialog";
                break;
            case 32:
                var4 = "Component.MediaPlayer";
                break;
            case 33:
                var4 = "Component.SoundPool";
                break;
            case 34:
                var4 = "Component.ObjectAnimator";
                break;
            case 35:
                var4 = "Component.FirebaseDB";
                break;
            case 36:
                var4 = "Component.FirebaseAuth";
                break;
            case 37:
                var4 = "Component.Gyroscope";
                break;
            case 38:
                var4 = "Component.FirebaseStorage";
                break;
            case 39:
                var4 = "Component.Camera";
                break;
            case 40:
                var4 = "Component.FilePicker";
                break;
            case 41:
                var4 = "Component.RequestNetwork";
                break;
            case 42:
                var4 = "View.SeekBar.ProgressBar";
                break;
            case 43:
                var4 = "Component.TextToSpeech";
                break;
            case 44:
                var4 = "Component.SpeechToText";
                break;
            case 45:
                var4 = "Component.BluetoothConnect";
                break;
            case 46:
                var4 = "Component.LocationManager";
                break;
            case 47:
                var4 = "View.Clickable.TextView.Button.CompoundButton.RadioButton";
                break;
            default:
                var4 = var2;
        }

        b = var4.split("\\.");
    }
}
