package edu.pucmm.isc581.applogin.asyncTasks;

import android.os.AsyncTask;
import edu.pucmm.isc581.applogin.azureRelated.ImageHelper;
import edu.pucmm.isc581.applogin.dbEntities.Foto;

import java.util.List;

public class DeleteImages extends AsyncTask<List<Foto>, Void, Void> {

    @Override
    protected Void doInBackground(List<Foto>... lists) {
        for (List<Foto> lista: lists)
            for (Foto foto: lista)
                ImageHelper.deleteImages(foto.getLinkImagen());
        return null;
    }
}
