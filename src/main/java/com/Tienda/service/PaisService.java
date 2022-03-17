
package com.Tienda.service;

import com.Tienda.entity.Pais;
import com.Tienda.repository.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService implements IPaisService{

@Autowired
private PaisRepository paisRepository;

@Override
public List<Pais> listCountry(){
return(List<Pais>) paisRepository.findAll();
}
    
}
