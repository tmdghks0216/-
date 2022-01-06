package teee;

import java.util.Scanner;

 class Pay {
	   //필드
	   int money;

	   //생성자
	   public Pay(int money) {
	      this.money = money;
	   }

	   //메소드
	   void pay(Drink drink, int orders) { //결제
	      if(orders > drink.cnt) { //음료수 재고 없을시(주문수량>재고)
	         System.out.println("재고가 부족합니다.");
	        
	      }else{
	         if(money < drink.price) { //지불해야할 금액이 초기금액 초과시(초기돈<가격)
	            System.out.println("잔액이 부족합니다.");
	            
	         }else {
	            money -= (drink.price * orders);
	            drink.cnt -= orders;
	            System.out.println("주문하신 음료"+drink.name+"이 결제되었습니다.");
	            System.out.println("남은 잔액은"+money+"원 남았습니다.");
	           
	         }
	      }
	   }
	}

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
	   void plusCnt(Drink drink, int cnt) {
		      //재고 추가 메서드
		      //추가하고자 하는 drink객체와 더할 값을 인자로 받는다
		      drink.cnt+=cnt;
		   }

	}

 class Drink{
	   String name;
	   int price;
	   int cnt;
	   static int pkNum=1001;
	   int pk;
	    Drink(String name,int cnt,int price) {
	      this.name=name;
	      this.cnt=cnt;
	      this.price=price;
	      this.pk=pkNum;
	         pkNum++;
	      
	    
	   }
	    void show() {
	   }


	}
	class Coffee extends Drink{

	   Coffee(String name, int cnt) {
	      super(name, cnt,800);
	      
	   }

	   @Override
	   public String toString() {
	      return  name + " 가격:" + price + ", 수량:" + cnt ;
	   }

	   
	}
	class Ion extends Drink{

		Ion(String name, int cnt) {
	      super(name, cnt,1200);
	   
	   }

	   @Override
	   public String toString() {
	      return name + " 가격:" + price + ", 수량:" + cnt ;
	   }
	   
	}
	class  Juice extends Drink{

		 Juice(String name, int cnt) {
	      super(name, cnt,900);
	      
	   }

	   @Override
	   public String toString() {
	      return  name + " 가격:" + price + ", 수량:" + cnt ;
	   }
	   
	}
	class Soda extends Drink{

		Soda(String name, int cnt) {
			super(name, cnt, 1200);
			
		}

		@Override
		public String toString() {
			return  name + " 가격:" + price + ", 수량:" + cnt ;
		}

 
	}

public class test01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Admin ad=new Admin(1234);//어드민 비밀번호
		Drink[] drink=new Drink[7];
		drink[0]=new Coffee("아메리카노", 10);
		drink[1]=new Coffee("라떼", 10);
		drink[2]=new Ion("파워에이드", 10);
		drink[3]=new Juice("오렌지주스", 10);
		drink[4]=new Juice("포도주스", 10);
		drink[5]=new Soda("콜라", 10);
		drink[6]=new Soda("사이다", 10);
		
		
		
		
		
		while(true) {
		System.out.println("1.소비자   2.관리자   3.종료");
		int a = sc.nextInt();
		if(a==1) {
			
			
			
		}else if(a==2) {

			while(true) {
				System.out.println("관리자 비밀번호를 입력하세요.");
				if(ad.checkPW(sc.nextInt())) {
					while(true) {
						System.out.println();
						System.out.println("1.물품목록 2.물품수량추가 3.관리자모드 종료");
						int gmact=sc.nextInt();
						if(gmact==1) {
							for(int i=1;i-1<drink.length;i++) {
								System.out.println(i+"."+drink[i-1]);
								
							}
						}else if(gmact==2) {

						}else if(gmact==3) {
							System.out.println("관리자모드를 종료하겠습니다.");
							break;
						}else {
							continue;
						}


					}break;
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
