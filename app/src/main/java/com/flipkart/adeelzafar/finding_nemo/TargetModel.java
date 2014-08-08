package com.flipkart.adeelzafar.finding_nemo;

/**
 * Created by adeel.zafar on 08/08/14.
 */
public class TargetModel {

    private String phoneName = "";
    private boolean permanent = false;
    private TargetGroup targetGroup;
    private String mac ="";

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public static enum TargetGroup{
        RED, YELLOW, ORANGE, AVAILABLE
    }

    public TargetGroup getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(TargetGroup targetGroup) {
        this.targetGroup = targetGroup;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public TargetModel(String phoneName, boolean permanent, TargetGroup tg, String mac) {
        this.phoneName = phoneName;
        this.permanent = permanent;
        this.targetGroup = tg;
        this.mac = mac;
    }
}
