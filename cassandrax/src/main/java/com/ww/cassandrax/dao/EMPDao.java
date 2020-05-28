package com.ww.cassandrax.dao;

import com.datastax.oss.driver.api.core.cql.ColumnDefinition;
import com.datastax.oss.driver.api.core.cql.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CassandraTemplate 方式
 */

@Repository
public class EMPDao {

    @Autowired
    private CassandraTemplate cassandraTemplate;

    public Emp findById(long id){
        return cassandraTemplate.selectOneById(id,Emp.class);
    }

    public void test(){
        List<Row> list = cassandraTemplate.select("select * from emp", Row.class);
        for (Row row : list){

           /* for (ColumnDefinition columnDefinition : row.getColumnDefinitions()){
                Object ret = row.get(columnDefinition.getName(),Object.class);
                System.out.print(ret +"  ");
            }*/
            System.out.println(row.get("emp_id",Integer.class)+"-"+row.get("emp_city",String.class));
        }
    }
}
