package com.flipkart.adeelzafar.finding_nemo;

/**
 * Created by adeel.zafar on 08/08/14.
 */
public class TargetModel {

    private String phoneName = "";
    private boolean permanent = false;

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

    public TargetModel(String phoneName, boolean permanent) {
        this.phoneName = phoneName;
        this.permanent = permanent;
    }
}
