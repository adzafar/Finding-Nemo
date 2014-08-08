package com.flipkart.adeelzafar.finding_nemo;

import android.app.Activity;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by adeel.zafar on 08/08/14.
 */
public class ModelHandler {
    static ArrayList<TargetModel> models = new ArrayList<TargetModel>();
    static LinearLayout redUpper;
    static LinearLayout redLower;
    static LinearLayout orangeUpper;
    static LinearLayout orangeLower;
    static LinearLayout yellowUpper;
    static LinearLayout yellowLower;

    static Main mainActivity;

    public static void updateRedUpper() {
        redUpper.removeAllViews();
        for(TargetModel model : ModelHandler.models){
            if(model.getTargetGroup() == TargetModel.TargetGroup.RED)
                redUpper.addView(CustomButton.makeButton(model, mainActivity));
        }
    }

    public static void updateRedLower() {
        redUpper.removeAllViews();
        for(TargetModel model : ModelHandler.models){
            if(model.getTargetGroup() == TargetModel.TargetGroup.AVAILABLE)
                redLower.addView(CustomButton.makeButton(model, mainActivity));
        }
    }

    public static void updateYellowUpper() {
        redUpper.removeAllViews();
        for(TargetModel model : ModelHandler.models){
            if(model.getTargetGroup() == TargetModel.TargetGroup.YELLOW)
                yellowUpper.addView(CustomButton.makeButton(model, mainActivity));
        }
    }

    public static void updateYellowLower() {
        redUpper.removeAllViews();
        for(TargetModel model : ModelHandler.models){
            if(model.getTargetGroup() == TargetModel.TargetGroup.AVAILABLE)
                yellowLower.addView(CustomButton.makeButton(model, mainActivity));
        }
    }

    public static void updateOrangeLower() {
        redUpper.removeAllViews();
        for(TargetModel model : ModelHandler.models){
            if(model.getTargetGroup() == TargetModel.TargetGroup.AVAILABLE)
                orangeLower.addView(CustomButton.makeButton(model, mainActivity));
        }
    }

    public static void updateOrangeUpper() {
        redUpper.removeAllViews();
        for(TargetModel model : ModelHandler.models){
            if(model.getTargetGroup() == TargetModel.TargetGroup.ORANGE)
                orangeLower.addView(CustomButton.makeButton(model, mainActivity));
        }
    }

}
