package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class KYCDatabaseRemote implements KYCRemote{
    private Connection connection;
    public KYCDatabaseRemote(Connection connection){
        this.connection=connection;
    }
    @Override
    public void save(KYC kyc) {
        String query="insert into kycs values (kycs_seq.nextval,?,?)";
        try{
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,kyc.getName());
            preparedStatement.setDouble(2,kyc.getBalance());
            int info=preparedStatement.executeUpdate();
            if(info!=0){
                System.out.println("REcord has inserted");
            }
            else{
                System.out.println("Record hasn't inserted");
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }

    @Override
    public KYC findById(int id) {
        return null;
    }

    @Override
    public List<KYC> findAll() {
        return null;
    }

    @Override
    public void update(KYC kyc) {

    }

    @Override
    public void delete(int id) {

    }
}
