package edu.pucmm.isc581.applogin.dbDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import edu.pucmm.isc581.applogin.dbEntities.Foto;

import java.util.List;

@Dao
public interface FotosDAO {

    @Insert
    List<Long> insertFotos(List<Foto> fotos);

    @Insert
    long insertFoto(Foto foto);

    @Query("SELECT * FROM Foto")
    List<Foto> getAllFotos();

    @Query("SELECT * FROM Foto WHERE idFoto = :idFoto")
    Foto getFoto(Long idFoto);

    @Query("SELECT * FROM Foto WHERE idArticulo = :idArt")
    List<Foto> getFotosFromArticulo(Long idArt);

    @Delete
    void deleteFotos(List<Foto> fotos);


}
