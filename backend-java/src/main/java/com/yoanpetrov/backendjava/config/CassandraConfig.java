package com.yoanpetrov.backendjava.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.CqlTemplate;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration
{
    @Override
    public String getContactPoints()
    {
        return "127.0.0.1";
    }

    @Override
    public int getPort()
    {
        return 9042;
    }

    @Override
    public String getKeyspaceName()
    {
        return "url_shortener";
    }

    @Override
    public SchemaAction getSchemaAction()
    {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages()
    {
        return new String[]{"com.yoanpetrov.backendjava.model"};
    }

    @Bean
    public CqlTemplate cqlTemplate(CqlSession cqlSession)
    {
        return new CqlTemplate(cqlSession);
    }
}
