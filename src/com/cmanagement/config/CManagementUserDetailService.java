package com.cmanagement.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cmanagement.model.Role;
import com.cmanagement.service.UserService;

@Component
public class CManagementUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		com.cmanagement.model.User user = userService.getUserByName(name);
		if (user == null) {
			return new User("", "", new ArrayList<SimpleGrantedAuthority>());
			 //throw new UsernameNotFoundException("user not exists");

		}

		List<Role> roles = user.getRoles();
		return new User(user.getName(), user.getPassword(), getAuthorities(roles));
	}

	private List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
		List<SimpleGrantedAuthority> authList = new ArrayList<>();
		Iterator<Role> rolesIt = roles.iterator();
		while (rolesIt.hasNext()) {
			Role role = (Role) rolesIt.next();
			authList.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authList;
	}
}
