package ma.swblockspreview.bean;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

import ma.swblockspreview.util.Gx;
import ma.swblockspreview.util.mq;

@SuppressLint("ParcelCreator") // TODO
public class BlockBean extends SelectableBean implements Parcelable {
    /*public static final Creator CREATOR = new Creator() {
        public BlockBean createFromParcel(Parcel var1) {
            return new BlockBean(var1);
        }

        public BlockBean[] newArray(int var1) {
            return new BlockBean[var1];
        }
    };*/
    public Gx classInfo;
    @Expose
    public int color;
    @Expose
    public String id;
    @Expose
    public int nextBlock;
    @Expose
    public String opCode;
    public ArrayList<Gx> paramClassInfo;
    @Expose
    public ArrayList<String> parameters;
    @Expose
    public String spec;
    @Expose
    public int subStack1;
    @Expose
    public int subStack2;
    @Expose
    public String type;
    @Expose
    public String typeName;

    public BlockBean() {
        parameters = new ArrayList<>();
        subStack1 = -1;
        subStack2 = -1;
        nextBlock = -1;
    }

    public BlockBean(Parcel var1) {
        id = var1.readString();
        spec = var1.readString();
        type = var1.readString();
        typeName = var1.readString();
        opCode = var1.readString();
        color = var1.readInt();
        parameters = (ArrayList) var1.readSerializable();
        subStack1 = var1.readInt();
        subStack2 = var1.readInt();
        nextBlock = var1.readInt();
        buildClassInfo();
    }

    public BlockBean(String var1, String var2, String var3, String var4) {
        this(var1, var2, var3, "", var4);
    }

    public BlockBean(String var1, String var2, String var3, String var4, String var5) {
        id = var1;
        spec = var2;
        type = var3;
        typeName = var4;
        opCode = var5;
        parameters = new ArrayList<>();
        subStack1 = -1;
        subStack2 = -1;
        nextBlock = -1;
        buildClassInfo();
    }

    private void buildClassInfo() {
        classInfo = mq.a(type, typeName);
        paramClassInfo = mq.a(spec);
    }

    /*public static Creator getCreator() {
        return CREATOR;
    }*/
    public BlockBean clone() {
        BlockBean var1 = new BlockBean();
        var1.copy(this);
        return var1;
    }

    public void copy(BlockBean var1) {
        id = var1.id;
        spec = var1.spec;
        type = var1.type;
        typeName = var1.typeName;
        opCode = var1.opCode;
        color = var1.color;
        parameters = new ArrayList<>(var1.parameters);
        subStack1 = var1.subStack1;
        subStack2 = var1.subStack2;
        nextBlock = var1.nextBlock;
        buildClassInfo();
    }

    public int describeContents() {
        return 0;
    }

    public Gx getClassInfo() {
        if (classInfo == null) {
            buildClassInfo();
        }

        return classInfo;
    }

    public ArrayList getParamClassInfo() {
        if (paramClassInfo == null) {
            buildClassInfo();
        }

        return paramClassInfo;
    }

    public boolean isEqual(BlockBean other) {
        if (other == null) {
            return false;
        } else {
            String var2 = id;
            if (var2 != null && !var2.equals(other.id)) {
                return false;
            } else {
                String var3 = spec;
                if (var3 != null && !var3.equals(other.spec)) {
                    return false;
                } else if (!type.equals(other.type)) {
                    return false;
                } else {
                    String var4 = typeName;
                    if (var4 != null && !var4.equals(other.typeName)) {
                        return false;
                    } else if (!opCode.equals(other.opCode)) {
                        return false;
                    } else if (color != other.color) {
                        return false;
                    } else if (subStack1 != other.subStack1) {
                        return false;
                    } else if (subStack2 != other.subStack2) {
                        return false;
                    } else if (nextBlock != other.nextBlock) {
                        return false;
                    } else {
                        ArrayList<String> var5 = parameters;
                        if (var5 != null && var5.size() != other.parameters.size()) {
                            return false;
                        } else {
                            for (int var6 = 0; var6 < parameters.size(); ++var6) {
                                String var7 = parameters.get(var6);
                                String var8 = other.parameters.get(var6);
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
        var1.writeString(id);
        var1.writeString(spec);
        var1.writeString(type);
        var1.writeString(typeName);
        var1.writeString(opCode);
        var1.writeInt(color);
        var1.writeSerializable(parameters);
        var1.writeInt(subStack1);
        var1.writeInt(subStack2);
        var1.writeInt(nextBlock);
    }
}
