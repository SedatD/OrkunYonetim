package sedatdilmac.com.orkunyonetim.pojo;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.Data;

/**
 * Created by SD
 * on 9.01.2019.
 */

@Data
public class User {
    private String userID;
    private String name;
    private String surName;
    private String email;
    private String password;
    private String phone;
    private int status;
    private String regDate;
    private String visitDate;
    private String siteID;
    private String block_name;
    private int block_daire;
    private String oneSignalID;
    private boolean login;

    public User(JSONObject jsonObject) throws JSONException {
        userID = jsonObject.getString("userID");
        name = jsonObject.getString("name");
        surName = jsonObject.getString("surName");
        email = jsonObject.getString("email");
        password = jsonObject.getString("password");
        phone = jsonObject.getString("phone");
        status = jsonObject.getInt("status");
        regDate = jsonObject.getString("regDate");
        visitDate = jsonObject.getString("visitDate");
        siteID = jsonObject.getString("siteID");
        block_name = jsonObject.getString("block_name");
        block_daire = jsonObject.getInt("block_daire");
        oneSignalID = jsonObject.getString("oneSignalID");
        login = jsonObject.getBoolean("login");
    }
}
