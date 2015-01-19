/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonenumber.model;

import java.sql.ResultSet;

/**
 *
 * @author David
 */
public class PersonModel {
    public static Boolean deletePersonDatasById(int id){
        System.out.println("Delete id:"+id);
        try{
            SqliteConnect wSql = new SqliteConnect();
            String deletePhones = "DELETE FROM PHONE_NUMBER WHERE person_id="+id;
            wSql.executeStmt(deletePhones);
            String deletePerson = "DELETE FROM PERSON WHERE id="+id;
            wSql.executeStmt(deletePerson);
            wSql.closeConnection();
            return true;
        } catch (Exception e){
            System.out.println(e.getClass().getName() + " " +e.getMessage());
            return false;
        }
    }
    
    public static String[] getPersonListColumnNames() {
        String[] columnNames = {
            "id",
            "family name",
            "forename",
            "phone numbers"
        };
        
        return columnNames;
    }
    
    public static Object[][] getPersonListData(){
        Object[][] PersonList;
        
        try {
            SqliteConnect wSql = new SqliteConnect();
            
            String numPersons = "SELECT COUNT(*) as p_num FROM PERSON";
            ResultSet personnum_rs = wSql.executeQry(numPersons);
            personnum_rs.next();
            int count = personnum_rs.getInt("p_num");
            personnum_rs.close();
            
            PersonList = new Object[count][4];
            
            String selectPersons = "SELECT p.*,(SELECT group_concat(n.phone_num) FROM PHONE_NUMBER n where n.person_id = p.id) as phone_num_str FROM PERSON p";
            ResultSet person_rs = wSql.executeQry(selectPersons);
            int i = 0;
            while(person_rs.next()){
                int id = person_rs.getInt("id");
                String family_name = person_rs.getString("family_name");
                String forename = person_rs.getString("forename");
                String phone_nums = person_rs.getString("phone_num_str");
                Object[] tmpPerson = {id, family_name, forename, phone_nums};
                PersonList[i] = tmpPerson;
                i++;
            }
            wSql.closeConnection();
            return PersonList;
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + " " +e.getMessage());
            PersonList = new Object[0][4];
            return PersonList;
        }
    }
    
}
