/*-------------------------------------------------------------------------
*
* Copyright (c) 2008-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/

package com.foundationdb.sql.jdbc.jdbc3g;

import java.sql.*;
import java.util.List;
import java.util.UUID;

import com.foundationdb.sql.jdbc.core.*;
import com.foundationdb.sql.jdbc.util.ByteConverter;
import com.foundationdb.sql.jdbc.util.GT;
import com.foundationdb.sql.jdbc.util.PSQLException;
import com.foundationdb.sql.jdbc.util.PSQLState;

public abstract class AbstractJdbc3gResultSet extends com.foundationdb.sql.jdbc.jdbc3.AbstractJdbc3ResultSet
{

    public AbstractJdbc3gResultSet(Query originalQuery, BaseStatement statement, Field[] fields, List tuples,
                                  ResultCursor cursor, int maxRows, int maxFieldSize, int rsType, int rsConcurrency, int rsHoldability) throws SQLException
    {
        super (originalQuery, statement, fields, tuples, cursor, maxRows, maxFieldSize, rsType, rsConcurrency, rsHoldability);
    }


    protected Object getUUID(String data) throws SQLException
    {
        UUID uuid;
        try {
            uuid = UUID.fromString(data);
        } catch (java.lang.IllegalArgumentException iae) {
            throw new PSQLException(GT.tr("Invalid UUID data."), PSQLState.INVALID_PARAMETER_VALUE, iae);
        }

        return uuid;
    }

    protected Object getUUID(byte[] data) throws SQLException
    {
        return new UUID(ByteConverter.int8(data, 0), ByteConverter.int8(data, 8));
    }
}

