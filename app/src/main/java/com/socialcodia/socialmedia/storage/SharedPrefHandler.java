package com.socialcodia.socialmedia.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.socialcodia.socialmedia.models.ModelUser;

public class SharedPrefHandler {
    private static String PREF_NAME = "socialcodia";
    private static SharedPrefHandler mInstance;
    private static SharedPreferences sp;
    private Context context;

    public SharedPrefHandler(Context context) {
        this.context = context;
    }


    public static synchronized SharedPrefHandler getInstance(Context context)
    {
        if(mInstance==null)
        {
            mInstance = new SharedPrefHandler(context);
        }
        return mInstance;
    }

    public void saveUser(ModelUser user)
    {
        sp = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("userId",user.getId());
        editor.putString("userName",user.getName());
        editor.putString("userEmail",user.getEmail());
        editor.putString("userBio",user.getBio());
        editor.putString("userImage",user.getImage());
        editor.putString("userToken",user.getToken());
        editor.putInt("userVerified",user.getVerified());
        editor.apply();
    }

    public Boolean isLoggedIn()
    {
        sp = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        int isLogin =  sp.getInt("userId",-1);
        if (isLogin!=-1)
            return true;
        else
            return false;
    }

}
