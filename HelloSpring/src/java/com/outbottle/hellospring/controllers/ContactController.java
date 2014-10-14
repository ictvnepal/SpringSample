/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outbottle.hellospring.controllers;

import com.outbottle.hellospring.entities.Contact;
import com.outbottle.hellospring.models.ContactModel;
import com.outbottle.hellospring.models.DataAccess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author forsell
 */
@Controller
public class ContactController {
    DataAccess db=null;
    ContactModel contactModel=null;
    
    public ContactController(){
        db=new DataAccess();
        contactModel=new ContactModel(db.getDataSource());
    }
    
    @RequestMapping(value="/contact",method=RequestMethod.GET)
    public String index(ModelMap map){
        
        map.put("contacts",contactModel.getAll());
        return "contact/index";
    }
    
     @RequestMapping(value="/contact/add",method=RequestMethod.GET)
    public String add(ModelMap map){
        Contact contact=new Contact();
        map.addAttribute("contact", contact);
        return "contact/add";
    }
    
    @RequestMapping(value="/contact/edit/{id}",method=RequestMethod.GET)
    public String edit(@PathVariable(value="id")Integer id,ModelMap map){
        map.put("contact",contactModel.getById(id));
        return "contact/edit";
    }
    
    @RequestMapping(value="/contact/delete/{id}",method=RequestMethod.GET)
    public String delete(@PathVariable(value="id")Integer id,ModelMap map){
        contactModel.delete(id);
        return "redirect:/contact";
    }
    
    @RequestMapping(value="/contact/save",method=RequestMethod.POST)
    public String save(@ModelAttribute("contact") Contact contact,ModelMap map){
        /*if(contact.getContactId()==0){
            
        }else{
            
        }*/
        contactModel.insert(contact);
        //map.put("contact",contact);
        return "redirect:/contact";
    }

}
