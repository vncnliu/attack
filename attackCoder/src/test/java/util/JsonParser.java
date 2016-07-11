package util;

import org.json.JSONObject;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/6/22.
 */
public class JsonParser {

    interface State {

        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        void process(int buffer,State last,JSONObject jsonObject);

    }

    enum JsonState implements State{

        READY {
            @Override
            public void process(int buffer,State last,JSONObject jsonObject) {
                if(VALUE.equals(last)){

                }
            }
        },
        BEGIN {
            @Override
            public void process(int buffer,State last,JSONObject jsonObject) {
                if(!READY.equals(last)){
                    jsonObject.put(key.toString(),value.toString());
                    key.delete(0,key.length());
                    value.delete(0,value.length());
                }
            }
        },
        TEXT {
            @Override
            public void process(int buffer,State last,JSONObject jsonObject) {
                if(BEGIN.equals(last)){
                    key.append((char)buffer);
                }else if(VALUE.equals(last)){
                    value.append((char)buffer);
                }
            }
        },
        VALUE {
            @Override
            public void process(int buffer,State last,JSONObject jsonObject) {
                System.out.println("value");
            }
        },
        END {
            @Override
            public void process(int buffer,State last,JSONObject jsonObject) {
                jsonObject.put(key.toString(),value.toString());
            }
        }
    }

    @Test
    public void main() throws IOException {

        JSONObject jsonObject = new JSONObject();
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream("C:\\Users\\admin\\Desktop\\a.json"));
        int buffer;
        State state = JsonState.READY;
        State lastState = null;
        while (true){
            buffer = streamReader.read();
            if(buffer!=-1) {
                switch ((char)buffer){
                    case '{' : lastState = state; state = JsonState.BEGIN;break;
                    case ',' : lastState = state; state = JsonState.BEGIN;state.process(buffer,lastState,jsonObject);break;
                    case '"' : lastState = state; state = JsonState.TEXT;break;
                    case ':' : lastState = state; state = JsonState.VALUE;break;
                    case '}' : lastState = state; state = JsonState.END;state.process(buffer,lastState,jsonObject);break;
                    default : state.process(buffer,lastState,jsonObject);
                }
            }else{
                break;
            }
        }
        System.out.println(jsonObject.get("hhh"));
    }
}
