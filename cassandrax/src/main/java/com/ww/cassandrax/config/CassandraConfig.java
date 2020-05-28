package com.ww.cassandrax.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
public class CassandraConfig  extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspaceName;

    @Value("${spring.data.cassandra.contact-points}")
     private String contactPoints;

    @Value("${spring.data.cassandra.port}")
     private int port;


 /*   @Value("${spring.data.cassandra.cluster-name}")
     private String clusterName;*/

    @Override
    protected String getKeyspaceName() {
         return keyspaceName;
    }

     @Override
     public String getContactPoints() {
        return contactPoints;
    }

    @Override
    public int getPort() {
        return this.port;
     }

   @Override
    protected String getLocalDataCenter() {
        return "datacenter1";
    }
   /* @Override
    public String getClusterName() {
         return clusterName;
    }*/
}
