package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Controller.LoginRequest;
import com.example.demo.Dao.UserDao;
import com.example.demo.pojo.Users;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
 
	@Autowired
	private UserDao userdao;
	
	public Users login(LoginRequest loginRequest) {
        Optional<Users> userOpt = userdao.findByEmail(loginRequest.getUsername());
        
        if (userOpt.isPresent()) {
            Users user = userOpt.get();
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return user;
            } else {
				throw new UserNotFoundException();
                
            }
        }
		// return null;
    }
	
	public List<Users> Display(){
		return userdao.findAll();
		
	}

	public Users saveinfo(Users obj) {
		 Users users =userdao.save(obj);
		return users;
	}

	public Users deleteinfo(Long id) {
		   Optional<Users> user= userdao.findById(id);
	       userdao.deleteById(id);
		return user.get();
	}

	public Users updateinfo(Long id, Users obj) {
		Users users=userdao.save(obj);
		return users;
	}

	public void updatepass(Long id, String password) {
		Users user = userdao.findById(id).orElseThrow();
		user.setPassword(password);
		userdao.save(user);
	}
	
	
}
