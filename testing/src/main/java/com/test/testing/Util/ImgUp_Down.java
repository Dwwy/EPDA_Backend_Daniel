package com.test.testing.Util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.test.testing.parameter.UploadParameters;
import com.test.testing.response.OptionalResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;

public class ImgUp_Down {

    private static final String API_KEY = "ed11f5336082ae2f2e92f900f7e6af49";

    public static OptionalResponse uploadImage(MultipartFile file ) throws IOException{
        String url = "https://api.imgbb.com/1/upload";
        UploadParameters.Builder builder = new UploadParameters.Builder();
        builder.apiKey(API_KEY);
        builder.imageBase64(Base64.getEncoder().encodeToString((file.getBytes())));
        UploadParameters parameters = builder.build();
        try {
            Connection.Response response = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .method(Connection.Method.POST)
                    .data(parameters.toMap())
                    .execute();
            return OptionalResponse.of(response);
        } catch (IOException ex) {
            throw new RuntimeException("I/O exception was catched while try to upload image!", ex);
        }
    }
}
