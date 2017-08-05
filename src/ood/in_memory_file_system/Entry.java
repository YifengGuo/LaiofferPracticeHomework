package ood.in_memory_file_system;

public abstract class Entry {
	protected Directory parent;
	private String name;
	protected long created;
	protected long lastTimeUpdated;
	protected long lastTimeAccessed;
	
	public Entry(String name, Directory parent) {
		this.name = name;
		this.parent = parent;
		created = System.currentTimeMillis();
	}
	
	public abstract int size();
	
	public long getCreatedTime() {
		return created;
	}
	
	public long getLastTimeUpdated() {
		return lastTimeUpdated;
	}
	
	public long getLastTimeAccessed() {
		return lastTimeAccessed;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	
}
