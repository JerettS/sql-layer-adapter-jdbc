/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc3g;


import java.sql.*;

public class Jdbc3gBlob extends com.foundationdb.sql.jdbc.jdbc3.AbstractJdbc3Blob implements java.sql.Blob
{

    public Jdbc3gBlob(com.foundationdb.sql.jdbc.core.BaseConnection conn, long oid) throws SQLException
    {
        super(conn, oid);
    }

}
