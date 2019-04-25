/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import util.ConnectionDB;

/**
 *
 * @author Nghĩa Phan
 */
public class UserModel {
    public boolean checkUser(User user){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean check = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call CheckUser(?,?,?)}");
            callSt.setString(1, user.getUserName());
            callSt.setString(2, user.getPassWord());
            callSt.registerOutParameter(3, Types.BIT);
            callSt.execute();
            int cnt = callSt.getInt(3);
            if (cnt>0) {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            ConnectionDB.closeConnection(conn, callSt);
        }
        return check;
    }
}
