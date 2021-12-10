
package lab9p2_franciscovilleda_12111170;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminUsuarios {
    private ArrayList<Usuarios> users = new ArrayList();

    public adminUsuarios() {
        Dba db = new Dba("./Usuarios.mdb");
        db.conectar();
        try {
            db.query.execute("select Usuario,Nombre,Contraseña,Edad,Tipo from User");
            ResultSet rs = db.query.getResultSet();           
            while (rs.next()) {
                users.add(new Usuarios(rs.getString(2), rs.getString(1), rs.getString(3), rs.getString(5), rs.getInt(4)));
            }            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();
    }

    public ArrayList<Usuarios> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Usuarios> users) {
        this.users = users;
    }
    
}
