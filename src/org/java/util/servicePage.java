package org.java.util;

public class servicePage {
	
	private int index=1;					//��ǰҳ
	private int count;					//������
	private int pagecount;				//�ܹ��ж���ҳ
	private int pagesize=3;				//ÿһҳ������

	
	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getPagecount() {
		return count%pagesize==0?count/pagesize:count/pagesize+1;
	}


	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}


	public int getPagesize() {
		return pagesize;
	}


	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	
	
	public servicePage() {
		super();
	}


	public servicePage(int index, int count, int pagecount, int pagesize) {
		super();
		this.index = index;
		this.count = count;
		this.pagecount = pagecount;
		this.pagesize = pagesize;
	}


	@Override
	public String toString() {
		return "page [index=" + index + ", count=" + count + ", pagecount="
				+ pagecount + ", pagesize=" + pagesize + "]";
	}
}
