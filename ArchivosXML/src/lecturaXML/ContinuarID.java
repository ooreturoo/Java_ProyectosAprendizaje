package lecturaXML;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class ContinuarID {
	public static void main(String[] args) {
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src/archivos/Usuarios.xml");
			boolean encontrado = false;
			Node node = doc.getDocumentElement().getLastChild();
			String id = "";
			
			while(node != null && !encontrado) {
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					if(node.getAttributes().getNamedItem("id") != null) {
						id = node.getAttributes().item(0).getNodeValue();
						encontrado = true;
					}
				}
				
				node = node.getPreviousSibling();
				
			}
			
			
			System.out.println(id);
			
		} catch (SAXException e) {
		
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		}
		
	}
}
