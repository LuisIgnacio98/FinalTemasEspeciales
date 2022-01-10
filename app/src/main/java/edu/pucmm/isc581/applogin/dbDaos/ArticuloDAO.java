package edu.pucmm.isc581.applogin.dbDaos;

import androidx.room.*;
import edu.pucmm.isc581.applogin.dbEntities.Articulo;
import edu.pucmm.isc581.applogin.dbEntities.ArticulosConFotosYCategoria;

import java.util.List;

@Dao
public interface ArticuloDAO {

    @Transaction @Query("SELECT * FROM Articulo")
    List<ArticulosConFotosYCategoria> getArticulos();

    @Transaction @Query("SELECT * FROM Articulo WHERE idArticulo = :id")
    ArticulosConFotosYCategoria getArticulo(Long id);

    @Insert
    long insertArticulo(Articulo articulo);

    @Transaction @Query("SELECT * FROM ARTICULO ORDER BY fechaCreacion DESC LIMIT 3")
    List<ArticulosConFotosYCategoria> getLatestArticulos();

    @Update
    void updateArticulo(Articulo articulo);

    @Query("SELECT COUNT(*) FROM ARTICULO WHERE idCategoria = :idCategoria")
    Integer cantArticulosConCategoria(Long idCategoria);

    @Query("SELECT * FROM ARTICULO WHERE idCategoria = :idCategoria")
    List<ArticulosConFotosYCategoria> articulosConCategoria(Long idCategoria);

    @Delete
    void deleteArticulo(Articulo articulo);


}
