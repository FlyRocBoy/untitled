package silk;

import java.io.*;

/**
 * Created by gaopeng on 2017/10/20.
 */
public class SilkV3Helper {
    //C:\Users\gaopeng\Downloads\silk2mp3\silk_v3_decoder
    //C:\Users\gaopeng\Downloads\silk2mp3\silk_v3_encoder
    private static String SILK_V3_DECODER_EXE="cmd /c echo y | C:\\Users\\gaopeng\\Downloads\\silk2mp3\\silk_v3_decoder";
    private static String SILK_V3_ENCODER_EXE="cmd /c echo y | C:\\Users\\gaopeng\\Downloads\\silk2mp3\\silk_v3_encoder";


    public static String getSilkV3DecoderExe() {
        return SILK_V3_DECODER_EXE;
    }

    public static void setSilkV3DecoderExe(String silkV3DecoderExe) {
        SILK_V3_DECODER_EXE = silkV3DecoderExe;
    }

    public static String getSilkV3EncoderExe() {
        return SILK_V3_ENCODER_EXE;
    }

    public static void setSilkV3EncoderExe(String silkV3EncoderExe) {
        SILK_V3_ENCODER_EXE = silkV3EncoderExe;
    }

    public static void silk2pcm(String silkPath,String pcmPath){
        Runtime run= Runtime.getRuntime();
        StringBuffer commond=new StringBuffer();
        commond.append(getSilkV3DecoderExe());
        commond.append(" "+silkPath);
        commond.append(" "+pcmPath);
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
    private static void outInputStream(InputStream inputStream){
        String line = null;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(inputStream));
        try {
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
                System.out.println(line);
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
            while((line=bReader.readLine())!=null)
            {
                lineNum++;
                System.out.println(line);
                //Thread.sleep(200);
            }
            bReader.close();
        }
        catch(Exception ex)
        {
        }
    }
}


