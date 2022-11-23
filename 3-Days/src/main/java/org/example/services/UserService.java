package org.example.services;

import org.example.models.IUser;
import org.example.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

}
