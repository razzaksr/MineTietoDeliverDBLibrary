package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseStorageStrategy implements StorageStrategy{

    private Connection connection;

    public DatabaseStorageStrategy(){
        try {
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public KYCRemote getKycRemote() {
        return new KYCDatabaseRemote(connection);
    }
}
