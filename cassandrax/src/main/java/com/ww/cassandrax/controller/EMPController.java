package com.ww.cassandrax.controller;

import com.datastax.oss.driver.api.core.type.codec.TypeCodec;
import com.google.gson.Gson;
import com.ww.cassandrax.dao.EMPDao;
import com.ww.cassandrax.dao.EMPOpt;
import com.ww.cassandrax.dao.EMPRes;
import com.ww.cassandrax.dao.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;
import java.util.Optional;

@RestController
public class EMPController {

    Gson gson = new Gson();
    @Autowired
    EMPDao empDao;
    @Autowired
    EMPRes empRes;

    @Autowired
    EMPOpt empOpt;

    @RequestMapping("/test")
    public String test(){
        empDao.test();
        return "ok";
    }

    @RequestMapping("/q")
    public String query(long id){
        Emp emp = empDao.findById(id);
        System.out.println(new String(emp.getEmpB().array()));

        return gson.toJson(emp);
    }

    @RequestMapping("/q2")
    public String query2(int id){
        Optional<Emp> optional = empRes.findById(id);

        /*Emp emp = new Emp();
        emp.setEmpId(4);
        emp.setEmpCity("guangzhou");
        emp.setEmpName("jam");

        emp.setEmpB(ByteBuffer.wrap("测试".getBytes()));
        empRes.save(emp);*/

        return gson.toJson(optional.get());
    }

    @RequestMapping("/q3")
    public String query3(int id){
       Emp emp = empOpt.queryById(id);
       return gson.toJson(emp);
    }

}
