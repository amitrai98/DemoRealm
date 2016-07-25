package android.com.demorealm.activity;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by amitrai on 25/7/16.
 */
public class AppInitials extends Application{
    private static Realm realm = null;
    private static AppInitials activity = null;
    private static RealmConfiguration realmConfig = null;

    @Override
    public void onCreate() {
        super.onCreate();
        activity = this;

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfiguration);

    }


    public static AppInitials getInstance(){
        return activity;
    }

}
