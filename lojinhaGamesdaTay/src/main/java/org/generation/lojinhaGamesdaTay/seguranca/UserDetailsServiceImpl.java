package org.generation.lojinhaGamesdaTay.seguranca;

import java.util.Optional;

import org.generation.lojinhaGamesdaTay.model.Usuario;
import org.generation.lojinhaGamesdaTay.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class UserDetailsServiceImpl {
	@Service
	public class userDetailsServiceImpl  implements UserDetailsService{

		@Autowired
		private UsuarioRepository userRepository;
		

		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			Optional<Usuario> user = userRepository.findByEmail(email);
			user.orElseThrow(() -> new UsernameNotFoundException(email + "erros&erros"));
			
			return user.map(UserDetailsImpl::new).get();
		}
	}
}