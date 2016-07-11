package distributed;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/6/22.
 */
public class state {

    interface Context {
        ByteBuffer buffer();
        State state();
        void state(State state);
    }
    interface State {
        /**
         * @return true to keep processing, false to read more data.
         */
        boolean process(Context context);
    }
/*    enum States implements State {
        XML {
            public boolean process(Context context) {
                if (context.buffer().remaining() < 16) return false;
                // read header
                if(headerComplete)
                    context.state(States.ROOT);
                return true;
            }
        }, ROOT {
            public boolean process(Context context) {
                if (context.buffer().remaining() < 8) return false;
                // read root tag
                if(rootComplete)
                    context.state(States.IN_ROOT);
                return true;
            }
        }
    }

    public void process(Context context) {
        socket.read(context.buffer());
        while(context.state().process(context));
    }*/

    @Test
    public void xmlParser(){
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            //DOM parser instance
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            //parse an XML file into a DOM tree
            document = builder.parse(new File("C:\\Users\\admin\\Desktop\\a.xml"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(document.getDocumentElement().getTagName());
    }
}
