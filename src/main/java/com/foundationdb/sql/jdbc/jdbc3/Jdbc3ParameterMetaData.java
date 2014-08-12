/*-------------------------------------------------------------------------
*
* Copyright (c) 2005-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc3;

import java.sql.ParameterMetaData;

import com.foundationdb.sql.jdbc.core.BaseConnection;

public class Jdbc3ParameterMetaData extends AbstractJdbc3ParameterMetaData implements ParameterMetaData {

    public Jdbc3ParameterMetaData(BaseConnection connection, int oids[])
    {
        super(connection, oids);
    }

}

