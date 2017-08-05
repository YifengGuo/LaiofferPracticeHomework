package ood.in_memory_file_system;

public class File extends Entry{
	public File(String name, Directory parent) {
		super(name, parent);
	}

	private byte[] content;
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return content.length;
	}
	
	public void setContent(byte[] c) {
		this.content = c;
	}
	
	public byte[] getContent() {
		return content;
	}
}
