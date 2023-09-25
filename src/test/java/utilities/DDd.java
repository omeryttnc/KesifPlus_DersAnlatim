package utilities;

import org.junit.Test;

public class DDd {
    @Test
    public void name() {
        DatabaseUtilities.createMysqlConnection();
        System.out.println("DatabaseUtilities.getUsersInfoMysql() = " + DatabaseUtilities.getUsersInfoMysql());
    }
}
