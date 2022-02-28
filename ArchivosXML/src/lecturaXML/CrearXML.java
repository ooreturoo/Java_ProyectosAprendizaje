package lecturaXML;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearXML {
	public static void main(String[] args) {
		List <Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Pepe","Gonzalez",'M', LocalDate.of(1989, 4, 23)));
		usuarios.add(new Usuario("Manuel","Perez",'M', LocalDate.of(1969, 6, 2)));
		usuarios.add(new Usuario("Pepa","Ruiz",'F', LocalDate.of(1999, 9, 29)));
		usuarios.add(new Usuario("Juan","Trujillo",'M', LocalDate.of(2000, 5, 13)));
		usuarios.add(new Usuario("Lorena","Jimenez",'F', LocalDate.of(1993, 1, 23)));
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element e = doc.createElement("clientes");
			doc.appendChild(e);
			
			for(int i = 0; i < usuarios.size(); i++) {
				Element usuario = doc.createElement("usuario");
				Element nombre = doc.createElement("nombre");
				Element apellido = doc.createElement("apellido");
				Element sexo = doc.createElement("sexo");
				Element fnacimiento = doc.createElement("fechaNacimiento");
				
				nombre.setTextContent(usuarios.get(i).getNombre());
				apellido.setTextContent(usuarios.get(i).getApellidos());
				sexo.setTextContent(String.valueOf(usuarios.get(i).getSexo()));
				fnacimiento.setTextContent(usuarios.get(i).getFechaNacimiento().toString());
				
				usuario.appendChild(nombre);
				usuario.appendChild(apellido);
				usuario.appendChild(sexo);
				usuario.appendChild(fnacimiento);
				
				e.appendChild(usuario);
			}
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/archivos/Usuarios.xml"));
			trans.transform(source, result);
			
			System.out.println("Creado");
			
			
			
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}
}
