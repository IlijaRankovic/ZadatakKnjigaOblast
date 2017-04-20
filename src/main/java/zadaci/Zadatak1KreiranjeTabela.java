package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Knjiga;
import model.Oblast;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by androiddevelopment on 20.4.17..
 */
public class Zadatak1KreiranjeTabela {

    public static void main(String[] args) {
        ConnectionSource conn = null;

        try {
            conn = new JdbcConnectionSource("jdb:sqlite:knjigaOblast.db");
            TableUtils.dropTable(conn, Oblast.class, true);
            TableUtils.dropTable(conn, Knjiga.class, true);

            TableUtils.clearTable(conn, Knjiga.class);
            TableUtils.clearTable(conn, Oblast.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
