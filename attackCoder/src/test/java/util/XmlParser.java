package util;

import com.sun.org.apache.xerces.internal.dom.CoreDocumentImpl;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/6/22.
 */
public class XmlParser {

    interface State {

    }

    @Test
    public void main() throws IOException, ParserConfigurationException {

        /*DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.newDocument();*/
        Document document = new CoreDocumentImpl();
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream("C:\\Users\\admin\\Desktop\\a.xml"));
        //char[] buffer = new char[100];00
        int buffer;
        while (true){
            buffer = streamReader.read();
            if(buffer!=-1) {
                System.out.print((char)buffer);
            }else{
                break;
            }
        }
        Element root = document.createElement("sss");
        root.setNodeValue("hhh");
        Text oText = document.createTextNode("你好");
        root.appendChild( oText );
        document.appendChild(root);
        System.out.println(document.getDocumentElement());
    }
}
