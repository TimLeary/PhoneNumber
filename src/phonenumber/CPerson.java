/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonenumber;

/**
 *
 * @author David
 */
public class CPerson {
    int id;
    String p_family_name;
    String p_forename;
    
    CPerson(String family_name, String forename){
        p_family_name = family_name;
        p_forename = forename;
    }
    
    String getWholeName(){
        return p_family_name + " " + p_forename;
    }
}
