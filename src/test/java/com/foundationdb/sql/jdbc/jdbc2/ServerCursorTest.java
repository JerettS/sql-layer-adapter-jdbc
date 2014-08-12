/*-------------------------------------------------------------------------
*
* Copyright (c) 2004-2011, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/
package com.foundationdb.sql.jdbc.jdbc2;

import java.sql.*;

import junit.framework.TestCase;

import com.foundationdb.sql.jdbc.TestUtil;

/*
 *  Tests for using non-zero setFetchSize().
 */
public class ServerCursorTest extends TestCase
{
    private Connection con;

    public ServerCursorTest(String name)
    {
        super(name);
    }

    protected void setUp() throws Exception
    {
        con = TestUtil.openDB();
        if(TestUtil.isFoundationDBServer(con)) {
            TestUtil.createTable(con, "test_fetch", "value integer, data tinyblob");
        } else {
            TestUtil.createTable(con, "test_fetch", "value integer,data bytea");
        }
        con.setAutoCommit(false);
    }

    protected void tearDown() throws Exception
    {
        con.rollback();
        con.setAutoCommit(true);
        TestUtil.dropTable(con, "test_fetch");
        TestUtil.closeDB(con);
    }

    protected void createRows(int count) throws Exception
    {
        PreparedStatement stmt = con.prepareStatement("insert into test_fetch(value,data) values(?,?)");
        for (int i = 0; i < count; ++i)
        {
            stmt.setInt(1, i + 1);
            stmt.setBytes(2, DATA_STRING.getBytes("UTF8"));
            stmt.executeUpdate();
        }
        con.commit();
    }

    //Test regular cursor fetching
    public void testBasicFetch() throws Exception
    {
        createRows(1);
        ResultSet rs;
        if (TestUtil.isFoundationDBServer(con)) {
            
            Statement stmt = con.createStatement();
            stmt.executeUpdate("PREPARE pstmt AS SELECT * FROM test_fetch");
            
            stmt.executeUpdate("DECLARE pcursor CURSOR FOR EXECUTE pstmt");
            rs = stmt.executeQuery("FETCH 5 FROM pcursor");
        }else {
            PreparedStatement stmt = con.prepareStatement("declare test_cursor cursor for select * from test_fetch");
            stmt.execute();

            stmt = con.prepareStatement("fetch forward from test_cursor");
            rs = stmt.executeQuery();
        }
        
        while (rs.next())
        {
            //there should only be one row returned
            assertEquals("query value error", 1, rs.getInt(1));
            byte[] dataBytes = rs.getBytes(2);
            assertEquals("binary data got munged", DATA_STRING, new String(dataBytes, "UTF8"));
        }
        if (TestUtil.isFoundationDBServer(con)) {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CLOSE pcursor");
            con.commit();
            stmt.executeUpdate("DEALLOCATE pstmt");
        }
    }

    //Test binary cursor fetching
    public void testBinaryFetch() throws Exception
    {
        // No binary cursor in foundationdDB
        if (TestUtil.isFoundationDBServer(con))
            return;
        createRows(1);

        PreparedStatement stmt = con.prepareStatement("declare test_cursor binary cursor for select * from test_fetch");
        stmt.execute();

        stmt = con.prepareStatement("fetch forward from test_cursor");
        ResultSet rs = stmt.executeQuery();
        while (rs.next())
        {
            //there should only be one row returned
            byte[] dataBytes = rs.getBytes(2);
            assertEquals("binary data got munged", DATA_STRING, new String(dataBytes, "UTF8"));
        }

    }

    //This string contains a variety different data:
    //  three japanese characters representing "japanese" in japanese
    //  the four characters "\000"
    //  a null character
    //  the seven ascii characters "english"
    private static final String DATA_STRING = "\u65E5\u672C\u8A9E\\000\u0000english";

}