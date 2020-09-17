package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -5508780399403497638L;

    @TableGenerator(
        name="empGen",
        initialValue = 1000,
        allocationSize=1000)
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="empGen")
    private long id;
}