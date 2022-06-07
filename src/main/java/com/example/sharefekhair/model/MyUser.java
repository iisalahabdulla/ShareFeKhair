package com.example.sharefekhair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
@Table(name = "user")
public class MyUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "username is required")
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    @NotEmpty(message = "password is required")
    private String password;
    @Column(nullable = false)
    @NotEmpty(message = "email is required")
    @Email(message = "email must be valid")
    private String email;
    @Column(nullable = false)
    @NotEmpty(message = "role is required")
    @Pattern(regexp = "(student|teacher)",message = "role must be (student|teacher)")
    private String role;

    @OneToOne
    @JsonIgnore
    @PrimaryKeyJoinColumn
    private Teacher teacher;

    @OneToOne
    @JsonIgnore
    @PrimaryKeyJoinColumn
    private Student student;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Note> notes;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.getRole()));
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