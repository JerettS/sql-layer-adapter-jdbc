/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc3g;


public class Jdbc3gClob extends com.foundationdb.sql.jdbc.jdbc3.AbstractJdbc3Clob implements java.sql.Clob
{

    public Jdbc3gClob(com.foundationdb.sql.jdbc.core.BaseConnection conn, long oid) throws java.sql.SQLException
    {
        super(conn, oid);
    }

}
