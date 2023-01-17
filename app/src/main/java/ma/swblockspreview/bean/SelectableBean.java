package ma.swblockspreview.bean;

public class SelectableBean extends nA {
    public static final int SAVED_POS_ETC = 2;
    public static final int SAVED_POS_NONE = -1;
    public static final int SAVED_POS_SKETCHWARE_DATA = 0;
    public static final int SAVED_POS_STORAGE = 1;
    public boolean isNew;
    public boolean isSelected;
    public int savedPos;

    public SelectableBean() {
        this(-1);
    }

    public SelectableBean(int var1) {
        this(var1, false);
    }

    public SelectableBean(int var1, boolean var2) {
        this.savedPos = -1;
        this.isSelected = false;
        this.isNew = false;
        this.isSelected = false;
        this.savedPos = var1;
        this.isNew = var2;
    }
}
