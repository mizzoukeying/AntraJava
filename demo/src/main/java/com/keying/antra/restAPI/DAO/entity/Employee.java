package com.keying.antra.restAPI.DAO.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

//SQL中employee表
@Table(name="employee")
//Entity class 会和DB中返回数据自动转换
@Entity
//来自于lombok,自动为所有字段添加@ToString, @EqualsAndHashCode,
//@Getter方法，为非final字段添加@Setter,和@Getter
@Data
//自动生成无参数构造函数
@NoArgsConstructor
//自动生成全参数构造函数
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private String emdID;

    @Column(name = "emp_firstname")
    private String empFirstname;

    @Column(name = "emp_lastname")
    private String empLastname;

    //residual variable for testing
    @Column(name = "salary")
    private Integer salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department dept;

}
