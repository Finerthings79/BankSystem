package single;

public class SingleInfo {
	public static SingleInfo s;  //������һ������
	public String num;			//ѧ��
	public String name;		//����
	public String password;	//����
	public String power;		//Ȩ��
	private SingleInfo(){
		
	}
	/*
	 * 
	 *  ���ص�������
	 *  
	 *  */ 
	static public SingleInfo main(){ //
		if(s==null){
			s=new SingleInfo();
		}
		return s;
	}
}
