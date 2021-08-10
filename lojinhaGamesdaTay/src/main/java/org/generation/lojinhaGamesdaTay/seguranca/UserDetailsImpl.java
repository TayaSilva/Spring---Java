package org.generation.lojinhaGamesdaTay.seguranca;

import java.util.Collection;
import java.util.List;

import org.generation.lojinhaGamesdaTay.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails{

private static final long serialVersionUID = 1L;

	
	private String email;
	private String senha;
	
	
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl (Usuario user) {
		this.email = user.getEmail();
		this.senha = user.getSenha();
	}
	
	public UserDetailsImpl() {
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
