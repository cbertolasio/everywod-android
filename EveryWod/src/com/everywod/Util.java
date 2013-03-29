package com.everywod;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Util {

	public static void goToGitHub(Context context) {
		Uri uriUrl = Uri.parse("http://github.com/jfeinstein10/slidingmenu");
		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl); 
		context.startActivity(launchBrowser);
	}

    public static void goToAddNew(Context context) {
        Intent intent = new Intent(context, AddNewActivity.class);
        context.startActivity(intent);

    }
}
