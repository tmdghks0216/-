package teee;

import java.util.Scanner;



 class Admin {
	   private int pw;
	   
	   public Admin(int pw) {
	      //������ ��ü�� ���� �� �� ��й�ȣ�� �Է¹���
	      this.pw = pw;
	   }
	   
	   boolean checkPW(int pw){
	      //������ ��ȣ Ȯ�� �޼���
	      //�Է°��� ������ ��ȣ�� ���ٸ� true�� �����Ѵ�
	      if(this.pw==pw) {
	         return true;
	      }else {
	         return false;
	      }      
	   }
	}


public class test01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Admin ad=new Admin(1234);//���� ��й�ȣ
		
		while(true) {
		System.out.println("1.�Һ���   2.������   3.����");
		int a = sc.nextInt();
		if(a==1) {
			
			
			
		}else if(a==2) {
			
			while(true) {
				System.out.println("������ ��й�ȣ�� �Է��ϼ���.");
				if(ad.checkPW(sc.nextInt())) {

				
					
				}else {
					System.out.println("�߸��Է� �ϼ̽��ϴ�.");
					System.out.println("�ٽ��Է��Ͻðڽ��ϱ�? Y/N"); //y��n�� �Էµȴٴ� �����Ͽ�
					String YN=sc.next();
					YN=YN.toUpperCase();
					if(YN.equals("N")) {
						break;
					}
						
				}
			}
			
		
		
		}else if(a==3) {
			break;

		}else {
			System.out.println("�߸��� �Է��Դϴ�.");
			System.out.println("�ٽ��Է��Ͻðڽ��ϱ�? Y/N");
			String YN=sc.next();
			YN=YN.toUpperCase();
			if(YN.equals("N")) {
				break;
			}
			continue;
		}

		}
		System.out.println("����Ǿ����ϴ�.");
	}
}
