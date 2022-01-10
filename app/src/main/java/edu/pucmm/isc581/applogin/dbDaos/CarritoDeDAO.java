package edu.pucmm.isc581.applogin.dbDaos;

import androidx.room.*;
import edu.pucmm.isc581.applogin.dbEntities.CarritoDeCompra;

import java.util.List;

@Dao
public interface CarritoDeDAO {
    @Insert
    long insertCarritoDeCompras(CarritoDeCompra carritoDeCompra);

    @Update
    void updateCarritoDeCompras(CarritoDeCompra carritoDeCompra);

    @Delete
    void deleteCarritoDeCompras(CarritoDeCompra carritoDeCompra);

    @Query("SELECT COUNT(*) FROM CarritoDeCompra WHERE idArticulo = :idArt AND idUsuario = :idUser")
    Integer ArticleExistsInMyCarrito(Long idArt, Long idUser);

    @Query("SELECT * FROM CarritoDeCompra WHERE idArticulo = :idArt AND idUsuario = :idUser")
    CarritoDeCompra ArticleFromMyCarrito(Long idArt, Long idUser);

    @Query("SELECT * FROM CarritoDeCompra WHERE idUsuario = :idUser")
    List<CarritoDeCompra> MyCarritoDeCompras(Long idUser);
}
