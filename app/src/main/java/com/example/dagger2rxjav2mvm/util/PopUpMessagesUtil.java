package com.example.dagger2rxjav2mvm.util;

import android.content.Context;
import android.widget.Toast;
/**
 * Created by Irfan Ul Haq on 07/01/2020.
 */
public class PopUpMessagesUtil {
    private static PopUpMessagesUtil instance;
    private Context context;
    private PopUpMessagesUtil(Context context) {
        this.context = context;
    }

    public static PopUpMessagesUtil getInstance(Context context) {
        if (instance == null)
            instance = new PopUpMessagesUtil(context);
        return instance;
    }

    public void showToast(String message) {
        Toast.makeText(this.context, message, Toast.LENGTH_LONG).show();
    }


}
