package edu.pucmm.isc581.applogin.dbEntities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor
public class CarritoDeComprasPorUsuario {
    @Embedded private Usuario usuario;
    @Relation(parentColumn = "idUsuario", entityColumn = "idArticulo", associateBy = @Junction(CarritoDeCompra.class))
    private List<Articulo> articulos;
}