package com.keying.firstspringboot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
public class Dept {

    @Id
    @Column(name = "dept_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer deptId;

    @Column(name = "dept_name")
    private String deptName;



}