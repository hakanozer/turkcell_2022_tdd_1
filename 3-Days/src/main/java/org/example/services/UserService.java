package org.example.services;

import com.google.gson.Gson;
import org.example.models.IUser;
import org.example.props.UserLogin;
import org.example.utils.DB;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements IUser {


    public boolean login(String email, String password) {
        if ( email.equals("ali@mail.com") && password.equals("12345") )
            return true;
        return false;
    }


    public List<String> list() {
        List<String> ls = new ArrayList<String>();
        DB db = new DB();
        try {
            String sql = "select * from customer";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                String email = rs.getString("email");
                ls.add(email);
            }
        }catch (Exception ex) {
            System.err.println("DB Error :" + ex);
        }finally {
            db.close();
        }
        return ls;
    }

    public boolean restUserLogin( String email, String password ) {
        boolean status = false;
        try {
            String url = "https://www.jsonbulut.com/json/userLogin.php";
            Map<String, String> hm = new HashMap<String, String>();
            hm.put("ref", "d1becef32825e5c8b0fc1b096230400b");
            hm.put("userEmail", email);
            hm.put("userPass", password);
            hm.put("face", "no");

            String data = Jsoup.connect(url).data(hm).timeout(15000).ignoreContentType(true).get().body().text();
            Gson gson = new Gson();
            UserLogin userLogin = gson.fromJson(data, UserLogin.class);
            boolean loginStatus = userLogin.getUser().get(0).getDurum();
            System.out.println("loginStatus : " + loginStatus);

            JSONObject obj = new JSONObject(data);
            status = obj.getJSONArray("user").getJSONObject(0).getBoolean("durum");
        }catch (Exception ex) {
            System.err.println("Service Error : " + ex);
        }
        return status;
    }

}
