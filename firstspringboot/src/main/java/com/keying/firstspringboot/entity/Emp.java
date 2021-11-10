package com.keying.firstspringboot.entity;



import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_firstname")
    private String firstName;

    @Column(name = "emp_lastname")
    private String lastName;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "dept_id")
    private Integer departmentId;


    @ManyToOne()
    @JoinColumn(name = "dept_id")
    private Dept dept;





}