package br.com.alura.mvc.mudi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override //fechando a aplicacao, metodo de autorizacao
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //para todas as autorizacoes
                .anyRequest().authenticated() //usuario deve extar logado
                .and()
                .formLogin(form -> form.loginPage("/login")//url da pagina de login
                        .defaultSuccessUrl("/home", true)
                        .permitAll()//todos podem acessar a pagina de login
                )
                .logout(logout -> logout.logoutUrl("/logout"))
                .csrf().disable(); //desativando uma configuração de segurança desncessária nesse momento (cross-site-request-forgery)
    }

    protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {

        //encoder para criptografar as senhas
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//        //cria o usuario no banco
//        UserDetails user =
//                User.builder()
//                        .username("caleb")
//                        .password(encoder.encode("123")) //criptografanfo a senha
//                        .roles("ADM")
//                        .build();

        //busca usuarios com o data sorce (banco)
        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(encoder);
                //.withUser(user); //depois que já crio apaga.
    }



//    @Bean
//    @Override    //metodo para criar um usuario em memoria
//    public UserDetailsService userDetailsService(){
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("val")
//                        .password("123")
//                        .roles("ADM")
//                        .build();
//        return new InMemoryUserDetailsManager(user);
//    }

}
