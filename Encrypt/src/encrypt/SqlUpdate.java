package encrypt;
        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class SqlUpdate{
    void insert(String username,String filename,String fsize,String nfilename,String date){
    Connection con=null;
        try{
            String url="jdbc:mysql://localhost:3306/hello?useSSL=false";
            String user="root";
            String pass="1234";
            con=DriverManager.getConnection(url,user,pass);
            String str="insert into history values(?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(str);
            pstmt.setString(1,username);
            pstmt.setString(2,filename);
            pstmt.setString(3,fsize);
            pstmt.setString(4,nfilename);
            pstmt.setString(5,date);
            int i=pstmt.executeUpdate();
                //System.out.print(rs.getString(1)+" "+rs.getString(2)+"\n");
                if(pstmt!=null)
                    pstmt.close();
         
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally{
            try{
                if(con!=null)
                con.close();
                
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        }
}

}