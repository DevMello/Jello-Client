package com.youtube;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.music.music.Player;
import org.apache.commons.io.FileUtils;

import javax.sound.sampled.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.lwjgl.Sys;

import java.util.List;

import java.util.Map;

public class WebUtils {


    public static String agent1 = "User-Agent";
    public static String agent2 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36";
    public static boolean launchedFromOfficalLauncher;
    public static String visitSiteThreaded(final String urly){
        final List<String> lines = new ArrayList<String>();
        String stuff = "";
        (new Thread(new Runnable()
        {
            public void run()
            {
                URL url;
                try {
                    String line;


                    url = new URL(urly);

                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                    connection.addRequestProperty(agent1, agent2);
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    while ((line = in.readLine()) != null) {
                        lines.add(line);
                    }

                }

                catch (Exception e) {

                }

            }
        })).start();
        for(String s : lines){
            stuff += s;
        }
        return stuff;

    }

    public void playMusicLink(final String urly){
        List<URL> lines = new ArrayList<URL>();
        String stuff = "";
        (new Thread(new Runnable()
        {
            public void run()
            {
                URL url;
                try {

                    System.out.println("Attempting to play video with ID " + urly);
                    File youtube = new File(System.getenv("APPDATA") + File.separator + ".minecraft/music/youtube-dl.exe");
                    if(!youtube.exists()){
                        File f1 = new File(System.getenv("APPDATA") + File.separator + ".minecraft/music/");
                        boolean creation = f1.mkdir();
                        FileUtils.copyURLToFile(new URL("https://objects.githubusercontent.com/github-production-release-asset-2e65be/1039520/8e86f072-4cf3-4ba1-bd20-c0b6e18345c4?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20220701%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20220701T190450Z&X-Amz-Expires=300&X-Amz-Signature=bbedf44a4e42eb43da5696bd900f5d9653cd1a11f35cf3f628c8bfe3b3a75b61&X-Amz-SignedHeaders=host&actor_id=69360966&key_id=0&repo_id=1039520&response-content-disposition=attachment%3B%20filename%3Dyoutube-dl.exe&response-content-type=application%2Foctet-stream"), youtube);
                    }
                    String cmd = youtube + " -j " + urly;
                    System.out.println("Wrote command " + cmd);
                    Process p = Runtime.getRuntime().exec(cmd);
                    String json = "";
                    while(true) {
                        BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        String newLine = bf.readLine();
                        if(newLine == null){
                            bf.close();
                            break;
                        }
                        System.out.println(newLine);
                        json = newLine;
                    }
                    System.out.println(json);
                    Object obj = new JSONParser().parse(json);
                    System.out.println("Parsed JSON");

                    JSONObject jsonObject = (JSONObject) obj;
                    System.out.println(jsonObject.get("duration"));
                    Jello.jgui.music.currentSongLength = Integer.valueOf(jsonObject.get("duration").toString());
                    Player.play("http://localhost:7331/"+urly);
                    System.out.println("Now Playing");
                }

                catch (Exception e) {

                }

            }
        })).start();


    }

    public static List<String> visitSiteThreadedFriends(final String urly){
        final List<String> lines = new ArrayList<String>();
        try
        {
            (new Thread(new Runnable()
            {
                public void run()
                {
                    URL url;
                    try {
                        String line;
                        url = new URL(urly);

                        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                        connection.addRequestProperty(agent1, agent2);
                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        while ((line = in.readLine()) != null) {
                            if(!line.isEmpty() && !line.equals(" ") && !line.equals("   ")){
                                lines.add(line.contains(" ") ? line.replace(" ", "") : line);

                                //  for(char c : line.toCharArray()){
                                //Jello.addChatMessage(String.valueOf(c));
                                //   }
                            }

                        }

                    }

                    catch (Exception e) {

                    }

                }
            })).start();
        }
        catch (RuntimeException runtimeexception)
        {
        }

        return lines;

    }

    public static String visitSite(String urly){
        ArrayList<String> lines = new ArrayList<String>();
        String stuff = "";
        URL url;
        try {
            String line;
            url = new URL(urly);

            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.addRequestProperty(agent1, agent2);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            //System.out.println("HEY");
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }

        }

        catch (Exception e) {

        }
        for(String s : lines){
            stuff += s;
        }
        return stuff;

    }


}
