package Requisito5;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlProject {

	private File inputFile;

	public XmlProject(File inputFile) {
		this.inputFile = inputFile;
	}
	
	public String queryRegioes() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		
		String query = "/RDF/NamedIndividual/@*";
		System.out.println("Query para obter a lista das regiões: " + query);
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		String aux = "";
		for (int i = 0; i < nl.getLength(); i++) {
			aux = aux + StringUtils.substringAfter(nl.item(i).getNodeValue(), "#");
		}
		return aux;
	}
	
	public String queryTestesAlgarve() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Algarve')]/Testes/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryInfecoesAlgarve() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Algarve')]/Infecoes/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryInternamentosAlgarve() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Algarve')]/Internamentos/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryTestesAlentejo() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Alentejo')]/Testes/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryInfecoesAlentejo() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Alentejo')]/Infecoes/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryInternamentosAlentejo() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Alentejo')]/Internamentos/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryTestesCentro() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Centro')]/Testes/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryInfecoesCentro() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Centro')]/Infecoes/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryInternamentosCentro() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Centro')]/Internamentos/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryTestesLisboa() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Lisboa')]/Testes/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryInfecoesLisboa() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Lisboa')]/Infecoes/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryInternamentosLisboa() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Lisboa')]/Internamentos/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryTestesNorte() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Norte')]/Testes/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryInfecoesNorte() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException{
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Norte')]/Infecoes/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	public String queryInternamentosNorte()throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		query = "//*[contains(@about,'Norte')]/Internamentos/text()";
		expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}
	
	/*public int querySomaInternamentoAlentejoAlgarve()throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		inputFile = new File("/Complemento5/covid19spreading.rdf");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		String query = "/RDF/NamedIndividual/@*";
		String query2 = "/RDF/NamedIndividual/@*";
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		XPathExpression expr2 = xpath.compile(query2);
		query = "//*[contains(@about,'Alentejo')]/Internamentos/text()";
		query2 = "//*[contains(@about,'Alentejo')]/Internamentos/text()";
		System.out.println(query);
		expr = xpath.compile(query);
		expr2 = xpath.compile(query2);
		return (String) expr.evaluate(doc, XPathConstants.STRING)+ (int)expr2.evaluate(doc, XPathConstants.STRING);
	}*/
	

	
}
