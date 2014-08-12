/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc4;

import java.util.Map;

import com.foundationdb.sql.jdbc.core.*;
import com.foundationdb.sql.jdbc.jdbc2.ArrayAssistantRegistry;
import com.foundationdb.sql.jdbc.jdbc4.array.UUIDArrayAssistant;

import java.sql.SQLException;
import java.sql.ResultSet;

public class Jdbc4Array extends com.foundationdb.sql.jdbc.jdbc2.AbstractJdbc2Array implements java.sql.Array
{
    static {
        ArrayAssistantRegistry.register(Oid.UUID, new UUIDArrayAssistant());
        ArrayAssistantRegistry.register(Oid.UUID_ARRAY, new UUIDArrayAssistant());
    }

    public Jdbc4Array(BaseConnection conn, int oid, String fieldString) throws SQLException
    {
        super(conn, oid, fieldString);
    }

    public Jdbc4Array(BaseConnection conn, int oid, byte[] fieldBytes) throws SQLException
    {
        super(conn, oid, fieldBytes);
    }

    public Object getArray(Map < String, Class < ? >> map) throws SQLException
    {
        return getArrayImpl(map);
    }

    public Object getArray(long index, int count, Map < String, Class < ? >> map) throws SQLException
    {
        return getArrayImpl(index, count, map);
    }

    public ResultSet getResultSet(Map < String, Class < ? >> map) throws SQLException
    {
        return getResultSetImpl(map);
    }

    public ResultSet getResultSet(long index, int count, Map < String, Class < ? >> map) throws SQLException
    {
        return getResultSetImpl(index, count, map);
    }

    public void free() throws SQLException
    {
        throw com.foundationdb.sql.jdbc.Driver.notImplemented(this.getClass(), "free()");
    }

}
