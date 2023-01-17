package ma.swblockspreview.util;

import java.util.ArrayList;
import java.util.Iterator;

public class mq {
    public static Gx a(String var0, String var1) {
        byte var3;
        label105:
        {
            int var2 = var0.hashCode();
            if (var2 != 97) {
                if (var2 != 98) {
                    if (var2 != 100) {
                        if (var2 != 112) {
                            if (var2 != 115) {
                                if (var2 != 118) {
                                    switch (var2) {
                                        case 108:
                                            if (var0.equals("l")) {
                                                var3 = 5;
                                                break label105;
                                            }
                                            break;
                                        case 109:
                                            if (var0.equals("m")) {
                                                var3 = 8;
                                                break label105;
                                            }
                                            break;
                                        case 110:
                                            if (var0.equals("n")) {
                                                var3 = 2;
                                                break label105;
                                            }
                                    }
                                } else if (var0.equals("v")) {
                                    var3 = 6;
                                    break label105;
                                }
                            } else if (var0.equals("s")) {
                                var3 = 3;
                                break label105;
                            }
                        } else if (var0.equals("p")) {
                            var3 = 7;
                            break label105;
                        }
                    } else if (var0.equals("d")) {
                        var3 = 1;
                        break label105;
                    }
                } else if (var0.equals("b")) {
                    var3 = 0;
                    break label105;
                }
            } else if (var0.equals("a")) {
                var3 = 4;
                break label105;
            }

            var3 = -1;
        }

        switch (var3) {
            case 0:
                return new Gx("boolean");
            case 1:
            case 2:
                return new Gx("double");
            case 3:
                if (var1 != null && var1.length() > 0) {
                    if (var1.toLowerCase().equals("inputonly")) {
                        return new Gx("Input");
                    }

                    return new Gx("String");
                }

                return new Gx("String");
            case 4:
                return new Gx("Map");
            case 5:
                int var4 = var1.hashCode();
                byte var5;
                if (var4 != 995088651) {
                    if (var4 != 1137466835) {
                        if (var4 == 1408716506 && var1.equals("List Map")) {
                            var5 = 2;
                            return var5 != 0 ? (var5 != 1 ? (var5 != 2 ? null : new Gx("ListMap")) : new Gx("ListString")) : new Gx("ListInt");
                        }
                    } else if (var1.equals("List String")) {
                        var5 = 1;
                        return var5 != 0 ? (var5 != 1 ? (var5 != 2 ? null : new Gx("ListMap")) : new Gx("ListString")) : new Gx("ListInt");
                    }
                } else if (var1.equals("List Number")) {
                    var5 = 0;
                    return var5 != 0 ? (var5 != 1 ? (var5 != 2 ? null : new Gx("ListMap")) : new Gx("ListString")) : new Gx("ListInt");
                }

                var5 = -1;
                return var5 != 0 ? (var5 != 1 ? (var5 != 2 ? null : new Gx("ListMap")) : new Gx("ListString")) : new Gx("ListInt");
            case 6:
                return new Gx(var1);
            case 7:
            case 8:
                return new Gx(b(var1));
            default:
                return null;
        }
    }


    public static String b(String var0) {
        byte var1;
        label252:
        {
            switch (var0.hashCode()) {
                case -2099895620:
                    if (var0.equals("Intent")) {
                        var1 = 0;
                        break label252;
                    }
                    break;
                case -2004438503:
                    if (var0.equals("spinner")) {
                        var1 = 32;
                        break label252;
                    }
                    break;
                case -1965257499:
                    if (var0.equals("Gyroscope")) {
                        var1 = 13;
                        break label252;
                    }
                    break;
                case -1811660373:
                    if (var0.equals("soundpool")) {
                        var1 = 44;
                        break label252;
                    }
                    break;
                case -1677313857:
                    if (var0.equals("requestnetwork")) {
                        var1 = 54;
                        break label252;
                    }
                    break;
                case -1673662198:
                    if (var0.equals("filepicker")) {
                        var1 = 53;
                        break label252;
                    }
                    break;
                case -1632719839:
                    if (var0.equals("Firebase Auth")) {
                        var1 = 12;
                        break label252;
                    }
                    break;
                case -1587760963:
                    if (var0.equals("compoundButton")) {
                        var1 = 27;
                        break label252;
                    }
                    break;
                case -1558241498:
                    if (var0.equals("objectanimator")) {
                        var1 = 45;
                        break label252;
                    }
                    break;
                case -1421968056:
                    if (var0.equals("adview")) {
                        var1 = 35;
                        break label252;
                    }
                    break;
                case -1367751899:
                    if (var0.equals("camera")) {
                        var1 = 52;
                        break label252;
                    }
                    break;
                case -1332085432:
                    if (var0.equals("dialog")) {
                        var1 = 42;
                        break label252;
                    }
                    break;
                case -1197746358:
                    if (var0.equals("texttospeech")) {
                        var1 = 56;
                        break label252;
                    }
                    break;
                case -1183762788:
                    if (var0.equals("intent")) {
                        var1 = 37;
                        break label252;
                    }
                    break;
                case -1002626734:
                    if (var0.equals("textview")) {
                        var1 = 24;
                        break label252;
                    }
                    break;
                case -961721768:
                    if (var0.equals("locationmanager")) {
                        var1 = 59;
                        break label252;
                    }
                    break;
                case -889473228:
                    if (var0.equals("switch")) {
                        var1 = 29;
                        break label252;
                    }
                    break;
                case -877150592:
                    if (var0.equals("imageview")) {
                        var1 = 26;
                        break label252;
                    }
                    break;
                case -823676088:
                    if (var0.equals("varInt")) {
                        var1 = 16;
                        break label252;
                    }
                    break;
                case -823672651:
                    if (var0.equals("varMap")) {
                        var1 = 18;
                        break label252;
                    }
                    break;
                case -823666294:
                    if (var0.equals("varStr")) {
                        var1 = 17;
                        break label252;
                    }
                    break;
                case -685497065:
                    if (var0.equals("Firebase DB")) {
                        var1 = 10;
                        break label252;
                    }
                    break;
                case -563351033:
                    if (var0.equals("firebase")) {
                        var1 = 46;
                        break label252;
                    }
                    break;
                case -498706905:
                    if (var0.equals("Firebase")) {
                        var1 = 11;
                        break label252;
                    }
                    break;
                case -351639837:
                    if (var0.equals("calendarview")) {
                        var1 = 34;
                        break label252;
                    }
                    break;
                case -290065014:
                    if (var0.equals("speechtotext")) {
                        var1 = 57;
                        break label252;
                    }
                    break;
                case -178324674:
                    if (var0.equals("calendar")) {
                        var1 = 39;
                        break label252;
                    }
                    break;
                case -113680546:
                    if (var0.equals("Calendar")) {
                        var1 = 3;
                        break label252;
                    }
                    break;
                case 2189724:
                    if (var0.equals("File")) {
                        var1 = 2;
                        break label252;
                    }
                    break;
                case 3143036:
                    if (var0.equals("file")) {
                        var1 = 38;
                        break label252;
                    }
                    break;
                case 3322014:
                    if (var0.equals("list")) {
                        var1 = 22;
                        break label252;
                    }
                    break;
                case 3619493:
                    if (var0.equals("view")) {
                        var1 = 23;
                        break label252;
                    }
                    break;
                case 62092335:
                    if (var0.equals("firebaseauth")) {
                        var1 = 47;
                        break label252;
                    }
                    break;
                case 80811813:
                    if (var0.equals("Timer")) {
                        var1 = 5;
                        break label252;
                    }
                    break;
                case 110364485:
                    if (var0.equals("timer")) {
                        var1 = 41;
                        break label252;
                    }
                    break;
                case 181944945:
                    if (var0.equals("listInt")) {
                        var1 = 19;
                        break label252;
                    }
                    break;
                case 181948382:
                    if (var0.equals("listMap")) {
                        var1 = 21;
                        break label252;
                    }
                    break;
                case 181954611:
                    if (var0.equals("listSpn")) {
                        var1 = 30;
                        break label252;
                    }
                    break;
                case 181954739:
                    if (var0.equals("listStr")) {
                        var1 = 20;
                        break label252;
                    }
                    break;
                case 191354283:
                    if (var0.equals("SoundPool")) {
                        var1 = 8;
                        break label252;
                    }
                    break;
                case 235637425:
                    if (var0.equals("varBool")) {
                        var1 = 15;
                        break label252;
                    }
                    break;
                case 320151695:
                    if (var0.equals("InterstitialAd")) {
                        var1 = 14;
                        break label252;
                    }
                    break;
                case 325741829:
                    if (var0.equals("gyroscope")) {
                        var1 = 49;
                        break label252;
                    }
                    break;
                case 400845544:
                    if (var0.equals("File (Shared Preferences)")) {
                        var1 = 1;
                        break label252;
                    }
                    break;
                case 485199813:
                    if (var0.equals("mediaplayer")) {
                        var1 = 43;
                        break label252;
                    }
                    break;
                case 690484860:
                    if (var0.equals("bluetoothconnect")) {
                        var1 = 58;
                        break label252;
                    }
                    break;
                case 837734913:
                    if (var0.equals("mapview")) {
                        var1 = 36;
                        break label252;
                    }
                    break;
                case 1105738265:
                    if (var0.equals("vibrator")) {
                        var1 = 40;
                        break label252;
                    }
                    break;
                case 1131540166:
                    if (var0.equals("progressbar")) {
                        var1 = 55;
                        break label252;
                    }
                    break;
                case 1170382393:
                    if (var0.equals("Vibrator")) {
                        var1 = 4;
                        break label252;
                    }
                    break;
                case 1224424441:
                    if (var0.equals("webview")) {
                        var1 = 33;
                        break label252;
                    }
                    break;
                case 1236935621:
                    if (var0.equals("MediaPlayer")) {
                        var1 = 7;
                        break label252;
                    }
                    break;
                case 1322145871:
                    if (var0.equals("interstitialad")) {
                        var1 = 50;
                        break label252;
                    }
                    break;
                case 1346661443:
                    if (var0.equals("listview")) {
                        var1 = 31;
                        break label252;
                    }
                    break;
                case 1536891843:
                    if (var0.equals("checkbox")) {
                        var1 = 28;
                        break label252;
                    }
                    break;
                case 1602985527:
                    if (var0.equals("edittext")) {
                        var1 = 25;
                        break label252;
                    }
                    break;
                case 1719159444:
                    if (var0.equals("firebasestorage")) {
                        var1 = 51;
                        break label252;
                    }
                    break;
                case 1799376742:
                    if (var0.equals("ObjectAnimator")) {
                        var1 = 9;
                        break label252;
                    }
                    break;
                case 1971813019:
                    if (var0.equals("seekbar")) {
                        var1 = 48;
                        break label252;
                    }
                    break;
                case 2046749032:
                    if (var0.equals("Dialog")) {
                        var1 = 6;
                        break label252;
                    }
            }

            var1 = -1;
        }

        switch (var1) {
            case 0:
                return "Intent";
            case 1:
            case 2:
                return "SharedPreferences";
            case 3:
                return "Calendar";
            case 4:
                return "Vibrator";
            case 5:
                return "Timer";
            case 6:
                return "Dialog";
            case 7:
                return "MediaPlayer";
            case 8:
                return "SoundPool";
            case 9:
                return "ObjectAnimator";
            case 10:
            case 11:
                return "FirebaseDB";
            case 12:
                return "FirebaseAuth";
            case 13:
                return "Gyroscope";
            case 14:
                return "InterstitialAd";
            case 15:
                return "boolean.SelectBoolean";
            case 16:
                return "double.SelectDouble";
            case 17:
                return "String.SelectString";
            case 18:
                return "Map";
            case 19:
                return "ListInt";
            case 20:
                return "ListString";
            case 21:
                return "ListMap";
            case 22:
                return "List";
            case 23:
                return "View";
            case 24:
                return "TextView";
            case 25:
                return "EditText";
            case 26:
                return "ImageView";
            case 27:
                return "CompoundButton";
            case 28:
                return "CheckBox";
            case 29:
                return "Switch";
            case 30:
                return "AdapterView";
            case 31:
                return "ListView";
            case 32:
                return "Spinner";
            case 33:
                return "WebView";
            case 34:
                return "CalendarView";
            case 35:
                return "AdView";
            case 36:
                return "MapView";
            case 37:
                return "Intent";
            case 38:
                return "SharedPreferences";
            case 39:
                return "Calendar";
            case 40:
                return "Vibrator";
            case 41:
                return "Timer";
            case 42:
                return "Dialog";
            case 43:
                return "MediaPlayer";
            case 44:
                return "SoundPool";
            case 45:
                return "ObjectAnimator";
            case 46:
                return "FirebaseDB";
            case 47:
                return "FirebaseAuth";
            case 48:
                return "SeekBar";
            case 49:
                return "Gyroscope";
            case 50:
                return "InterstitialAd";
            case 51:
                return "FirebaseStorage";
            case 52:
                return "Camera";
            case 53:
                return "FilePicker";
            case 54:
                return "RequestNetwork";
            case 55:
                return "ProgressBar";
            case 56:
                return "TextToSpeech";
            case 57:
                return "SpeechToText";
            case 58:
                return "BluetoothConnect";
            case 59:
                return "LocationManager";
            default:
                return var0;
        }
    }

    public static ArrayList a(String var0) {
        ArrayList var1 = new ArrayList();
        ArrayList var2 = FB.c(var0);
        if (var2.size() <= 0) {
            return var1;
        } else {
            Iterator var3 = var2.iterator();

            while (var3.hasNext()) {
                String var4 = (String) var3.next();
                if (var4.charAt(0) == 37 && var4.length() >= 2) {
                    String var5 = String.valueOf(var4.charAt(1));
                    String var6;
                    if (var4.length() > 3) {
                        var6 = var4.substring(3);
                    } else {
                        var6 = "";
                    }

                    var1.add(a(var5, var6));
                }
            }

            return var1;
        }
    }
}
