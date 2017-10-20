package ffmpeg;

import java.io.*;

/**
 * Created by gaopeng on 2017/9/6.
 */
public class FfmpegHelper {
    private static String BASE_EXE="cmd /c echo y | C:\\Users\\gaopeng\\Downloads\\ffmpeg-20170904-6cadbb1-win64-static\\bin\\ffmpeg";

    public static String getBaseExe() {
        return BASE_EXE;
    }

    public static void imageAndMp3ToMp4(String imgPath,String mp3Path,String mp4Path){
        Runtime run=Runtime.getRuntime();
        StringBuffer commond=new StringBuffer();
        commond.append(BASE_EXE);
        commond.append(" -r 25 -f image2 -loop 1 -i ");
        commond.append(imgPath);
        commond.append(" -i ");
        commond.append(mp3Path);
        commond.append(" -pix_fmt yuv420p -t 60 -vcodec mpeg4 ");
        commond.append(mp4Path);
        //commond.append(" -help");
        Process process=null;
        try {
            System.out.println(commond.toString());
            process=run.exec(commond.toString());
            outErrorStream(process.getErrorStream());
            outInputStream(process.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void merge2Audio(String firstAudioPath,String secondAudioPath,String outfilePath){
        StringBuffer commond=new StringBuffer();
        commond.append(BASE_EXE);
        commond.append(" -i ");
        commond.append("\"concat:");
        commond.append(firstAudioPath);
        commond.append("|");
        commond.append(secondAudioPath);
        commond.append("\" ");
        commond.append("-c copy ");
        commond.append(outfilePath);
        Runtime run=Runtime.getRuntime();
        Process process=null;
        try {
            System.out.println(commond.toString());
            process=run.exec(commond.toString());
            outErrorStream(process.getErrorStream());
            outInputStream(process.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void pcm2mp3(String pcmFile,String mp3File){
        //ffmpeg -f s16le -ar 16.0k -ac 1 -i test.pcm test03.mp3
        StringBuffer commond=new StringBuffer();
        commond.append(BASE_EXE);
        commond.append(" -f s16le -ar 16.0k -ac 1 -i ");
        commond.append(pcmFile+" ");
        commond.append(mp3File);
        Runtime run= Runtime.getRuntime();
        Process process=null;
        try {
            System.out.println(commond.toString());
            process=run.exec(commond.toString());
            outErrorStream(process.getErrorStream());
            outInputStream(process.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            process.destroy();
        }
    }
    private static void outInputStream(InputStream inputStream){
        String line = null;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(inputStream));
        try {
            line = bufferedReader.readLine();
            while (line!= null) {
                sb.append(line + "\n");
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void outErrorStream(InputStream inputStream){
        Thread t=new Thread(new InputStreamRunnable(inputStream,"errorStream"));
        t.start();
    }
}
/**读取InputStream的线程*/
class InputStreamRunnable implements Runnable
{
    BufferedReader bReader=null;
    String type=null;
    public InputStreamRunnable(InputStream is, String _type)
    {
        try
        {
            bReader=new BufferedReader(new InputStreamReader(new BufferedInputStream(is),"UTF-8"));
            type=_type;
        }
        catch(Exception ex)
        {
        }
    }
    public void run()
    {
        String line;
        int lineNum=0;

        try
        {
            line=bReader.readLine();
            while(line!=null)
            {
                lineNum++;
                System.out.println(line);
                line=bReader.readLine();
            }
            bReader.close();
        }
        catch(Exception ex)
        {
        }
    }
}
