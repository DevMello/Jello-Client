package me.dev.util;

import com.mentalfrostbyte.jello.music.music.Player;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebUtils2 {
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
                    File file;
                    System.out.println(System.getProperty("user.dir"));
                    /*
                    if (launchedFromOfficalLauncher = true) {
                        final String userPath = System.getProperty("user.dir");
                    }

                     */
                    String userPath = String.valueOf(file = new File(new File(System.getenv("APPDATA")), ".minecraft"));

                    String downloadUtils = System.getProperty("user.dir") + "/music";
                    File music = new File(downloadUtils + File.separator + "youtube.exe");

                    if(new File(System.getProperty("user.dir") + "/music/youtube.exe").exists()) {
                        System.out.println("youtube exists");
                    } else {
                        FileUtils.copyURLToFile(new URL("https://raw.githubusercontent.com/DevMello/JelloClientRemade/main/youtube-dl.exe"), music);
                    }






                    if (launchedFromOfficalLauncher = true) {
                        userPath = System.getProperty("user.dir");
                    }


                    String udlExec = userPath +"/music/youtube.exe";
                    System.out.println("created executable variable");
                    final String system = System.getProperty("os.name").toLowerCase();
                    if (new File(userPath +"/music").exists()) {
                        System.out.println("exists");
                    }else {
                        File f1 = new File(userPath +"/music");
                        boolean creation = f1.mkdir();
                        if(creation){
                            System.out.println("Folder is created successfully");
                        }else{
                            System.out.println("Error Found!");
                        }

                    }
                    //System.out.println(userPath);
                    //File path = new File(String.valueOf(userPath)+"/music").getAbsoluteFile();
                    File file4 = new File(userPath +"music/audioDownload.mp3");
                    boolean bool = false;
                    boolean bool2 = false;
                    if (new File(userPath +"/music/audioDownload.mp3").exists()) {
                        bool = file4.delete();
                    }


                    System.out.println(userPath +"/music");


                    String cmd = udlExec + " -o " + userPath +"/music/audioDownload.%%(ext)s" +" --extract-audio --audio-format \"mp3\" --audio-quality 0 https://www.youtube.com/watch?v=" + urly;
                    System.out.println("Wrote command");
                    Process p = Runtime.getRuntime().exec(cmd);
                    System.out.println("executed command");

                    //System.out.println("buffered reader");




                    //String line;


                    while(true) {
                        BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        String newLine = bf.readLine();
                        if(newLine == null){
                            bf.close();
                            break;
                        }
                        System.out.println(newLine);
                    }

                    File tester = new File(userPath +"/music/audioDownload.mp3");

                    Player.play("file:///" + userPath +"/music/audioDownload.mp3");






                    System.out.println("file:///" + userPath +"/music/audioDownload.mp3");
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
                                //  	Jello.addChatMessage(String.valueOf(c));
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
