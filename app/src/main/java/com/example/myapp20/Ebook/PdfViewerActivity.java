package com.example.myapp20.Ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.myapp20.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfViewerActivity extends AppCompatActivity {
private String url;
private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        url=getIntent().getStringExtra("url");
        pdfView = findViewById(R.id.pdfView);
        new PdfDownload().execute(url);
    }
    public class PdfDownload extends AsyncTask<String,Void, InputStream>{

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream =null;
            try {
                URL url=new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode()==200){
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }
    }
}