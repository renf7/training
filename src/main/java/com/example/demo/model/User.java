package com.example.demo.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {
    private static final long serialVersionUID = -5508780399403497638L;
    private String username;
    private String password;
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean accountNonExpired;
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean accountNonLocked;
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean credentialsNonExpired;
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean enabled;
    @ManyToMany
    private Set<Role> authorities;
}