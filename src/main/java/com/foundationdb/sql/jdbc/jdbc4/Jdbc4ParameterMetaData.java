/*-------------------------------------------------------------------------
*
* Copyright (c) 2005-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc4;

import java.sql.ParameterMetaData;

import com.foundationdb.sql.jdbc.core.BaseConnection;

public class Jdbc4ParameterMetaData extends AbstractJdbc4ParameterMetaData implements ParameterMetaData {

    public Jdbc4ParameterMetaData(BaseConnection connection, int oids[])
    {
        super(connection, oids);
    }

}

