package edu.pucmm.isc581.applogin.dbDaos;

import androidx.room.*;
import edu.pucmm.isc581.applogin.dbEntities.Categoria;

import java.util.List;

@Dao
public interface CategoriaDAO {
    @Insert
    Long insertCategoria(Categoria categoria);

    @Update
    void updateCategoria(Categoria categoria);

    @Delete
    void deleteCategoria(Categoria categoria);

    @Query("SELECT * FROM CATEGORIA")
    List<Categoria> getCategorias();

    @Query("SELECT nombre FROM CATEGORIA")
    List<String> getNombreCategorias();

    @Query("SELECT * FROM CATEGORIA WHERE idCategoria = :id")
    Categoria getCategoria(long id);



}
