package tn.esprit.spring.service;


import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.React;
import tn.esprit.spring.repository.ReactRepository;


@Service  
public class ReactService   
{  
	@Autowired  
	ReactRepository ReactRepository;  

	public List<React> getAll()   
	{  
		List<React> reacts = new ArrayList<React>();  
		ReactRepository.findAll().forEach(react1 -> reacts.add(react1));  
		return reacts;  
	}  
	
	public void save(React reacts)   
	{  
		ReactRepository.save(reacts);  
	}  
	
	public React getById(int id) {
		return ReactRepository.findById(id).get();
	}

	public void update(React reacts) {
		ReactRepository.save(reacts);
	}

	public void delete(int id) {
		ReactRepository.deleteById(id);
	}
	
	public String countReactPerComPerType(int idCom , int type) {
		return ReactRepository.countReactPerComPerType(idCom,type);
		
	}
}  