package edu.aku.ramshasaeed.mnch.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.ramshasaeed.mnch.data.AppDatabase;

@Entity(tableName = AppDatabase.Sub_DBConnection.TABLE_USERS)
public class Users {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String ROW_USERNAME = "";
    private String ROW_PASSWORD = "";

    @Ignore
    public Users(Users users) {
        this.ROW_USERNAME = users.ROW_USERNAME;
        this.ROW_PASSWORD = users.ROW_PASSWORD;
    }

    @Ignore
    public Users(String ROW_USERNAME, String ROW_PASSWORD) {
        this.ROW_USERNAME = ROW_USERNAME;
        this.ROW_PASSWORD = ROW_PASSWORD;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getROW_USERNAME() {
        return ROW_USERNAME;
    }

    public void setROW_USERNAME(String ROW_USERNAME) {
        this.ROW_USERNAME = ROW_USERNAME;
    }

    public String getROW_PASSWORD() {
        return ROW_PASSWORD;
    }

    public void setROW_PASSWORD(String ROW_PASSWORD) {
        this.ROW_PASSWORD = ROW_PASSWORD;
    }

    public Users Sync(JSONObject jsonObjectUser) throws JSONException {
        this.ROW_USERNAME = jsonObjectUser.getString("username");
        this.ROW_PASSWORD = jsonObjectUser.getString("password");
        return this;
    }
}
