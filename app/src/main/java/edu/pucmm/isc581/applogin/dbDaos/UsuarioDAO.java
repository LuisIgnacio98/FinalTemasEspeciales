package edu.pucmm.isc581.applogin.dbDaos;

import androidx.room.*;
import edu.pucmm.isc581.applogin.dbEntities.CarritoDeComprasPorUsuario;
import edu.pucmm.isc581.applogin.dbEntities.Usuario;

@Dao
public interface UsuarioDAO {

    @Query("SELECT password from USUARIO where email = :email")
    String getPasswordByEmail(String email);

  //  @Transaction @Query("SELECT * FROM USUARIO WHERE email = :email")
    //OrdenesDelUsuario getUserWithOrders(String email);

    @Transaction @Query("SELECT * FROM USUARIO WHERE email = :email")
    CarritoDeComprasPorUsuario getShoppingCart(String email);

    @Transaction @Query("SELECT * FROM USUARIO WHERE email = :email AND password = :password")
    Usuario getUserForLogin(String email, String password);

    @Insert
    long registerUser(Usuario usuario);

    @Update
    void updateUser(Usuario usuario);

    @Delete
    void deleteUser(Usuario usuario);


}
