package util;

import java.util.HashMap;
import java.util.LinkedList;

import db.DB1;

public class PageBean {
//	javaBean
	
	private int page ;//��ǰҳ��
	private int maxPage ;//���ҳ��
	private int maxRow ;//�������
//	private int nextPage ;//��һҳ����
//	private int prePage ;//��һҳ����
	private int pageSize = 5;//ÿҳ����
//	private String sql ;//sql���
	
	private LinkedList<HashMap<String,String>> list ; 
	
	public PageBean(String sql ,int page ,int pageSize){
//		����sql����ҳ�����Լ�ÿҳ�������õ���Ҫ������
	}
	
	public PageBean(String sql ,int page ){
		
//		�ж�page�Ƿ�С��1
		if(page < 1){
			page = 1 ;
		}
		
//		�����ҳ�����ж�page�Ƿ�Խ��
		
		String sqlCount = " SELECT COUNT(*) as num FROM (   "+ sql +" ) AS t " ;
//		System.out.println(sqlCount);
		DB1 d = new DB1();
		LinkedList<HashMap<String, String>> listCount = d.queryToList(sqlCount);//list�洢�����ܼ�¼��
		if(listCount.size()>0){
			maxRow = Integer.parseInt(listCount.get(0).get("num"));//�ܼ�¼��
//			System.out.println("maxRow------"+maxRow);
			maxPage = maxRow % pageSize == 0 ?maxRow / pageSize : maxRow / pageSize +1 ;//��ҳ��
//			System.out.println("maxPage-------------"+maxPage);
			if(maxPage==0){
				maxPage=1;
			}
			if( page > maxPage ){
				page = maxPage;
			}
			
			this.page = page;
			
			//�ӵڼ�����ʼ
			int start = ( page-1 ) * pageSize;
			
			sql = sql+ " limit "+start+" ,"+pageSize;
//			System.out.println("sql-----------------------------------"+sql);
			list = d.queryToList(sql);
		}
		d.close();
		
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public LinkedList<HashMap<String, String>> getList() {
		return list;
	}
	
	//page��ȡȨ�ޣ�д���Ȩ��
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxRow() {
		return maxRow;
	}
	public void setMaxRow(int maxRow) {
		this.maxRow = maxRow;
	}
	
	
	
}