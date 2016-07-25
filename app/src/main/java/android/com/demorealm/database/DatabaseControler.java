package android.com.demorealm.database;

import android.com.demorealm.bean.Calories;
import android.com.demorealm.utility.utility;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by amitrai on 25/7/16.
 */
public class DatabaseControler {

    private static final String TAG = DatabaseControler.class.getSimpleName();
    private static Realm realm;


    /**
     * insert data into table
     * @param calories
     */
    public static void insertCalories(final Calories calories){
        realm = Realm.getDefaultInstance();
        RealmResults<Calories> realmResults = realm.where(Calories.class).
                equalTo("date", utility.getTodaysDate()).findAll();

        int incal = 0, outcal = 0, lesscal = 0;


        if(realmResults.size() >0){
            for (int i = 0; i < realmResults.size(); i++) {
                incal += realmResults.get(i).getCaloriesin();
                outcal += realmResults.get(i).getCaloriesout();
                lesscal += realmResults.get(i).getCaloriesless();
            }

            deleteCalories(calories.getDate());


            try{
                realm.beginTransaction();
                Calories object = realm.createObject(Calories.class);
                object.date = calories.getDate();
                object.caloriesin  = incal;
                object.caloriesout  = outcal;
                object.caloriesless  = lesscal;
            }catch (Exception e){
                Log.e(TAG+" Realm Error", "error " +e);
            } finally {
                realm.commitTransaction();
            }

        }else {
            try{
                realm.beginTransaction();
                Calories object = realm.createObject(Calories.class);
                object.date = calories.getDate();
                object.caloriesin  = calories.getCaloriesin();
                object.caloriesout  = calories.getCaloriesout();
                object.caloriesless  = calories.getCaloriesless();
            }catch (Exception e){
                Log.e(TAG+" Realm Error", "error " +e);
            } finally {
                realm.commitTransaction();
            }
            // Asynchronously update objects on a background thread
        }



    }


    public static void deleteCalories(String date){
        realm = Realm.getDefaultInstance();
        RealmResults<Calories> realmResults = realm.where(Calories.class).contains("date", date)
                .findAll();

        try {
            if(realmResults.size() >0){
                realm.beginTransaction();
                for (int i = 0; i < realmResults.size(); i++) {
                    if(realmResults.get(i).getDate().equalsIgnoreCase(date)){
                        // remove a single object
                        Calories calory = realmResults.get(i);
                        calory.deleteFromRealm();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            realm.commitTransaction();
        }


    }

    public static void getCalories(String date){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Calories> realmResults = realm.where(Calories.class).contains("date", date)
                .findAll();
        for (int i = 0; i < realmResults.size(); i++) {
            Log.e(TAG, ""+realmResults.get(i).getDate());
            Log.e(TAG, ""+realmResults.get(i).getCaloriesin());
            Log.e(TAG, ""+realmResults.get(i).getCaloriesout());
            Log.e(TAG, ""+realmResults.get(i).getCaloriesless());

        }
    }

    public static void getAllCalories(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Calories> realmResults = realm.where(Calories.class).
                equalTo("date", utility.getTodaysDate()).findAll();
        for (int i = 0; i < realmResults.size(); i++) {
            Log.e(TAG, ""+realmResults.get(i).getDate());
            Log.e(TAG, ""+realmResults.get(i).getCaloriesin());
            Log.e(TAG, ""+realmResults.get(i).getCaloriesout());
            Log.e(TAG, ""+realmResults.get(i).getCaloriesless());

        }
    }


}
