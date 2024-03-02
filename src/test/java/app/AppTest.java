package app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppTest{
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    private KYCDatabaseRemote kycDatabaseRemote;

    @Before
    public void initialize(){
        kycDatabaseRemote=new KYCDatabaseRemote(connection);
    }

    @Test
    public void testSave()throws SQLException {
        KYC kyc=new KYC(12,"Razak Mohamed S",123.45);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);
        kycDatabaseRemote.save(kyc);
        verify(preparedStatement).setString(1,"Razak Mohamed S");
        verify(preparedStatement).setDouble(2,123.45);
        verify(preparedStatement).executeUpdate();
    }

    public void testFindAll(){

    }
}
