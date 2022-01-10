package edu.pucmm.isc581.applogin.asyncTasks;

import android.os.AsyncTask;
import edu.pucmm.isc581.applogin.azureRelated.ImageHelper;

public class DeleteImage extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... strings) {
        for (String nombre: strings)
            ImageHelper.deleteImages(nombre);
    return null;
    }
}
