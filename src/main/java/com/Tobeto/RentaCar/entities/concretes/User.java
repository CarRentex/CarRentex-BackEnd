package com.Tobeto.RentaCar.entities.concretes;
import com.Tobeto.RentaCar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity implements UserDetails{


    @Column(name = "username")
    private String username;
    @Column(name = "email",length = 50, nullable = true)
    private String email;
    @Column(name = "password")
    private String password;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "user_authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private List<Role> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}
