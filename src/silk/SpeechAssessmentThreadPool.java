package silk;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gaopeng on 2017/10/20.
 */
public class SpeechAssessmentThreadPool {
    private static Logger logger = LogManager.getLogger(SpeechAssessmentThreadPool.class);
    private static ExecutorService executorService;
    private static int MAXTHREADNUM_DEFAULT = 10;

    public SpeechAssessmentThreadPool() {
    }
    public static ExecutorService getSpeechAssessmentThread(){
        if(executorService == null)
            executorService = Executors.newFixedThreadPool(MAXTHREADNUM_DEFAULT);
        return executorService;
    }
    public static ExecutorService getSpeechAssessmentThread(int threadNum){
        if(executorService == null)
            executorService = Executors.newFixedThreadPool(threadNum);
        return executorService;
    }
    public void execute(Runnable thread){
        isExecutorServiceNotNull();
        executorService.execute(thread);
    }
    public static void isExecutorServiceNotNull(){
        if(executorService == null)
            throw new RuntimeException("SpeechAssessmentThreadPool.getSpeechAssessmentThread()获取executorService后执行该方法");
    }
    public static void shutdown(Boolean isForce){
        isExecutorServiceNotNull();
        if(isForce){
            executorService.shutdownNow();
        }else {
            executorService.shutdown();
            //executorService.awaitTermination();
        }
    }
}
