/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc2.optional;

import com.foundationdb.sql.jdbc.TestUtil;
import com.foundationdb.sql.jdbc.jdbc2.optional.SimpleDataSource;

/**
 * Performs the basic tests defined in the superclass. Just adds the
 * configuration logic.
 *
 * @author Aaron Mulder (ammulder@chariotsolutions.com)
 */
public class SimpleDataSourceTest extends BaseDataSourceTest
{
    /**
     * Constructor required by JUnit
     */
    public SimpleDataSourceTest(String name)
    {
        super(name);
    }

    /**
     * Creates and configures a new SimpleDataSource.
     */
    protected void initializeDataSource()
    {
        if (bds == null)
        {
            bds = new SimpleDataSource();
            setupDataSource(bds);
        }
    }
}
