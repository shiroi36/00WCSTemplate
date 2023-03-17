/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author keita
 */
public class xmlcontroller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    private final DocumentBuilderFactory dbf;
    private final Logger log;
    public xmlcontroller(){
        log = LogManager.getLogger(xmlcontroller.class);
        dbf = DocumentBuilderFactory.newInstance();
        
    }
    
    
    public String[] get3C() throws ParserConfigurationException, SAXException, IOException{
        
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("Mysetting.xml");
            log.info("Mysetting start");

            // ルート要素を取得
            Element root = doc.getDocumentElement();
            
            Element input3C=this.getElement(root, "input3C");
            
            return new String[] {
                this.getString(input3C, "year"),
                this.getString(input3C, "month"),
            };
    }
    
    public String[] get3B() throws ParserConfigurationException, SAXException, IOException{
        
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("Mysetting.xml");
            log.info("Mysetting start");

            // ルート要素を取得
            Element root = doc.getDocumentElement();
            
            Element input3B=this.getElement(root, "input3B");
            
            return new String[] {
                this.getString(input3B, "year"),
                this.getString(input3B, "month"),
            };
    }
    
    
    public String[] get3A() throws ParserConfigurationException, SAXException, IOException{
        
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("Mysetting.xml");
            log.info("Mysetting start");

            // ルート要素を取得
            Element root = doc.getDocumentElement();
            
            Element input3A=this.getElement(root, "input3A");
            return new String[] {
                this.getString(input3A, "year"),
                this.getString(input3A, "month"),
                this.getString(input3A, "nippo"),
                this.getString(input3A, "ninku"),
            };
    }
    
    public String[] getH2() throws ParserConfigurationException, SAXException, IOException{
        
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("Mysetting.xml");
            log.info("Mysetting start");

            // ルート要素を取得
            Element root = doc.getDocumentElement();
            
            Element h2=this.getElement(root, "h2");
            return new String[] {
                this.getString(h2, "url"),
                this.getString(h2, "uname"),
                this.getString(h2, "pw"),
            };
    }
    
    public Element getElement(Element root, String tag) {

        
        NodeList node = root.getChildNodes();
        for (int i = 0; i < node.getLength(); i++) {
            Node childNode = node.item(i);
            if (Node.ELEMENT_NODE == childNode.getNodeType()) {
                Element child = (Element) childNode;
                
                if (Objects.equals(child.getNodeName(), tag)) {
                    
                    NodeList node2 = child.getChildNodes();
                    return (Element) node2;
                    
                }
            }
        }
        return null;
    }

    public String getString(Element doc,String Tag){
        
        NodeList lst = doc.getElementsByTagName(Tag);
        String[] val1 = new String[lst.getLength()];
        for (int i = 0; i < lst.getLength(); i++) {
            Node n = lst.item(i);
            for (Node ch = n.getFirstChild(); ch != null; ch = ch.getNextSibling()) {
                val1[i] = ch.getNodeValue();
            }
        }
        
        return val1[0];
        
    }
    
    

}
