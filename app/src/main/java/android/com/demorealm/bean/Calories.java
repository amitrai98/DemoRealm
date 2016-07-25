package android.com.demorealm.bean;

import io.realm.RealmObject;

/**
 * Created by amitrai on 25/7/16.
 */
public class Calories extends RealmObject{

    public int caloriesin, caloriesout, caloriesless;
    public String date;

    public int getCaloriesin() {
        return caloriesin;
    }

    public void setCaloriesin(int caloriesin) {
        this.caloriesin = caloriesin;
    }

    public int getCaloriesout() {
        return caloriesout;
    }

    public void setCaloriesout(int caloriesout) {
        this.caloriesout = caloriesout;
    }

    public int getCaloriesless() {
        return caloriesless;
    }

    public void setCaloriesless(int caloriesless) {
        this.caloriesless = caloriesless;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
