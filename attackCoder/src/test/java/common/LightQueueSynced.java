package common;

import com.google.common.base.Strings;

import java.util.LinkedList;
import java.util.List;

/**
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/4/12.
 */
public class LightQueueSynced {

    private static List<String> QUEUE_LIST = new LinkedList<String>();

    public static List<String> getQueueList(){
        return QUEUE_LIST;
    }

    public static synchronized void queue(String key){
        //System.out.println("add:"+seatNo);
        if(!Strings.isNullOrEmpty(key)&&!QUEUE_LIST.contains(key)){
            QUEUE_LIST.add(key);
        }
    }

    public static synchronized void remove(String key){
        QUEUE_LIST.remove(key);
    }

    public static synchronized String pollFirst(){
        if(QUEUE_LIST.size()==0){
            return null;
        }
        String seatNo = QUEUE_LIST.get(0);
        if(!Strings.isNullOrEmpty(seatNo)){
            QUEUE_LIST.remove(0);
        }
        return seatNo;
    }
}
