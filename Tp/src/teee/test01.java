package teee;

import java.util.Scanner;

 class Pay {
	   //�ʵ�
	   int money;

	   //������
	   public Pay(int money) {
	      this.money = money;
	   }

	   //�޼ҵ�
	   void pay(Drink drink, int orders) { //����
	      if(orders > drink.cnt) { //����� ��� ������(�ֹ�����>���)
	         System.out.println("��� �����մϴ�.");
	        
	      }else{
	         if(money < drink.price) { //�����ؾ��� �ݾ��� �ʱ�ݾ� �ʰ���(�ʱ⵷<����)
	            System.out.println("�ܾ��� �����մϴ�.");
	            
	         }else {
	            money -= (drink.price * orders);
	            drink.cnt -= orders;
	            System.out.println("�ֹ��Ͻ� ����"+drink.name+"�� �����Ǿ����ϴ�.");
	            System.out.println("���� �ܾ���"+money+"�� ���ҽ��ϴ�.");
	           
	         }
	      }
	   }
	}

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
	   void plusCnt(Drink drink, int cnt) {
		      //��� �߰� �޼���
		      //�߰��ϰ��� �ϴ� drink��ü�� ���� ���� ���ڷ� �޴´�
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
	      return  name + " ����:" + price + ", ����:" + cnt ;
	   }

	   
	}
	class Ion extends Drink{

		Ion(String name, int cnt) {
	      super(name, cnt,1200);
	   
	   }

	   @Override
	   public String toString() {
	      return name + " ����:" + price + ", ����:" + cnt ;
	   }
	   
	}
	class  Juice extends Drink{

		 Juice(String name, int cnt) {
	      super(name, cnt,900);
	      
	   }

	   @Override
	   public String toString() {
	      return  name + " ����:" + price + ", ����:" + cnt ;
	   }
	   
	}
	class Soda extends Drink{

		Soda(String name, int cnt) {
			super(name, cnt, 1200);
			
		}

		@Override
		public String toString() {
			return  name + " ����:" + price + ", ����:" + cnt ;
		}

 
	}

public class test01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Admin ad=new Admin(1234);//���� ��й�ȣ
		Drink[] drink=new Drink[7];
		drink[0]=new Coffee("�Ƹ޸�ī��", 10);
		drink[1]=new Coffee("��", 10);
		drink[2]=new Ion("�Ŀ����̵�", 10);
		drink[3]=new Juice("�������ֽ�", 10);
		drink[4]=new Juice("�����ֽ�", 10);
		drink[5]=new Soda("�ݶ�", 10);
		drink[6]=new Soda("���̴�", 10);
		
		
		
		
		
		while(true) {
		System.out.println("1.�Һ���   2.������   3.����");
		int a = sc.nextInt();
		if(a==1) {
			
			
			
		}else if(a==2) {

			while(true) {
				System.out.println("������ ��й�ȣ�� �Է��ϼ���.");
				if(ad.checkPW(sc.nextInt())) {
					while(true) {
						System.out.println();
						System.out.println("1.��ǰ��� 2.��ǰ�����߰� 3.�����ڸ�� ����");
						int gmact=sc.nextInt();
						if(gmact==1) {
							for(int i=1;i-1<drink.length;i++) {
								System.out.println(i+"."+drink[i-1]);
								
							}
						}else if(gmact==2) {

						}else if(gmact==3) {
							System.out.println("�����ڸ�带 �����ϰڽ��ϴ�.");
							break;
						}else {
							continue;
						}


					}break;
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
