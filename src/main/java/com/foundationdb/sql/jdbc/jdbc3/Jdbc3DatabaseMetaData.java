/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc3;


public class Jdbc3DatabaseMetaData extends com.foundationdb.sql.jdbc.jdbc3.AbstractJdbc3DatabaseMetaData implements java.sql.DatabaseMetaData
{

    public Jdbc3DatabaseMetaData(Jdbc3Connection conn)
    {
        super(conn);
    }

}
