package ood.in_memory_file_system;

import java.util.List;
import java.util.ArrayList;

public class Directory extends Entry{
	protected List<Entry> contents;
	
	public Directory(String name, Directory parent) {
		super(name, parent);
		contents = new ArrayList<Entry>();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int size = 0;
		for(Entry e : contents) {
			size += e.size();
		}
		return size;
	}
	
	public List<Entry> getContents() {
		return contents;
	}
	
	public int getNumOfAllFiles() {
		int count = 0;
		for(Entry e : contents) {
			if(e instanceof Directory ) {//check if e is a directory
				count++;
				Directory child = (Directory) e;
				count+= child.getNumOfAllFiles();//run DFS to count all the child nodes under this dir
			} else if(e instanceof File) {
				count++;
			}
		}
		return count;
	}
	
	
	public void deleteEntry(Entry e) {
		contents.remove(e);
	}
	
	public void addEntry(Entry e) {
		contents.add(e);
	}
	
	
	

}
