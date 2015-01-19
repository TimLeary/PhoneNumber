/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonenumber;

import phonenumber.model.DbCreatorModel;
import phonenumber.views.StartView;

/**
 *
 * @author David
 */
public class PhoneNumber{
    public static final String db_name = "phonenums.db";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new DbCreatorModel(db_name);
        
        StartView stView = new StartView("Phone Number v0.1a");
        stView.setVisible(true);
    }
    
}
