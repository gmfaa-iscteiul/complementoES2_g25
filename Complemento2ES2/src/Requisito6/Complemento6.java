package Requisito6;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathFilter;

import com.jcraft.jsch.Buffer;

public class Complemento6 {
	

	
	public Complemento6() {
			try {
				clonee();
			} catch (GitAPIException e) {
				
			} catch (IOException e) {
				
			}
	}
	
	private void clonee() throws InvalidRemoteException, TransportException, GitAPIException, IOException {
		File file = new File("/clone");
		Git git;
		if(!file.exists())
		git = Git.cloneRepository().setURI("https://github.com/vbasto-iscte/ESII1920.git").setDirectory(file).call();
		else{
			git = Git.open(new File("/clone"));
			git.pull();
			git.checkout();
		}
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
					
		
				}
				revWalk.dispose();
			}
		}
	
		File ficheiro = new File("/clone/ficheiro.html");
		BufferedReader reader;
		String line = "";
		String aux = "";
		try {
			reader = new BufferedReader(new FileReader(
					"/clone/covid19spreading.rdf"));
			line = line + reader.readLine() + "\r\n";
			while (line != null) {
				
				line = reader.readLine();
				aux = aux  + line + "\n";
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String html = 
        		
        		"<textarea name=\"texto\">" +
        		aux ;
        	
        	
		for(File f : file.listFiles()) {
			if(f.getName().contentEquals("covid19spreading.rdf")) {
				
				
				ficheiro.createNewFile();
				FileWriter writer = new FileWriter(ficheiro);
				writer.write(html);
				writer.close();
			}
		}
		
		Desktop.getDesktop().browse(ficheiro.toURI());
	
	}
	
	public static void main(String[] args) throws IOException {
		new Complemento6();
		
	}

}

