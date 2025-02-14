package org.project.auth.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

enum Role {
    ADMIN, USER
}

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "user_id"
    )
    private Integer userId;

    @Column(
            name = "first_name"
    )
    private String firstName;

    @Column(
            name = "last_name"
    )
    private String lastName;

    @Column(
            name = "username"
    )
    private String username;

    @Column(
            name = "password"
    )
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "role"
    )
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
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
