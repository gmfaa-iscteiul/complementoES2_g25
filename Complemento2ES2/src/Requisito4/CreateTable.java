package Requisito4;

import java.io.File;
import java.util.List;

import org.eclipse.jgit.lib.Ref;

public class CreateTable {
	
	private List<String> listTimestamp;
	private List<String> listName;
	private List<String> listTag;
	private List<String> listDescricao;
	
	public CreateTable(List<String> listTimestamp, List<String> listName, List<String> listTag, List<String> listDescricao) {
		this.listTimestamp = listTimestamp;
		this.listTag = listTag;
		this.listDescricao = listDescricao;
		this.listName = listName;
	}
	
	public String getHtmlString() {
		String linha = "";
		for(int i = 0; i != listDescricao.size(); i++) {
			linha = linha + "  <tr>\r\n" + 
					"<td>"+listTimestamp.get(i)+"</td>\r\n" + 
					"<td>"+listName.get(i)+"</td>\r\n" + 
					"<td>"+listTag.get(i)+"</td>\r\n" + 
					"<td>"+listDescricao.get(i)+"</td>\r\n" + 
					"<td><a href=\"http://visualdataweb.de/webvowl/#iri=https://github.com/vbasto-iscte/ESII1920/raw/master/covid19spreading.rdf\">Click here</a> </td>\r\n" +
					"</tr>\r\n";
		}
		return "<table>\r\n" + 
				"  <tr>\r\n" + 
				"    <th>File Timestamp</th>\r\n" + 
				"    <th>File name</th>\r\n" + 
				"    <th>File tag</th>\r\n" + 
				"    <th>Tag description</th>\r\n" + 
				"    <th>Spread Visualization link</th>\r\n" + 
				"  </tr>\r\n" + 
				linha + 
				"</table>";
	}
	
}
