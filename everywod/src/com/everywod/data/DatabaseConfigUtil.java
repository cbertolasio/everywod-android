package com.everywod.data;

import com.everywod.data.model.ExampleModel;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

/**
 * 
 * @author bradlymatheson
 *  You will need to run this utility locally on your development box (not in an Android device), whenever you make a change to one of your data classes. 
 *  This means that right now, this must be done by hand to keep the configuration file in sync with your database classes. 
 *  To run the utility you will need to use the local Java runtime environment (JRE). 
 *  Under eclipse, edit the "Run Configuration" for the utility, select the JRE tab, and select an alternative JRE (1.5 or 1.6). 
 *  Your project’s JRE should be undefined since it is an Android application. 
 *  You’ll also need to remove the Android bootstrap entry from the Classpath tab.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {
	private static final Class<?>[] classes = new Class[] { ExampleModel.class, };

	public static void main(String[] args) throws Exception {
		writeConfigFile("ormlite_config.txt", classes);
		System.out.println("-=-=-=||DONE||=-=-=-");
	}
}
