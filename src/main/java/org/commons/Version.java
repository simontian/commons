package org.commons;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Version {

	public static void main(String[] args) {
		
		try {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("pom.xml");
			Element element = document.getDocumentElement();
			NodeList nodes = element.getChildNodes();
			String version = null;
			for(int i = 0;i < nodes.getLength();i++) {
				Node node = nodes.item(i);
				if("version".equals(node.getNodeName())) {
					version = node.getTextContent();
					break;
				}
			}
			if(version == null || version == "") {
				System.out.println("Version is unknown");
			} else {
				System.out.println("Version is " + version);
			}
		} catch(Exception e) {
			System.out.println("Version is unknown");
		}
		
	}

}
