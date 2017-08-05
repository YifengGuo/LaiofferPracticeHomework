package ood.in_memory_file_system;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
	private final Directory root; //root directory is immutable
	
	public FileSystem() {
		root = new Directory("/",null);
	}
	
	/*
	 * to check if the path is in /foo/bar format
	 */
	List<Entry> resolve(String path) {
		assert path.startsWith("/");
		String[] components = path.substring(1).split("/");
		
		List<Entry> entries = new ArrayList<>();
		entries.add(root);
		
		Entry entry = root;
		int i = 1;
		while(i < components.length) {
			if(entry == null || !(entry instanceof Directory)) {
				throw new IllegalArgumentException("Invalid path: " + path);
			}
			
			
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
