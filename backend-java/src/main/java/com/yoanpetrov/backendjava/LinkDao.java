package com.yoanpetrov.backendjava;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public class LinkDao
{
    private static final String SAVE_LINK_QUERY =
            "INSERT INTO links (short_url, original_url, created_at) VALUES (?, ?, ?) IF NOT EXISTS";

    private static final String FIND_LINK_QUERY =
            "SELECT original_url FROM links WHERE short_url = ?";

    private final CqlTemplate cqlTemplate;

    public LinkDao(CqlTemplate cqlTemplate)
    {
        this.cqlTemplate = cqlTemplate;
    }

    public boolean saveLink(String shortUrl, String originalUrl)
    {
        Instant createdAt = Instant.now();
        ResultSet resultSet = cqlTemplate.queryForResultSet(SAVE_LINK_QUERY, shortUrl, originalUrl, createdAt);
        Row row = resultSet.one();
        return row != null && row.getBoolean("[applied]");
    }

    public Optional<String> findOriginalUrlByShortUrl(String shortUrl)
    {
        ResultSet resultSet = cqlTemplate.queryForResultSet(FIND_LINK_QUERY, shortUrl);
        Row row = resultSet.one();
        if (row != null) {
            return Optional.ofNullable(row.getString("original_url"));
        }
        return Optional.empty();
    }
}
