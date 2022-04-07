/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.service;

import com.Tienda.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author OMEN
 */
public class UserService implements UserDetailsService{

@Autowired
public IPersonaService personaService;

@Override 
public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
Persona persona = this.personaService.findByNombre(username);
Userprincipal userPrincipal = new Userprincipal(persona);
return userPrincipal;
}
    
}
