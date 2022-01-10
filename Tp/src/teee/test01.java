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
		if(orders > drink.getCnt()) { //����� ��� ������(�ֹ�����>���)
			System.out.println("��� �����մϴ�.");

		}else{
			if(money < orders*drink.getPrice()) { //�����ؾ��� �ݾ��� �ʱ�ݾ� �ʰ���(�ʱ⵷<����*����)
				System.out.println("�ܾ��� �����մϴ�.");

			}else {
				money -= (drink.getPrice() * orders);
				drink.setCnt(drink.getCnt() - orders);
				System.out.println("�ֹ��Ͻ� ����"+drink.getName()+"�� �����Ǿ����ϴ�.");
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
		drink.setCnt(drink.getCnt() + cnt);
	}

}






class Drink{
	private String name;//����� �̸�
	private int cnt;//���� ���
	private static int pkNum=1001;//PK���尪
	private int pk;//���� PK��
	private int price; //����� ��



	public String getName() {
		//������� ���� getter st
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public static int getPkNum() {
		return pkNum;
	}
	public static void setPkNum(int pkNum) {
		Drink.pkNum = pkNum;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}



	Drink(String name,int cnt,int price) {
		this.name=name;
		this.cnt=cnt;
		this.price=price;
		this.pk=pkNum;
		//�� ���Ḷ�� ���� PK�� �ο���
		pkNum++;
		//pkNum 1�� ����
	}    
}

class Coffee extends Drink{

	Coffee(String name, int cnt, int price) {
		super(name, cnt, price);
	}

	@Override
	public String toString() {
		return   getName() + " ����:" + getCnt() + " ����:"+getPrice()+"��";
	} 
}

class Juice extends Drink{

	Juice(String name, int cnt, int price) {
		super(name, cnt, price);
	}

	@Override
	public String toString() {
		return  getName() + " ����:" + getCnt() + " ����:"+getPrice()+"��";
	}
}

class Soda extends Drink{

	Soda(String name, int cnt, int price) {
		super(name, cnt, price);   
	}

	@Override
	public String toString() {
		return  getName() + " ����:" + getCnt() + " ����:"+getPrice()+"��";
	}

}

class Ion extends Drink{

	Ion(String name, int cnt, int price) {
		super(name, cnt, price);
	}

	@Override
	public String toString() {
		return   getName() + " ����:" + getCnt() + " ����:"+getPrice()+"��";
	}    
}

public class test01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Admin ad=new Admin(1234);//���� ��й�ȣ
		Drink[] drink=new Drink[7];
		drink[0]=new Coffee("�Ƹ޸�ī��", 10,1500);
		drink[1]=new Coffee("��    ", 10,1600);
		drink[2]=new Ion("�Ŀ����̵�", 10,2000);
		drink[3]=new Juice("�������ֽ�", 10,1400);
		drink[4]=new Juice("�����ֽ� ", 10,1400);
		drink[5]=new Soda("�ݶ�    ", 10,2200);
		drink[6]=new Soda("���̴�   ", 10,2000);






		while(true) {
			System.out.println("1.�Һ���   2.������   3.����");
			int a = sc.nextInt();
			
			if(a==1) {				//�Һ��ڸ��

				int paym;
				while(true) {
					System.out.println("���� �󸶳� �����ðڽ��ϱ�?");
					paym=sc.nextInt();
					if(paym<=0) {	//��ȿ���˻�
						System.out.println("�߸��� �Է��Դϴ�.");
						continue;
					}break;
				}	
				Pay pay=new Pay(paym);
				System.out.println(pay.money+"���� �����̽��ϴ�.");
				System.out.println();

				while(true) {
					System.out.println("��ǰ�� �������ּ���.");
					for(int i=1;i-1<drink.length;i++) {
						System.out.println(i+"."+drink[i-1]);

					}
					int act=sc.nextInt()-1;
					int orders; 
					if(act<0||act>=drink.length) {
						System.out.println("�߸����Է��Դϴ�.");
						System.out.println();
						continue;
					}
					System.out.println(drink[act].getName()+"�� �����ϼ̽��ϴ�.");

					while(true) {
						System.out.println("������ �Է��ϼ���");
						orders=sc.nextInt();
						if(orders<=0) {
							System.out.println("�߸����Է��Դϴ�.");
							continue;
						}
						break;

					}
					pay.pay(drink[act], orders);
					System.out.println("�ֹ��� ����Ͻðڽ��ϱ�? Y/N");
					String YN=sc.next();
					YN=YN.toUpperCase();
					if(YN.equals("N")) {
						break;
					}
				}





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
								while(true) {
									for(int i=1;i-1<drink.length;i++) {
										System.out.println(i+"."+drink[i-1]);
									}
									System.out.println("�߰��� ��ǰ�� �������ּ���.");
									int act=sc.nextInt()-1;
									int gmorders;
									if(act<0||act>drink.length) {
										System.out.println("�߸����Է��Դϴ�.");
										System.out.println();
										continue;
									}
									System.out.println(drink[act].getName()+"�� �����ϼ̽��ϴ�.");	

									while(true) {
										System.out.println("������ �Է����ּ���");
										gmorders=sc.nextInt();
										if(gmorders<=0) {
											System.out.println("�߸����Է��Դϴ�.");
											continue;
										}
										break;	
									}
									ad.plusCnt(drink[act], gmorders);
									System.out.println(drink[act].getName()+"�� ������ "+gmorders+"�� �߰��Ͽ����ϴ�.");
									break;
								}	
							}else if(gmact==3) {
								System.out.println("�����ڸ�带 �����ϰڽ��ϴ�.");
								break;
							}else 
								continue;

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
