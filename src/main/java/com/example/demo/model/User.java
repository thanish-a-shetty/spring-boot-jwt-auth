package com.example.demo.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private String password;

    private boolean enabled;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "verification_expiration")
    private LocalDateTime verificationCodeExpiresAt;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {}

    // Getters
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getVerificationCode() { return verificationCode; }
    public LocalDateTime getVerificationCodeExpiresAt() { return verificationCodeExpiresAt; }

    // Setters
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public void setVerificationCode(String verificationCode) { this.verificationCode = verificationCode; }
    public void setVerificationCodeExpiresAt(LocalDateTime verificationCodeExpiresAt) { this.verificationCodeExpiresAt = verificationCodeExpiresAt; }

    // UserDetails overrides
    @Override
    public String getUsername() { return email; }  // KEY FIX

    @Override
    public String getPassword() { return password; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return List.of(); }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return enabled; }
}
