package com.flipkart.adeelzafar.finding_nemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by adeel.zafar on 08/08/14.
 */
public class CustomButton extends Button {
    TargetModel model;
    Context context;

    public static CustomButton makeButton(TargetModel targetModel, Context context){
        CustomButton btn = new CustomButton(context);
        btn.model = targetModel;
        btn.update();
        return btn;
    }

    public void update(){
        setText(model.getPhoneName());

        if(model.isPermanent())
            setTextColor(context.getResources().getColor(R.color.Blue));
        else
            setTextColor(context.getResources().getColor(R.color.Green));

        setBackgroundDrawable(getResources().getDrawable(R.drawable.round_button));

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(2, 2, 2, 2);
        setLayoutParams(params);

        setTypeface(null, Typeface.BOLD);
    }

    public CustomButton(Context context) {
        super(context);
        this.context = context;
    }

}
