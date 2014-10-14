/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outbottle.hellospring.models;

import com.outbottle.hellospring.entities.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author forsell
 */
public class ContactModel {
    private JdbcTemplate jdbcTemplate;
    
    public ContactModel(DataSource source){
        jdbcTemplate=new JdbcTemplate(source);
    }
    
    public List<Contact> getAll(){
        String sql="select * from contacts";
        List<Contact> contacts=jdbcTemplate.query(sql,new ContactRowMapper());
        return contacts;
    }
    
    public Contact getById(Integer id){
        String sql="select * from contacts where contact_id=" + id;
        
        return jdbcTemplate.query(sql ,new ResultSetExtractor<Contact>(){

            @Override
            public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
                
                if(rs.next()){
                    Contact contact=new Contact();  
                    contact.setContactId(rs.getInt("contact_id"));
                    contact.setFirstName(rs.getString("first_name"));
                    contact.setLastName(rs.getString("last_name"));
                    contact.setEmail(rs.getString("email"));
                    contact.setPhone(rs.getString("phone"));
                    return contact;
                }
                return null;
            }
        
        });
        
    }
    
    public int insert(Contact contact){
        String sql="INSERT into contacts(first_name,last_name,email,phone) VALUES(?,?,?,?)";
        Object[] params=new Object[]{contact.getFirstName(),contact.getLastName(),contact.getEmail(),contact.getPhone()};
        Object[] types=new Object[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
        return jdbcTemplate.update(sql,params,types);
    }
    
    public int delete(Integer id){
        String sql="DELETE from contacts where contact_id=?";
        return jdbcTemplate.update(sql,new Object[]{id});
    }
    

    class ContactRowMapper implements RowMapper<Contact>{

        @Override
        public Contact mapRow(ResultSet rs, int i) throws SQLException {
            Contact contact=new Contact();
            contact.setContactId(rs.getInt("contact_id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setEmail(rs.getString("email"));
            contact.setPhone(rs.getString("phone"));
            return contact;
        }
        
    }
}
