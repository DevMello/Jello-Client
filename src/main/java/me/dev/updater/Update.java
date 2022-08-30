package me.dev.updater;

import me.dev.Dev;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.swing.*;
import java.io.IOException;
import java.io.Reader;

public class Update {


    public static void checkVersion()
    {
        try {
            String version = getCurrentVersion();

            // Check for new version
            String latestVersion = getLatestVersion();

            if(latestVersion!=null && !latestVersion.equals(version))
            {
                JOptionPane.showMessageDialog(null, "<html><body><p style='width: 400px;'>"+"New Version Available. Will update on shutdown", "Update", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Error e) {
            e.printStackTrace();
        }
        // Get current version number

    }

    public static String getCurrentVersion()
    {
        if(Dev.clientVersion!=null)
            return Dev.clientVersion;
        else
            return "UNKNOWN";
    }

    public static String getLatestVersion()
    {
        try
        {
            Response response = new OkHttpClient.Builder().build()
                    .newCall(new Request.Builder().get().url("https://tracker.py4.repl.co/version").build())
                    .execute();
            ResponseBody body = response.body();
            if(body != null)
            {
                try(Reader reader = body.charStream())
                {
                    JSONObject obj = new JSONObject(new JSONTokener(reader));
                    System.out.println(obj.getString("version"));
                    return obj.getString("version");
                }
                finally
                {
                    response.close();
                }
            }
            else
                return null;
        }
        catch(IOException | JSONException | NullPointerException ex)
        {
            return null;
        }
    }
}