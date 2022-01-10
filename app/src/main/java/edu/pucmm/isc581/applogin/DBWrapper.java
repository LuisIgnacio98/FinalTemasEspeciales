package edu.pucmm.isc581.applogin;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.pucmm.isc581.applogin.dbDaos.ArticuloDAO;
import edu.pucmm.isc581.applogin.dbDaos.CarritoDeDAO;
import edu.pucmm.isc581.applogin.dbDaos.CategoriaDAO;
import edu.pucmm.isc581.applogin.dbDaos.FotosDAO;
import edu.pucmm.isc581.applogin.dbDaos.UsuarioDAO;
import edu.pucmm.isc581.applogin.dbEntities.*;
import edu.pucmm.isc581.applogin.dbEntities.Articulo;
import edu.pucmm.isc581.applogin.dbEntities.CarritoDeCompra;
import edu.pucmm.isc581.applogin.dbEntities.Categoria;
import edu.pucmm.isc581.applogin.dbEntities.Foto;
import edu.pucmm.isc581.applogin.dbEntities.Usuario;

@Database(entities = {Articulo.class, CarritoDeCompra.class, Categoria.class, Foto.class, Usuario.class}, version = 6)
public abstract class DBWrapper extends RoomDatabase {
    public abstract ArticuloDAO getArticuloDAO();
    public abstract CategoriaDAO getCategoriaDAO();
    public abstract FotosDAO getFotosDAO();
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract CarritoDeDAO getCarritoDeDAO();
}
