package common;

import com.google.common.base.Strings;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * All right reserved.
 * Created by liuyaqing@sangame.com on 2016/4/12.
 */
public class LightQueueConcurrent {

    private static ConcurrentLinkedDeque<String> QUEUE_LIST = new ConcurrentLinkedDeque<String>();

    public static ConcurrentLinkedDeque<String> getQueueList(){
        return QUEUE_LIST;
    }

    public static void queue(String seatNo){
        //System.out.println("add:"+seatNo);
        if(!Strings.isNullOrEmpty(seatNo)&&!QUEUE_LIST.contains(seatNo)){
            QUEUE_LIST.add(seatNo);
        }
    }

    public static void remove(String seatNo){
        QUEUE_LIST.remove(seatNo);
    }

    public static String pollFirst(){
        if(QUEUE_LIST.size()==0){
            return null;
        }
        String seatNo = QUEUE_LIST.removeFirst();
        return seatNo;
    }
}
