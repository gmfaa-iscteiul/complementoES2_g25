package Requisito5;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.xml.sax.SAXException;

public class App {
	
	public App() throws InvalidRemoteException, TransportException, GitAPIException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		File dir = new File("/Complemento5");
		Git git;
		if(!dir.exists())
			git = Git.cloneRepository().setURI("https://github.com/vbasto-iscte/ESII1920.git").setDirectory(dir).call();
		else{
			git = Git.open(new File("/Complemento5"));
			git.pull();
			git.checkout();
		}
		File ficheiro = new File("/Complemento5/covid19spreading.rdf");
		//new XmlProject(ficheiro);
		
		String queryRegioes = new XmlProject(ficheiro).queryRegioes();
		String queryTestesAlgarve = new XmlProject(ficheiro).queryTestesAlgarve();
		String queryTestesAlentejo = new XmlProject(ficheiro).queryTestesAlentejo();
		String queryTestesCentro = new XmlProject(ficheiro).queryTestesCentro();
		String queryTestesLisboa = new XmlProject(ficheiro).queryTestesLisboa();
		String queryTestesNorte = new XmlProject(ficheiro).queryTestesNorte();
		String queryInternamentosAlgarve = new XmlProject(ficheiro).queryInternamentosAlgarve();
		String queryInternamentosAlentejo = new XmlProject(ficheiro).queryInternamentosAlentejo();
		String queryInternamentosCentro = new XmlProject(ficheiro).queryInternamentosCentro();
		String queryInternamentosLisboa = new XmlProject(ficheiro).queryInternamentosLisboa();
		String queryInternamentosNorte = new XmlProject(ficheiro).queryInternamentosNorte();
		String queryInfecoesAlgarve = new XmlProject(ficheiro).queryInfecoesAlgarve();
		String queryInfecoesAlentejo = new XmlProject(ficheiro).queryInfecoesAlentejo();
		String queryInfecoesCentro = new XmlProject(ficheiro).queryInfecoesCentro();
		String queryInfecoesLisboa = new XmlProject(ficheiro).queryInfecoesLisboa();
		String queryInfecoesNorte = new XmlProject(ficheiro).queryInfecoesNorte();
		int somaInternamentosAlentejoAlgarve = Integer.parseInt(queryInternamentosAlgarve) + Integer.parseInt(queryInternamentosAlentejo);
		String querySomaInternamentoAlentejoAlgarve = String.valueOf(somaInternamentosAlentejoAlgarve);
		int internamentoCentro = 0;
		if(!queryInternamentosCentro.contentEquals("")) {
			internamentoCentro = Integer.parseInt(queryInternamentosCentro);
		}
		int internamentoNorte = 0;
		if(!queryInternamentosNorte.contentEquals("")) {
			internamentoNorte = Integer.parseInt(queryInternamentosNorte);
		}
		int internamentoLisboa = 0;
		if(!queryInternamentosLisboa.contentEquals("")) {
			internamentoLisboa = Integer.parseInt(queryInternamentosLisboa);
		}
		int internamentoAlentejo = 0;
		if(!queryInternamentosAlentejo.contentEquals("")) {
			internamentoAlentejo = Integer.parseInt(queryInternamentosAlentejo);
		}
		int internamentoAlgarve = 0;
		if(!queryInternamentosAlgarve.contentEquals("")) {
			internamentoAlgarve = Integer.parseInt(queryInternamentosAlgarve);
		}
		int somaTotalInternamentos = internamentoAlgarve + internamentoAlentejo +internamentoCentro +internamentoLisboa + internamentoNorte;
		String querySomaTotalInternamentos = String.valueOf(somaTotalInternamentos);
		String html2 = "<!DOCTYPE html>\r\n" + 
        		"<html>\r\n" + 
        		"<body>\r\n" +
        		"<button onclick=\"myFunction0()\">Lista das Regioes</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo0\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction0() {\r\n" + 
        		"  document.getElementById(\"demo0\").innerHTML = \" " +
        		queryRegioes + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" + 
        		"<button onclick=\"myFunction()\">Nº Testes Alentejo</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction() {\r\n" + 
        		"  document.getElementById(\"demo\").innerHTML = \" " +
        		queryTestesAlentejo + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" + 
        		"<button onclick=\"myFunction2()\">Nº Testes Algarve</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo2\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction2() {\r\n" + 
        		"  document.getElementById(\"demo2\").innerHTML = \" " +
        		queryTestesAlgarve + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" +
        		"<button onclick=\"myFunction3()\">Nº Testes Centro</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo3\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction3() {\r\n" + 
        		"  document.getElementById(\"demo3\").innerHTML = \" " +
        		queryTestesCentro + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" + 
        		"<button onclick=\"myFunction4()\">Nº Testes Lisboa</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo4\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction4() {\r\n" + 
        		"  document.getElementById(\"demo4\").innerHTML = \" " +
        		queryTestesLisboa + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" + 
        		"<button onclick=\"myFunction5()\">Nº Testes Norte</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo5\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction5() {\r\n" + 
        		"  document.getElementById(\"demo5\").innerHTML = \" " +
        		queryTestesNorte + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" + 
        		"<button onclick=\"myFunction6()\">Nº Internamentos Algarve</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo6\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction6() {\r\n" + 
        		"  document.getElementById(\"demo6\").innerHTML = \" " +
        		queryInternamentosAlgarve + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" + 
        		"<button onclick=\"myFunction7()\">Nº Internamentos Alentejo</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo7\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction7() {\r\n" + 
        		"  document.getElementById(\"demo7\").innerHTML = \" " +
        		queryInternamentosAlentejo + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" + 
        		"<button onclick=\"myFunction8()\">Nº Internamentos Centro</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo8\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction8() {\r\n" + 
        		"  document.getElementById(\"demo8\").innerHTML = \" " +
        		queryInternamentosCentro + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" + 
        		"<button onclick=\"myFunction9()\">Nº Internamentos Lisboa</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo9\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction9() {\r\n" + 
        		"  document.getElementById(\"demo9\").innerHTML = \" " +
        		queryInternamentosLisboa + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" + 
        		"<button onclick=\"myFunction10()\">Nº Internamentos Norte</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo10\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction10() {\r\n" + 
        		"  document.getElementById(\"demo10\").innerHTML = \" " +
        		queryInternamentosNorte + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" + 
        		"<button onclick=\"myFunction11()\">Nº Infecoes Algarve</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo11\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction11() {\r\n" + 
        		"  document.getElementById(\"demo11\").innerHTML = \" " +
        		queryInfecoesAlgarve + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" + 
        		"<button onclick=\"myFunction12()\">Nº Infecoes Alentejo</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo12\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction12() {\r\n" + 
        		"  document.getElementById(\"demo12\").innerHTML = \" " +
        		queryInfecoesAlentejo + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" +
        		"<button onclick=\"myFunction13()\">Nº Infecoes Centro</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo13\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction13() {\r\n" + 
        		"  document.getElementById(\"demo13\").innerHTML = \" " +
        		queryInfecoesCentro + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" +
        		"<button onclick=\"myFunction14()\">Nº Infecoes Lisboa</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo14\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction14() {\r\n" + 
        		"  document.getElementById(\"demo14\").innerHTML = \" " +
        		queryInfecoesLisboa + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" +
        		"<button onclick=\"myFunction15()\">Nº Infecoes Norte</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo15\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction15() {\r\n" + 
        		"  document.getElementById(\"demo15\").innerHTML = \" " +
        		queryInfecoesNorte + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" +
        		"<button onclick=\"myFunction16()\"> Soma do Nº Internamentos Alentejo Algarve</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo16\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction16() {\r\n" + 
        		"  document.getElementById(\"demo16\").innerHTML = \" " +
        		querySomaInternamentoAlentejoAlgarve + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" +
        		"<button onclick=\"myFunction17()\"> Soma do Nº Internamentos Total</button>\r\n" + 
        		"\r\n" + 
        		"<p id=\"demo17\"></p>\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"function myFunction17() {\r\n" + 
        		"  document.getElementById(\"demo17\").innerHTML = \" " +
        		querySomaTotalInternamentos + "  \";\r\n" + 
        		"}\r\n" + 
        		"</script>\r\n" +
        		"\r\n" + 
        		"</body>\r\n" + 
        		"</html>";
        
        String html = "<!DOCTYPE html>\r\n" + 
        		"<html>\r\n" + 
        		"<head>\r\n" + 
        		"<style>\r\n" + 
        		".button {\r\n" + 
        		"  border: none;\r\n" + 
        		"  color: white;\r\n" + 
        		"  padding: 16px 32px;\r\n" + 
        		"  text-align: center;\r\n" + 
        		"  text-decoration: none;\r\n" + 
        		"  display: inline-block;\r\n" + 
        		"  font-size: 16px;\r\n" + 
        		"  margin: 4px 2px;\r\n" + 
        		"  transition-duration: 0.4s;\r\n" + 
        		"  cursor: pointer;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		".button1 {\r\n" + 
        		"  background-color: white;\r\n" + 
        		"  color: black;\r\n" + 
        		"  border: 2px solid #4CAF50;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		".button1:hover {\r\n" + 
        		"  background-color: #4CAF50;\r\n" + 
        		"  color: white;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		".button2 {\r\n" + 
        		"  background-color: white;\r\n" + 
        		"  color: black;\r\n" + 
        		"  border: 2px solid #008CBA;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		".button2:hover {\r\n" + 
        		"  background-color: #008CBA;\r\n" + 
        		"  color: white;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"</style>\r\n" + 
        		"</head>\r\n" + 
        		"<body>\r\n" + 
        		"\r\n" + 
        		"<button class=\"button button1\">Green</button>\r\n" + 
        		"<button class=\"button button2\">Blue</button>\r\n" + 
        		"\r\n" + 
        		"</body>\r\n" + 
        		"</html>";
        
        File k = new File("/Complemento5/table.html");
		for(File f : dir.listFiles()) {
			if(f.getName().contentEquals("covid19spreading.rdf")) {
				k.createNewFile();
				FileWriter writer = new FileWriter(k);
				writer.write(html2);
				writer.close();
			}
		}
		Desktop.getDesktop().browse(k.toURI());
	}
	
	public static void main( String[] args ) throws IOException, InvalidRemoteException, TransportException, GitAPIException, XPathExpressionException, ParserConfigurationException, SAXException {
    	new App();
    }
}