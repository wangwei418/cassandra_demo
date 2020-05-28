package com.ww.cassandrax.dao;

import com.datastax.oss.driver.api.core.DriverException;
import com.datastax.oss.driver.api.core.cql.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.cql.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EMPOpt {
    @Autowired
    private CassandraOperations cassandraOperations;

    public Emp queryById(int id){
       // return cassandraOperations.selectOne(Query.query(Criteria.where("emp_id").is(id)),Emp.class);
        return cassandraOperations.getCqlOperations().query("select * from emp where emp_id=?", new RowMapper<Emp>() {
            @Override
            public Emp mapRow(Row row, int i) throws DriverException {
                Emp e = new Emp();
                e.setEmpId(row.getInt("emp_id"));
                e.setEmpName(row.getString("emp_name"));
                return e;
            }
        },id).get(0);
    }
}
