package com.Tobeto.RentaCar.core.filter;
import com.Tobeto.RentaCar.core.services.JwtService;
import com.Tobeto.RentaCar.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService userService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        //jwt okuma
        //jwt dogrula
        //security giriş yapıldığını haber vericez
        //chain i ilerleticez

        String jwtHeader = request.getHeader("Authorization");
        if(jwtHeader != null && jwtHeader.startsWith("Bearer ")){

            String jwt = jwtHeader.substring(7);
            String username = jwtService.extractUser(jwt);

            if(username!= null){
                UserDetails user = userService.loadUserByUsername(username);
                if(jwtService.validateToken(jwt,user)){
                    //Herşey başarılı, Giriş sağlanabilir.

                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
                            null,
                            user.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);


                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
