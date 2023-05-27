package br.com.alura.forum.config

import br.com.alura.forum.security.JWTLoginFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
        private val configuration: AuthenticationConfiguration,
        private val jwtUtil: JWTUtil
) {
    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http.
        authorizeHttpRequests().
        //requestMatchers("/topicos")?.hasAuthority("SOMENTE_LEITURA")?.
        requestMatchers("/login")?.permitAll()?.
        anyRequest()?.
        authenticated()

        http.addFilterBefore(JWTLoginFilter(authManager = configuration.authenticationManager, jwtUtil = jwtUtil), UsernamePasswordAuthenticationFilter().javaClass)

        http.sessionManagement()?.
        sessionCreationPolicy(SessionCreationPolicy.STATELESS)?.
        and()?.
        formLogin()?.disable()?.
        httpBasic()

        http.csrf().disable()

        return http.build()
    }

    @Bean
    fun encoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

}