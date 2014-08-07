/*-------------------------------------------------------------------------
*
* Copyright (c) 2009-2011, PostgreSQL Global Development Group
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.xa.jdbc4;

import java.sql.SQLFeatureNotSupportedException;

import com.foundationdb.sql.jdbc.xa.jdbc3.AbstractJdbc3XADataSource;

public class AbstractJdbc4XADataSource
    extends AbstractJdbc3XADataSource
{

    public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException
    {
        throw org.postgresql.Driver.notImplemented(this.getClass(), "getParentLogger()");
    }

}

