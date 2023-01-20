package ma.swblockspreview.bean;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

import ma.swblockspreview.util.Gx;
import ma.swblockspreview.util.mq;

public class BlockBean {
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

}
