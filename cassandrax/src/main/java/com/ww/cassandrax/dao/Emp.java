package com.ww.cassandrax.dao;

import org.springframework.data.cassandra.core.mapping.*;

import java.io.Serializable;
import java.nio.ByteBuffer;

@Table("emp")
public class Emp implements Serializable {

    //注释中的写法 会报错 提示 empid 没有这个列
    @PrimaryKey(value = "emp_id")
 /*   @PrimaryKey
    @Column(value = "emp_id")*/
    private int empId;

    @Column("emp_city")
    private String empCity;

    @Column("emp_name")
    private  String empName;

    @Column("emp_sal")
    private  Long  empSal;

    @Column("emp_phone")
    private  Long  empPhone;
    //blob 如果用byte数组 也无法保存
    @Column("emp_b")
   // @CassandraType()
    private ByteBuffer empB;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public long getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Long empSal) {
        this.empSal = empSal;
    }

    public long getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(Long empPhone) {
        this.empPhone = empPhone;
    }

    public ByteBuffer getEmpB() {
        return empB;
    }

    public void setEmpB(ByteBuffer empB) {
        this.empB = empB;
    }
/* public byte[] getEmpB() {
        return empB;
    }

    public void setEmpB(byte[] empB) {
        this.empB = empB;
    }*/
}
