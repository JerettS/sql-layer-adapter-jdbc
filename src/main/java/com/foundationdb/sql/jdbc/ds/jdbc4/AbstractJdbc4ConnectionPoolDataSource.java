package com.foundationdb.sql.jdbc.ds.jdbc4;

import java.sql.SQLFeatureNotSupportedException;

import com.foundationdb.sql.jdbc.ds.jdbc23.AbstractJdbc23ConnectionPoolDataSource;

public class AbstractJdbc4ConnectionPoolDataSource
	extends AbstractJdbc23ConnectionPoolDataSource
{

    public java.util.logging.Logger getParentLogger() throws java.sql.SQLFeatureNotSupportedException
    {
        throw com.foundationdb.sql.jdbc.Driver.notImplemented(this.getClass(), "getParentLogger()");
    }

}

