package diploma.autos.gateway;

import diploma.autos.gateway.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    /**
     * Repository for manipulation with data from the User data table
     */
    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param s Username
     * @return UserDetails object
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<diploma.autos.gateway.model.User> userOptional = userRepository.findByUsername(s);

        if ( userOptional.isPresent() ) {
            return new User(userOptional.get().getUsername(), userOptional.get().getPassword(),
                    new ArrayList<>());
        }
        return null;
    }
}
