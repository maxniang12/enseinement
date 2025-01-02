package uasz.sn.Gestion_Enseignement.authentification.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static  final  String[] FOR_PERMANANT={"/Permanant/**"};
    private static  final  String[] FOR_VACATAIRE={"/Vacataire/**"};
    private static  final String[] FOR_CHEFDEPARTEMENT={"/ChefDepartement/**"};
    private static final String[] FOR_ETUDIANT={"/Etudiant/**"};
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     http
             .authorizeHttpRequests((authorizeHttpRequests) ->

                     authorizeHttpRequests
                             .requestMatchers("/js/**","/css/**").permitAll()
                             .requestMatchers("/login**","/logout**").permitAll()
                             //.requestMatchers("/h2/**").permitAll()
                             .requestMatchers(FOR_PERMANANT).hasRole("Permanent")
                             .requestMatchers(FOR_VACATAIRE).hasRole("Vacataire")
                             .requestMatchers(FOR_CHEFDEPARTEMENT).hasRole("ChefDepartement")
                             .requestMatchers(FOR_ETUDIANT).hasRole("Etudiant")
                             .anyRequest().authenticated()

             )
             .formLogin((formLogin)->
                     formLogin
                             .usernameParameter("username")
                             .passwordParameter("password")
                             .loginPage("/login")
                             .defaultSuccessUrl("/")
                             .successForwardUrl("/")
                             .permitAll()
             );
     return http.build();
    }
}