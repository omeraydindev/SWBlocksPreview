package ma.swblockspreview.util;

import java.util.ArrayList;

public class mq {

    public static Gx a(String type, String typeName) {
        switch (type) {
            case "b":
                return new Gx("boolean");

            case "d":
            case "n":
                return new Gx("double");

            case "s":
                if ("inputOnly".equals(typeName)) {
                    return new Gx("Input");
                }
                return new Gx("String");

            case "a":
                return new Gx("Map");

            case "l":
                switch (typeName) {
                    case "List Map":
                        return new Gx("ListMap");

                    case "List String":
                        return new Gx("ListString");

                    case "List Number":
                        return new Gx("ListInt");
                }

            case "v":
                return new Gx(typeName);

            case "p":
            case "m":
                return new Gx(b(typeName));

            default:
                return null;
        }
    }


    public static String b(String name) {
        switch (name) {
            case "intent":
            case "Intent":
                return "Intent";

            case "file":
            case "File":
            case "File (Shared Preferences)":
                return "SharedPreferences";

            case "calendar":
            case "Calendar":
                return "Calendar";

            case "vibrator":
            case "Vibrator":
                return "Vibrator";

            case "Timer":
                return "Timer";

            case "dialog":
            case "Dialog":
                return "Dialog";

            case "MediaPlayer":
                return "MediaPlayer";

            case "SoundPool":
                return "SoundPool";

            case "ObjectAnimator":
                return "ObjectAnimator";

            case "firebase":
            case "Firebase":
            case "Firebase DB":
                return "FirebaseDB";

            case "firebaseauth":
            case "Firebase Auth":
                return "FirebaseAuth";

            case "gyroscope":
            case "Gyroscope":
                return "Gyroscope";

            case "InterstitialAd":
                return "InterstitialAd";

            case "varBool":
                return "boolean.SelectBoolean";

            case "varInt":
                return "double.SelectDouble";

            case "varStr":
                return "String.SelectString";

            case "varMap":
                return "Map";

            case "listInt":
                return "ListInt";

            case "listStr":
                return "ListString";

            case "listMap":
                return "ListMap";

            case "list":
                return "List";

            case "view":
                return "View";

            case "textview":
                return "TextView";

            case "edittext":
                return "EditText";

            case "imageview":
                return "ImageView";

            case "compoundButton":
                return "CompoundButton";

            case "checkbox":
                return "CheckBox";

            case "switch":
                return "Switch";

            case "listSpn":
                return "AdapterView";

            case "listview":
                return "ListView";

            case "spinner":
                return "Spinner";

            case "webview":
                return "WebView";

            case "calendarview":
                return "CalendarView";

            case "adview":
                return "AdView";

            case "mapview":
                return "MapView";

            case "timer":
                return "Timer";

            case "mediaplayer":
                return "MediaPlayer";

            case "soundpool":
                return "SoundPool";

            case "objectanimator":
                return "ObjectAnimator";

            case "seekbar":
                return "SeekBar";

            case "interstitialad":
                return "InterstitialAd";

            case "firebasestorage":
                return "FirebaseStorage";

            case "camera":
                return "Camera";

            case "filepicker":
                return "FilePicker";

            case "requestnetwork":
                return "RequestNetwork";

            case "progressbar":
                return "ProgressBar";

            case "texttospeech":
                return "TextToSpeech";

            case "speechtotext":
                return "SpeechToText";

            case "bluetoothconnect":
                return "BluetoothConnect";

            case "locationmanager":
                return "LocationManager";

            case "radiobutton":
                return "RadioButton";

            case "ratingbar":
                return "RatingBar";

            case "videoview":
                return "VideoView";

            case "searchview":
                return "SearchView";

            case "gridview":
                return "GridView";

            case "actv":
                return "AutoCompleteTextView";

            case "mactv":
                return "MultiAutoCompleteTextView";

            case "tablayout":
                return "TabLayout";

            case "viewpager":
                return "ViewPager";

            case "badgeview":
                return "BadgeView";

            case "bottomnavigation":
                return "BottomNavigationView";

            case "patternview":
                return "PatternLockView";

            case "sidebar":
                return "WaveSideBar";

            default:
                return name;
        }
    }

    public static ArrayList<Gx> a(String spec) {
        ArrayList<Gx> paramClass = new ArrayList<>();
        ArrayList<String> specList = StringUtils.c(spec);
        for (String params : specList) {
            if (params.charAt(0) == '%' && params.length() >= 2) {
                String type = String.valueOf(params.charAt(1));
                String typeName;
                if (params.length() > 3) {
                    typeName = params.substring(3);
                } else {
                    typeName = "";
                }
                paramClass.add(a(type, typeName));
            }
        }
        return paramClass;
    }
}