package Requisito4;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.RevisionSyntaxException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathFilter;

public class Complemento4 {
	
	private List<String> listDescricao = new ArrayList<String>();
	private List<String> listName = new ArrayList<String>();
	private List<String> listTag = new ArrayList<String>();
	private List<String> listTimestamp = new ArrayList<String>();
	
	private Git git;
	private final File dir = new File("/Complemento4");
	
	public Complemento4() {
		try {
			cloneGit();
			getRefs();
			createHtml();
		} catch (GitAPIException | IOException e) {
			e.printStackTrace();
		} 
	}
	
	private void cloneGit() throws InvalidRemoteException, TransportException, GitAPIException, IOException {
		if(!dir.exists())
		git = Git.cloneRepository().setURI("https://github.com/vbasto-iscte/ESII1920.git").setDirectory(dir).call();
		else{
			git = Git.open(new File("/Complemento4"));
			git.pull();
			git.checkout();
		}
	}
	
	private void getRefs() throws GitAPIException, RevisionSyntaxException, AmbiguousObjectException, IncorrectObjectTypeException, IOException {
		List<Ref> listRef = git.tagList().call();
		Repository repository = git.getRepository();
		for(Ref ref : listRef) {
			ObjectId tagFile = repository.resolve(ref.getName());
			try (RevWalk revWalk = new RevWalk(repository)) {
				RevCommit commit = revWalk.parseCommit(tagFile);
				RevTree tree = commit.getTree();
				try (TreeWalk treeWalk = new TreeWalk(repository)) {
					treeWalk.addTree(tree);
					treeWalk.setRecursive(true);
					treeWalk.setFilter(PathFilter.create("covid19spreading.rdf"));
					ObjectId objectId = treeWalk.getObjectId(0);
					ObjectLoader loader = repository.open(objectId);
					addValuesToTables(ref, commit);
				}
				revWalk.dispose();
			}
		}
	}
	
	private void addValuesToTables(Ref ref, RevCommit commit) {
		String tag = ref.getName();
		String[] vTag = tag.split("/");
		Date d = new Date(commit.getCommitTime()*1000L);
		Timestamp ts = new Timestamp(d.getYear(), d.getMonth(), d.getDate(), d.getHours(), d.getMinutes(), d.getSeconds(), 0);
		listTimestamp.add(ts.toString());
		listTag.add(vTag[vTag.length-1]);
		listDescricao.add(commit.getShortMessage().toString());
		listName.add("covid19spreding.rdf");
	}
	
	private void createHtml() throws IOException {
		File k = new File("/Complemento4/table.html");
		for(File f : dir.listFiles()) {
			if(f.getName().contentEquals("covid19spreading.rdf")) {
				String html = new CreateTable(listTimestamp, listName, listTag, listDescricao).getHtmlString();
				k.createNewFile();
				FileWriter writer = new FileWriter(k);
				writer.write(html);
				writer.close();
			}
		}
		Desktop.getDesktop().browse(k.toURI());
	}
	
	public static void main(String[] args) throws IOException {
		new Complemento4();
		/*System.out.println(cgi_lib.Header());

	      Hashtable <Integer, String> form_data = new Hashtable <Integer, String>();
	      String linha = "  <tr>\r\n" + 
					"<td>ola</td>\r\n" + 
					"<td>adeus</td>\r\n" + 
					"<td>aqui</td>\r\n" + 
					"<td>kkkkkkk</td>\r\n" + 
					"<td><a href=\"http://visualdataweb.de/webvowl/#iri=https://github.com/vbasto-iscte/ESII1920/raw/master/covid19spreading.rdf\">Click here</a> </td>\r\n" +
					"</tr>\r\n";
		     String a = "<table>\r\n" + 
						"  <tr>\r\n" + 
						"    <th>File Timestamp</th>\r\n" + 
						"    <th>File name</th>\r\n" + 
						"    <th>File tag</th>\r\n" + 
						"    <th>Tag description</th>\r\n" + 
						"    <th>Spread Visualization link</th>\r\n" + 
						"  </tr>\r\n" + 
						linha + 
						"</table>";
	      form_data.put(1, a);
	      System.out.println(form_data.get(1));
	      System.out.println("<p>");
	      System.out.println(cgi_lib.HtmlBot());*/
	}

}
