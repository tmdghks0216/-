package teee;

import java.util.Scanner;



 class Admin {
	   private int pw;
	   
	   public Admin(int pw) {
	      //관리자 객체를 생성 할 때 비밀번호를 입력받음
	      this.pw = pw;
	   }
	   
	   boolean checkPW(int pw){
	      //관리자 번호 확인 메서드
	      //입력값과 관리자 번호가 같다면 true를 리턴한다
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
		Admin ad=new Admin(1234);//어드민 비밀번호
		
		while(true) {
		System.out.println("1.소비자   2.관리자   3.종료");
		int a = sc.nextInt();
		if(a==1) {
			
			
			
		}else if(a==2) {
			
			while(true) {
				System.out.println("관리자 비밀번호를 입력하세요.");
				if(ad.checkPW(sc.nextInt())) {

				
					
				}else {
					System.out.println("잘못입력 하셨습니다.");
					System.out.println("다시입력하시겠습니까? Y/N"); //y와n만 입력된다는 전제하에
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
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시입력하시겠습니까? Y/N");
			String YN=sc.next();
			YN=YN.toUpperCase();
			if(YN.equals("N")) {
				break;
			}
			continue;
		}

		}
		System.out.println("종료되었습니다.");
	}
}
