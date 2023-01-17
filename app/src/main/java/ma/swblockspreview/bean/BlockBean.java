package ma.swblockspreview.bean;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import ma.swblockspreview.BlockPreviewer;
import ma.swblockspreview.util.Gx;
import ma.swblockspreview.util.mq;

@SuppressLint("ParcelCreator") // TODO
public class BlockBean extends SelectableBean implements Parcelable {
    /*  public static final Creator CREATOR = new Creator() {
    public BlockBean createFromParcel(Parcel var1) {
        return new BlockBean(var1);
    }

    public BlockBean[] newArray(int var1) {
        return new BlockBean[var1];
    }
};*/
    public Gx classInfo;
    @com.google.gson.annotations.Expose
    public int color;
    @com.google.gson.annotations.Expose
    public String id;
    @com.google.gson.annotations.Expose
    public int nextBlock;
    @com.google.gson.annotations.Expose
    public String opCode;
    public ArrayList paramClassInfo;
    @com.google.gson.annotations.Expose
    public ArrayList parameters;
    @com.google.gson.annotations.Expose
    public String spec;
    @com.google.gson.annotations.Expose
    public int subStack1;
    @com.google.gson.annotations.Expose
    public int subStack2;
    @com.google.gson.annotations.Expose
    public String type;
    @com.google.gson.annotations.Expose
    public String typeName;

    public BlockBean() {
        this.parameters = new ArrayList();
        this.subStack1 = -1;
        this.subStack2 = -1;
        this.nextBlock = -1;
    }

    public BlockBean(Parcel var1) {
        this.id = var1.readString();
        this.spec = var1.readString();
        this.type = var1.readString();
        this.typeName = var1.readString();
        this.opCode = var1.readString();
        this.color = var1.readInt();
        this.parameters = (ArrayList) var1.readSerializable();
        this.subStack1 = var1.readInt();
        this.subStack2 = var1.readInt();
        this.nextBlock = var1.readInt();
        this.buildClassInfo();
    }

    public BlockBean(String var1, String var2, String var3, String var4) {
        this(var1, var2, var3, "", var4);
    }

    public BlockBean(String var1, String var2, String var3, String var4, String var5) {
        this.id = var1;
        this.spec = var2;
        this.type = var3;
        this.typeName = var4;
        this.opCode = var5;
        this.parameters = new ArrayList();
        this.subStack1 = -1;
        this.subStack2 = -1;
        this.nextBlock = -1;
        this.buildClassInfo();
    }

    private void buildClassInfo() {
        this.classInfo = mq.a(this.type, this.typeName);
        this.paramClassInfo = mq.a(this.spec);
    }

    /*    public static Creator getCreator() {
    return CREATOR;
}
*/
    public BlockBean clone() {
        BlockBean var1 = new BlockBean();
        var1.copy(this);
        return var1;
    }

    public void copy(BlockBean var1) {
        this.id = var1.id;
        this.spec = var1.spec;
        this.type = var1.type;
        this.typeName = var1.typeName;
        this.opCode = var1.opCode;
        this.color = var1.color;
        this.parameters = new ArrayList(var1.parameters);
        this.subStack1 = var1.subStack1;
        this.subStack2 = var1.subStack2;
        this.nextBlock = var1.nextBlock;
        this.buildClassInfo();
    }

    public int describeContents() {
        return 0;
    }

    public Gx getClassInfo() {
        if (this.classInfo == null) {
            this.buildClassInfo();
        }

        return this.classInfo;
    }

    public ArrayList getParamClassInfo() {
        if (this.paramClassInfo == null) {
            this.buildClassInfo();
        }

        return this.paramClassInfo;
    }

    public boolean isEqual(BlockBean var1) {
        if (var1 == null) {
            return false;
        } else {
            String var2 = this.id;
            if (var2 != null && !var2.equals(var1.id)) {
                return false;
            } else {
                String var3 = this.spec;
                if (var3 != null && !var3.equals(var1.spec)) {
                    return false;
                } else if (!this.type.equals(var1.type)) {
                    return false;
                } else {
                    String var4 = this.typeName;
                    if (var4 != null && !var4.equals(var1.typeName)) {
                        return false;
                    } else if (!this.opCode.equals(var1.opCode)) {
                        return false;
                    } else if (this.color != var1.color) {
                        return false;
                    } else if (this.subStack1 != var1.subStack1) {
                        return false;
                    } else if (this.subStack2 != var1.subStack2) {
                        return false;
                    } else if (this.nextBlock != var1.nextBlock) {
                        return false;
                    } else {
                        ArrayList var5 = this.parameters;
                        if (var5 != null && var5.size() != var1.parameters.size()) {
                            return false;
                        } else {
                            for (int var6 = 0; var6 < this.parameters.size(); ++var6) {
                                String var7 = (String) this.parameters.get(var6);
                                String var8 = (String) var1.parameters.get(var6);
                                if (var7 != null && !var7.equals(var8)) {
                                    return false;
                                }
                            }

                            return true;
                        }
                    }
                }
            }
        }
    }

    public void print() {
    }

    public void writeToParcel(Parcel var1, int var2) {
        var1.writeString(this.id);
        var1.writeString(this.spec);
        var1.writeString(this.type);
        var1.writeString(this.typeName);
        var1.writeString(this.opCode);
        var1.writeInt(this.color);
        var1.writeSerializable(this.parameters);
        var1.writeInt(this.subStack1);
        var1.writeInt(this.subStack2);
        var1.writeInt(this.nextBlock);
    }
}
