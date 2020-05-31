package diploma.autos.gateway.controllers;


import diploma.autos.gateway.CustomUserDetailsService;
import diploma.autos.gateway.model.AuthenticationRequest;
import diploma.autos.gateway.model.AuthenticationResponse;
import diploma.autos.gateway.model.User;
import diploma.autos.gateway.repositories.UserRepository;
import diploma.autos.gateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/api/authenticate")
    public ResponseEntity auth(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = customUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


    @PostMapping("/api/register")
    public ResponseEntity register(@RequestBody User user) {
        if ( !userRepository.findByUsername(user.getUsername()).isPresent()) {
            System.out.println(user);
            userRepository.save(user);

            final UserDetails userDetails = customUserDetailsService
                    .loadUserByUsername(user.getUsername());

            final String jwt = jwtTokenUtil.generateToken(userDetails);

            System.out.println(jwt);
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        }
        return ResponseEntity.status(403).build();
    }

}
