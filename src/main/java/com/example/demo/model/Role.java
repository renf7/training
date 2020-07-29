package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority {
    private static final long serialVersionUID = -5787850367478073574L;
    private String authority;
}