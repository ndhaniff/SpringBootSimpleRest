package com.ndhaniff.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/* Entity Directive */
@Entity
@Table
public class Student {
  /*
   * This part where we create table and generate id ibernate: create sequence
   * student_sequence start 1 increment 1 Hibernate:
   * 
   * create table student ( id int8 not null, age int4, dob date, email
   * varchar(255), name varchar(255), primary key (id) )
   */
  @Id
  @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  private Long id;

  private String name;

  @Transient // not in database / computed
  private Integer age;
  private LocalDate dob;
  private String email;

  public Student() {
  }

  public Student(Long id, String name, LocalDate dob, String email) {
    this.id = id;
    this.name = name;
    this.dob = dob;
    this.email = email;
  }

  public Student(String name, LocalDate dob, String email) {
    this.name = name;
    this.dob = dob;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // computed / accessor
  public Integer getAge() {
    return Period.between(dob, LocalDate.now()).getYears();
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", age='" + getAge() + "'" + ", dob='"
        + getDob() + "'" + ", email='" + getEmail() + "'" + "}";
  }
}