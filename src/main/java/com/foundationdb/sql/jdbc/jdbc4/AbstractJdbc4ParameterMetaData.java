/*-------------------------------------------------------------------------
*
* Copyright (c) 2005-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc4;

import java.sql.SQLException;

import com.foundationdb.sql.jdbc.core.BaseConnection;

public abstract class AbstractJdbc4ParameterMetaData extends com.foundationdb.sql.jdbc.jdbc3.AbstractJdbc3ParameterMetaData
{

    public AbstractJdbc4ParameterMetaData(BaseConnection connection, int oids[])
    {
        super(connection, oids);
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException
    {
        return iface.isAssignableFrom(getClass());
    }

    public <T> T unwrap(Class<T> iface) throws SQLException
    {
        if (iface.isAssignableFrom(getClass()))
        {
            return (T) this;
        }
        throw new SQLException("Cannot unwrap to " + iface.getName());
    }

}

