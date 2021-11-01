package br.com.alura.mvc.mudi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override //fechando a aplicacao, metodo de autorizacao
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //para todas as autorizacoes
                .anyRequest().authenticated() //usuario deve extar logado
                .and()
                .formLogin(form -> form.loginPage("/login") //url da pagina de login
                        .permitAll()//todos podem acessar a pagina de login
                )
                .logout(logout -> logout.logoutUrl("/logout"));
    }

    @Bean
    @Override    //metodo para criar um usuario em memoria
    public UserDetailsService userDetailsService(){
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("val")
                        .password("123")
                        .roles("ADM")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }

}
