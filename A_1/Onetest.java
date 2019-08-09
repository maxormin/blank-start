import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class Onetest{
	public static void m1(){
		int i;
		for(i=0;i<5;i++)
			System.out.println("Welcome to Java");
	}

	public static void m2(){
		int a;
		for(a=1;a<=4;a++){
			if(a==1)
				System.out.println("a      a^2      a^3");
			System.out.printf("%-4d\t%-4d\t %-4d\n",a,a*a,a*a*a);
		}
	}
	public static void m3(){
		System.out.println("(9.5*4.5-2.5*3)/(45.5-3.5)=" + ((9.5*4.5-2.5*3)/(45.5-3.5)));
	}
	public static void m4(){
		int i,sum=0;
		for(i=1;i<=9;i++){
			sum+=i;
		}
		System.out.println("sum = "+sum);
	}
	public static void m5(){
		int i;
		double sum=0,m=0;
		for(i=1;i<=11;i+=2){
			sum+=1.0/i*Math.pow(-1.0,m);
			m++;
		}
		System.out.println(4*sum);
		System.out.println(4*(sum+1/13.0));
	}
	public static void m6(){
		double r=5.5;
		System.out.println("L="+(r*2*Math.PI));
		System.out.println("S="+(r*r*Math.PI));
	}
	public static void m7(){
		System.out.printf("%.5f英里/h\n",(14/1.6)/(30/60.0+45)/60);
	}
	public static void m8(){
		int i;
		long num=365*24*60*60,j,sum=312032486l;
		
		for(i=0;i<5;i++){
			for(j=1;j<=num;j++){
				if(j%7==0)
					sum++;
				if(j%13==0)
					sum--;
				if(j%45==0)
					sum++;
			}
			System.out.println((i+1)+" years is "+ sum);
		}
	}
	public static void m9(){
		System.out.printf("%.5fm/h\n",(24*1.6)/((30/60.0+45)/60+1.0));
	}
	public static void m10(){
		double a=3.4,b=50.2,e=44.5,c=2.1,d=0.55,f=5.9;
		System.out.printf("x=%.4f,y=%.4f\n",(e*d-b*f)/(a*d-b*c),(a*f-e*c)/(a*d-b*c));
	}
	public static void m11(){
		Scanner input =new Scanner(System.in);
		System.out.printf("Enter a temperature in Celsius");
		double c=input.nextDouble();
		System.out.printf("%.1f Celsius is:%.4f Fahrenheit\n",c,9/5.0*c+32);
		input.close();
	}
	public static void m12(){
		Scanner input =new Scanner(System.in);
		System.out.println("Enter the radius and length of a cylinder:");
		double r=input.nextDouble();
		double h=input.nextDouble();
		System.out.println("The area is "+(r*r*Math.PI)+
					"\nThe volume of the cylinder is "+(r*r*Math.PI*h));
		input.close();
	}
	public static void m13(){
		System.out.printf("Enter a number is pounds:");
		Scanner input =new Scanner(System.in);
		double p=input.nextDouble();
		System.out.println(p+"pounds is "+p*0.454+" kilograms");
		input.close();
	}
	public static void m14(){
		System.out.println("Enter subtotal and gratuity rate:");
		Scanner input =new Scanner(System.in);
		double s=input.nextDouble();
		double g=input.nextDouble();
		System.out.println("the gratuity is "+s+" total is "+(s*g/100+s));
		input.close();
	}
	public static void m15() {
		int a,b=0,c;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter an integer between 0 and 1000:");
		a=input.nextInt();
		c=a;
		while(c!=0) {
			b+=c%10;
			c=c/10;
		}
		System.out.println("The sum of all digits in"+a+" is "+b);
	}
	public static void m16() {
		long num;
		System.out.printf("Enter the number of minutes:");
		Scanner input = new Scanner(System.in);
		num = input.nextLong();
		System.out.println(num+" minutes is approximately "+num/60/24/365+" years and "+num/60/24%365+" days");
	}
	public static void m17() {
		long num,num2;
		System.out.printf("Enter the time zone offset to GMT:");
		Scanner input = new Scanner(System.in);
		num2 = input.nextLong();
		num=System.currentTimeMillis();
		System.out.println("The current time is "+(num/1000/60/60%24-num2)+":"+num/1000/60%60+":"+num/1000%60);
		
	}
	public static void m18() {
		System.out.printf("Enter V0,V1,and t:");
		double v0,v1,t;
		Scanner input = new Scanner(System.in);
		v0 = input.nextDouble();
		v1 = input.nextDouble();
		t = input.nextDouble();
		System.out.println("The average acceleration is "+(v1-v0)/t);
	}
	public static void m19() {
		double kg,t0,t1;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter the amount of water in kilograms:");
		kg = input.nextDouble();
		System.out.printf("Enter the initial temperature:");
		t0 = input.nextDouble();
		System.out.printf("Enter the final temperature:");
		t1 = input.nextDouble();
		System.out.println("The energy needed is "+ kg*(t1-t0)*4184);
		
	}
	public static void m20() {
		double v,a;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter speed v:");
		v = input.nextDouble();
		System.out.printf("Enter acceleration a:");
		a = input.nextDouble();
		System.out.println("The minimum runway length for this airplane is "+ v*v/2/a+" meters");
	}
	public static void m21() {
		double save,rate,num,save2;
		int i,month;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter the amount to be saved for each month:");
		save = input.nextDouble();
		System.out.printf("Enter the annual interest rate:");
		rate = input.nextDouble();
		System.out.printf("Enter the number of months:");
		month = input.nextInt();
		num = rate/100/12;
		save2 = 0;
		for(i=0;i<month;i++) {
			save2=(save+save2)*(1+num);
		}
		System.out.printf("After the 6th month the account value is "+save2);
	}
	public static void m22() {
		double h,w;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter weight in pounds:");
		w = input.nextDouble();
		System.out.printf("Enter height in inches:");
		h = input.nextDouble();
		System.out.printf("BMI is "+(w*0.45359237)/Math.pow(h*0.0254,2));
	}
	public static void m23() {
		double x1,x2,y1,y2;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter x1 and y1:");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		System.out.printf("Enter x2 and y2:");
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		System.out.printf("The distance of the two points is "+Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
	}
	public static void m24() {
		double s;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter the side:");
		s = input.nextDouble();
		System.out.println("The area of the hexagon is " + 3*Math.sqrt(3.0)/2*s*s);	
	}
	public static void m25() {
		double ta,v;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter the temperature in Fahrenheit -58 and 41:");
		ta = input.nextDouble();
		System.out.printf("Enter the wind speed miles per hour("
				+ "must be greater or equal to 2):");
		v = input.nextDouble();
		System.out.printf("The wind chill index is "+(35.74+0.6215*ta-35.75*Math.pow(v, 0.16)+0.4275*ta*Math.pow(v, 0.16)));
	}
	public static void m26() {
		double a=1,b=2;
		int i;
		System.out.println("a\tb\tpow(a,b)");
		for(i=1;i<=5;i++) {
			System.out.println(i+"\t"+(i+1)+"\t"+Math.pow(a, b));
			a++;
			b++;
		}
	}
	public static void m27() {
		double x1,x2,x3,y1,y2,y3,s1,s2,s3,s;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter three points for a triangle:");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		x3 = input.nextDouble();
		y3 = input.nextDouble();
		s1=Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
		s2=Math.sqrt(Math.pow(x2-x3, 2)+Math.pow(y2-y3, 2));
		s3=Math.sqrt(Math.pow(x3-x1, 2)+Math.pow(y3-y1, 2));
		s=(s1+s2+s3)/2;
		System.out.println("The area of the triangle is "+Math.sqrt(s*(s-s1)*(s-s2)*(s-s3)));
	}
	public static void m28() {
		double a,b;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter blance and annual interest rate:");
		a = input.nextDouble();
		b = input.nextDouble();
		System.out.printf("The interest is "+a*(b/1200));
	}
	public static void m29() {
		double a,b;
		int i,c;
		System.out.printf("Enter the investment amount, "
				+ "for example 120000.95:");
		Scanner input = new Scanner(System.in);
		a = input.nextDouble();
		System.out.printf("Enter annual interest rate, for example 8.25:");
		b = input.nextDouble();
		System.out.printf("Enter number of years as an integer, for example 5:");
		c = input.nextInt();
		for(i=1;i<=c;i++) {
			a=a*(1+b/100);
		}
		System.out.printf("Future value is "+a);
	}
	public static void m30() {
		double a,b,c;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter the driving distance:");
		a = input.nextDouble();
		System.out.printf("Enter miles per gallon:");
		b = input.nextDouble();
		System.out.printf("Enter price per gallon:");
		c = input.nextDouble();
		System.out.printf("The cost of driving is $"+a/b*c);
	}
	public static void m31(){
		double a,b,c,m;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter a b c:");
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		m = b*b - 4*a*c;
		if(m>0) {
			System.out.println("The equation has two rots: "+(-b+Math.sqrt(m))/(2*a)
					+" and "+(-b-Math.sqrt(m))/(2*a));
		}
		else if(m==0) {
			System.out.println("The equation has one root: "+(-b)/(2*a));
		}
		else {
			System.out.println("The equation has no real root");
		}
	}
	public static void m32() {
		int i,a,b,sum=0;
		Scanner in = new Scanner(System.in);
		Random input = new Random();
		for(i=0;i<3;i++) {
			a=input.nextInt(10);
			if(i!=2)
				System.out.printf("%d+",a);
			else
				System.out.printf("%d = ",a);
			sum += a;
		}
		b = in.nextInt();
		if(b==sum)
			System.out.println("true");
		else
			System.out.println("false");
	}
	public static void m33() {
		Random input = new Random();
		int i=1+input.nextInt(12);
		switch(i) {
		case 1:System.out.println("January");break;
		case 2:System.out.println("February");break;
		case 3:System.out.println("March");break;
		case 4:System.out.println("April");break;
		case 5:System.out.println("May");break;
		case 6:System.out.println("June");break;
		case 7:System.out.println("July");break;
		case 8:System.out.println("August");break;
		case 9:System.out.println("September");break;
		case 10:System.out.println("October");break;
		case 11:System.out.println("November");break;
		case 12:System.out.println("December");break;
		}
	}
	public static void m34() {
		System.out.printf("Enter to day's day:");
		int a,b;
		String m=null,n=null;
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		System.out.printf("Enterthenumberofdayselapsedsincetoday:");
		b = in.nextInt();
		switch(a%7) {
		case 1:m = "Monday";break;
		case 2:m = "Tuesday";break;
		case 3:m = "Wednesday";break;
		case 4:m = "Thursday";break;
		case 5:m = "Friday";break;
		case 6:m = "Saturday";break;
		case 0:m = "Sunday";break;
		}
		switch((a+b)%7) {
		case 1:n = "Monday";break;
		case 2:n = "Tuesday";break;
		case 3:n = "Wednesday";break;
		case 4:n = "Thursday";break;
		case 5:n = "Friday";break;
		case 6:n = "Saturday";break;
		case 0:n = "Sunday";break;
		}
		System.out.println("Todayis"+m+"andthefuturedayis"+n);
	}
	public static void m35() {
		System.out.printf("Enter weight in pounds:");
		double a,b,c,BIM;
		Scanner in = new Scanner(System.in);
		a = in.nextDouble();
		System.out.printf("Enter feet:");
		b = in.nextDouble();
		System.out.printf("Enter feet:");
		c = in.nextDouble();
		BIM=(a*0.45359237)/Math.pow((b*12+c)*0.0254,2);
		System.out.println("BMI is "+BIM);
		if(BIM<18.5)
			System.out.println("Underweight");
		else if(BIM < 25.0)
			System.out.println("Normal");
		else if(BIM <30.0)
			System.out.println("Overweight");
		else
			System.out.println("Obese");

	}
	public static void m36() {
		int[] a = new int[3];
		int i;
		Scanner in = new Scanner(System.in);
		for(i=0;i<3;i++) {
			a[i]=in.nextInt();
		}
		Arrays.parallelSort(a);
		for(i=0;i<3;i++)
			System.out.printf("%d ",a[i]);
	}
	public static void m37() {
		int[] a = new int[10];
		int i,sum=0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the first 9 digit of an ISBN as integer:");
		for(i=0;i<9;i++) {
			a[i] = in.nextInt();
			sum += a[i]*(i+1);
		}
		a[9]=sum%11;
		System.out.println("The ISBN-10 number is "+ Arrays.toString(a));
	}
	public static void m38() {
		int a,b,c;
		Random input = new Random();
		Scanner in = new Scanner(System.in);
		a = input.nextInt(100);
		b = input.nextInt(100);
		System.out.printf(a +" + "+ b +" = ");
		c = in.nextInt();
		if(c!= (a+b)) 
			System.out.println("You answer is wrong "
					+a +" + "+ b +" is "+(a+b) );
		else
			System.out.println("You are correct!");
	}
	public static void m39() {
		System.out.printf("请输入年，月:");
		int a,b,c=0;
		String m=null;
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		switch(b) {
		case 1:m="January";break;
		case 2:m="February";break;
		case 3:m="March";break;
		case 4:m="April";break;
		case 5:m="May";break;
		case 6:m="June";break;
		case 7:m="July";break;
		case 8:m="August";break;
		case 9:m="September";break;
		case 10:m="October";break;
		case 11:m="November";break;
		case 12:m="December";break;
		}
		switch(b) {
		case 1:c=31; break;
		case 2:c=28; break;
		case 3:c=31; break;
		case 4:c=30; break;
		case 5:c=31; break;
		case 6:c=30; break;
		case 7:c=31; break;
		case 8:c=31; break;
		case 9:c=30; break;
		case 10:c=31; break;
		case 11:c=30; break;
		case 12:c=31; break;
		}
		if((a%4==0&&a%100!=0)||a%400==0) {
			if(b==2)
				c=29;
		}
		System.out.println(m+" "+a+" has " + c +" days");
	}
	public static void m40() {
		int a,i;
		Scanner in = new Scanner(System.in);
		System.out.printf("Enter a three-digit integer ");
		a = in.nextInt();
		if(a%10!=a/100)
			System.out.println(a+" is not a palindrome");
		else
			System.out.println(a+" is a palindrome");
		
	}
	public static void m41() {
		Scanner in = new Scanner(System.in);
		System.out.print("(0-single filer, 1-married joinly or"
				+ " qualifying widow(er), 2-married separately,"
				+ " 3-head of household) Enter the filing status: ");
		int status = in.nextInt();
		System.out.print("Enter the taxable income: ");
		double income = in.nextDouble();
		double tax = 0;
		if(status==0)
		{
			if(income <= 8350)
				tax = income * 0.1;
			else if (income <= 33950)
				tax = 8350 * 0.1+(income-8350)*0.15;
			else if(income <= 82250)
				tax = 8350 * 0.1+(33950-8350)*0.15+(income-33950)*0.25;
			else if(income <= 171550)
				tax =  8350 * 0.1+(33950-8350)*0.15+(82250-33950)*0.25+(income - 82250)*0.28;
			else if(income <= 372950)
				tax =  8350 * 0.1+(33950-8350)*0.15+(82250-33950)*0.25+(171550-82250)*0.28+(income-171550)*0.33;
			else
				tax = 8350 * 0.1+(33950-8350)*0.15+(82250-33950)*0.25+(171550-82250)*0.28+(372950-171550)*0.33+(income - 372950)*0.35;
		}
		else if(status == 1)
		{
			if(income <= 16700)
				tax = income * 0.1;
			else if (income <= 67900)
				tax = 16700 * 0.1+(income-16700)*0.15;
			else if(income <= 137050)
				tax = 16700 * 0.1+(67900-16700)*0.15+(income-67900)*0.25;
			else if(income <= 208850)
				tax = 16700 * 0.1+(67900-16700)*0.15+(137050-67900)*0.25+(income-137050)*0.28;
			else if(income <= 372950)
				tax = 16700 * 0.1+(67900-16700)*0.15+(137050-67900)*0.25+(208850-137050)*0.28+(income-208850)*0.33;
			else
				tax = 16700 * 0.1+(67900-16700)*0.15+(137050-67900)*0.25+(208850-137050)*0.28+(372950-208850)*0.33+(income - 372950)*0.35;
		}
		else if(status == 2) {
			if(income <= 8350)
				tax = income * 0.1;
			else if (income <= 33950)
				tax = 8350 * 0.1+(income-8350)*0.15;
			else if(income <= 68525)
				tax = 8350 * 0.1+(33950-8350)*0.15+(income-33950)*0.25;
			else if(income <= 104425)
				tax = 8350 * 0.1+(33950-8350)*0.15+(68525-33950)*0.25+(income - 68525)*0.28;
			else if(income <= 186475)
				tax = 8350 * 0.1+(33950-8350)*0.15+(68525-33950)*0.25+(104425-68525)*0.28+(income-186475)*0.33;
			else
				tax = 8350 * 0.1+(33950-8350)*0.15+(68525-33950)*0.25+(104425-68525)*0.28+(186475-104425)*0.33+(income - 186475)*0.35;
		}
		else if(status == 3) {
			if(income <= 11950)
				tax = income * 0.1;
			else if (income <= 45500)
				tax = 11950 * 0.1+(income-11950)*0.15;
			else if(income <= 117450)
				tax = 11950 * 0.1+(45500-11950)*0.15+(income-45500)*0.25;
			else if(income <= 190200)
				tax = 11950 * 0.1+(45500-11950)*0.15+(117450-45500)*0.25+(income-117450)*0.28;
			else if(income <= 372950)
				tax = 11950 * 0.1+(45500-11950)*0.15+(117450-45500)*0.25+(190200-117450)*0.28+(income-190200)*0.33;
			else
				tax = 11950 * 0.1+(45500-11950)*0.15+(117450-45500)*0.25+(190200-117450)*0.28+(372950-190200)*0.33+(income - 372950)*0.35;
		}
		else {
			System.out.println("Error: invalid status");
			return;
		}
		System.out.println("Tax is " + (int)(tax * 100) / 100.0);
	}
	public static void m42() {
		Random input = new Random();
		int a,b;
		Scanner in = new Scanner(System.in);
		a = input.nextInt(2);
		System.out.println("请输入0或1:");
		b = in.nextInt();
		if(b!=a)
			System.out.println("False");
		else
			System.out.println("true");
	}
	public static void m43() {
		System.out.printf("Enter your lottery pick (three digits):");
		Scanner in = new Scanner(System.in);
		Random input = new Random();
		int i,j,a,b,m;
		int[] num = new int[3];
		int[] num2 = new int[3];
		a = in.nextInt();
		b = 100+input.nextInt(900);
		System.out.println("The lottery number is :"+b);
		if(a==b) {
			System.out.println("Exact match: you win $10,000");
		}
		else {
			m=0;
			for(i=0;i<3;i++) {
				num[i] = a%10;
				num2[i] = b%10;
				a /= 10;
				b /= 10;
			}
			for(i=0;i<3;i++) {
				for(j=0;j<3;j++) {
					if(num[i] == num2 [j]) {
						num2[j] = -1;
						m++;
						break;
					}
				}
			}
			if(m == 3) {
				System.out.println("Match all digits: you win $3,000");
			}
			else if(m>0) {
				System.out.println("Match one or two digits: you win $1,000");
			}
			else
				System.out.println("Sorry, so match");
		}
		
	}
	public static void m44() {
		double x,y;
		Random input = new Random();
		x = -50+(Math.random()*100);
		y = -100 + (Math.random()*200);
		System.out.println("("+x+","+y+")");
	}
	public static void m45() {
		int a,b;
		String m=null,n=null;
		System.out.printf("scissor (0), rock (1), paper(2): ");
		Random input = new Random();
		Scanner in = new Scanner(System.in);
		a = input.nextInt(3);
		b = in.nextInt();
		switch(a) {
		case 0: m = "scissor"; break;
		case 1: m = "rock"; break;
		case 2: m = "paper"; break;
		}
		switch(b) {
		case 0: n = "scissor"; break;
		case 1: n = "rock"; break;
		case 2: n = "paper"; break;
		}
		if(a - b == 1 || a - b == -2) {
			System.out.println("The computer is " + m +
					". You are "+n+". You last");
			}
		else if (b - a == 1 || b - a == -2) {
			System.out.println("The computer is " + m +
					". You are "+n+". You won");
		}
		else
			System.out.println("The computer is " + m +
					". You are "+n+" too. It is draw");
	}
	public static void m46() {
		double w,c;
		System.out.println("please input weight:");
		Scanner in = new Scanner(System.in);
		w = in.nextDouble();
		if(w<=1)
			System.out.println("You will spend "+3.5*w);
		else if(w<=3)
			System.out.println("You will spend "+5.5*w);
		else if(w<=10)
			System.out.println("You will spend "+8.5*w);
		else if(w<=20)
			System.out.println("You will spend "+10.5*w);
		else
			System.out.println("The package can not be shipped");
	}
	public static void m47() {
		double a,b,c;
		System.out.println("please input a,b,c:");
		Scanner in = new Scanner(System.in);
		a = in.nextDouble();
		b = in.nextDouble();
		c = in.nextDouble();
		if(a+b > c && a+c >b && b+c>a)
			System.out.println("周长为:"+(a+b+c));
		else 
			System.out.println("The input is illegality");
	}
	public static void m48() {
		int year,month,day,m;
		String h=null;
		Scanner in = new Scanner(System.in);
		System.out.printf("Enter year:(e.g, 2012) :");
		year = in.nextInt();
		System.out.printf("Enter month:1-12: ");
		month = in.nextInt();
		if(month == 1 || month == 2) {
			month += 12;
			year--;
		}
		System.out.printf("Enter the day of the month:1-31: ");
		day = in.nextInt();
		m = (day+26*(month+1)/10+year%100+(year%100)/4+year/400+5*year/100)%7;
		switch(m) {
		case 0:h = "Saturday"; break;
		case 1:h = "Sunday"; break;
		case 2:h = "Monday"; break;
		case 3:h = "Tuesday"; break;
		case 4:h = "Wednesday"; break;
		case 5:h = "Thursday"; break;
		case 6:h="Friday"; break;
		}
		System.out.println("Day of the week is "+h);
	}
	public static void m49() {
		double x,y,m;
		Scanner in = new Scanner(System.in);
		System.out.println("Enetr a point with two coordinates: ");
		x = in.nextDouble();
		y = in.nextDouble();
		m = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
		if(m<=10)
			System.out.println("Point("+x+","+y+") is in the circle");
		else
			System.out.println("Point("+x+","+y+ ") is not in the circle");
	}
	public static void m50() {
		System.out.printf("Enter a point with two coordinates: ");
		double x,y;
		Scanner in = new Scanner(System.in);
		x = in.nextDouble();
		y = in.nextDouble();
		if(x<=5 && y<=10) {
			System.out.println("Point ("+x+","+y+") is in ther ectangle");
		}
		else
			System.out.println("Point ("+x+","+y+") is not in ther ectangle");
	}
	
	public static void m51() {
		int a,b;
		String m=null,n=null;
		Random input = new Random();
		a = 1+input.nextInt(13);
		b = 1+input.nextInt(4);
		switch(b) {
		case 1: n = "Clubs"; break;
		case 2: n = "Diamonds"; break;
		case 3: n = "Hearts"; break;
		case 4: n = "Spades"; break;
		}
		if(a<2 || a>10) {
			switch(a) {
			case 1:m="Ace"; break;
			case 11: m = "Jack"; break;
			case 12: m = "Queen"; break;
			case 13: m = "King"; break;
			}
			System.out.println("The card you picked is "+m+" of "+n);
		}
		else
			System.out.println("The card you picked is "+a+" of "+n);
	}
	
	public static void m52() {
		System.out.printf("Enter x1,x2,y1,y2,x3,y3,x4,y4:");
		double[] y = new double[4];
		double[] x = new double[4];
		double k1,k2,m,n;
		int i;
		Scanner in = new Scanner(System.in);
		for(i=0;i<4;i++) {
			x[i] = in.nextDouble();
			y[i] = in.nextDouble();
		}
		k1 = (y[0]-y[1])/(x[0]-x[1]);
		k2 = (y[2]-y[3])/(x[2]-x[3]);
		if(k2 == k1) {
			System.out.println("The two lines are parallel");
		}
		else {
			m = (k1*x[0]-y[0]-k2*x[3]+y[3])/(k1-k2);
			n = k1*(m-x[0])+y[0];
			System.out.println("The intersecting point is at ("+m+","+n+")");
		}
			
	}
	
	public static void m53() {
		int i;
		Scanner in = new Scanner(System.in);
		System.out.println("Enetr an integer: ");
		i = in.nextInt();
		System.out.println("Is "+i+" divisible by 5 and 6? "+(i%5==0 && i%6==0));
		System.out.println("Is "+i+" divisible by 5 or 6? "+(i%5==0 || i%6==0));
		System.out.println("Is "+i+" divisible by 5 or 6, but not both? "+((i%5==0 && i%6!=0) || (i%5!=0 || i%6==0)));
	}
	
	public static void m54() {
		System.out.printf("Enetr r1's center x-,y-coordinates, width, and height: ");
		Scanner in = new Scanner(System.in);
		double x1,y1,x2,y2,w1,h1,w2,h2;
		x1 = in.nextDouble();
		y1 = in.nextDouble();
		w1 = in.nextDouble();
		h1 = in.nextDouble();
		System.out.printf("Enetr r2's center x-,y-coordinates, width, and height: ");
		x2 = in.nextDouble();
		y2 = in.nextDouble();
		w2 = in.nextDouble();
		h2 = in.nextDouble();
		if((Math.abs(x1-x2)+w2/2<=w1/2) && (Math.abs(y1-y2)+h2/2<h1/2)) {
			System.out.println("r2 is inside r1");
		}
		else if((Math.abs(x1-x2)-w2/2<=w1/2) || (Math.abs(y1-y2)-h2/2<h1/2)) {
			System.out.println("r2 overlaps r1");
		}
		else {
			System.out.println("r2 does not overlap r1");
		}
	}
	
	public static void m55() {
		double rate,dollar;
		int a;
		Scanner in = new Scanner(System.in);
		System.out.printf("Enetr the exchange rate from dollars to RMB: ");
		rate = in.nextDouble();
		System.out.printf("Enetr 0 to convert dollars to RMB and 1 vice versa: ");
		a = in.nextInt();
		if(a!=0 && a!=1) {
			System.out.println("Incorrect input");
			return;
		}
		System.out.printf("Enetr the dolar amount: ");
		dollar = in.nextDouble();
		if(a == 0) {
			System.out.println("$"+dollar+" is "+dollar*rate+" Yuan");
		}
		else if(a==1){
			System.out.println(dollar+" Yuan is $"+dollar/rate);
		}
	}
	
	public static void m56() {
		int i;
		double[] x = new double[3];
		double[] y = new double[3];
		double num;
		Scanner in = new Scanner(System.in);
		System.out.printf("Enter three points for p0,p1, and p2: ");
		for(i=0;i<3;i++) {
			x[i] = in.nextDouble();
			y[i] = in.nextDouble();
		}
		num = (x[1]-x[0])*(y[2]-y[0])-(x[2]-x[0])*(y[1]-y[0]);
		if(num>0) {
			System.out.println("("+x[2]+","+y[2]+") is on the "
					+ "left side of the line from "
					+ "("+x[0]+","+y[0]+") to ("+x[1]+","+y[1]+")");
		}
		else if(num==0) {
			System.out.println("("+x[2]+","+y[2]+") is on the "
					+ "line from ("+x[0]+","+y[0]+") to ("+x[1]+","+y[1]+")");
		}
		else {
			System.out.println("("+x[2]+","+y[2]+") is on the "
					+ "right side of the line from "
					+ "("+x[0]+","+y[0]+") to ("+x[1]+","+y[1]+")");
		}
	}
	
	public static void main(String[] agrs){
		int a;
		System.out.println("请输入需要测试的题，输入0退出");
		Scanner in = new Scanner(System.in);
		do{
			a = in.nextInt();
			switch(a) {
			case 1:m1(); break;
			case 2:m2(); break;
			case 3:m3(); break;
			case 4:m4(); break;
			case 5:m5(); break;
			case 6:m6(); break;
			case 7:m7(); break;
			case 8:m8(); break;
			case 9:m9(); break;
			case 10:m10(); break;
			case 11:m11(); break;
			case 12:m12(); break;
			case 13:m13(); break;
			case 14:m14(); break;
			case 15:m15(); break;
			case 16:m16(); break;
			case 17:m17(); break;
			case 18:m18(); break;
			case 19:m19(); break;
			case 20:m20(); break;
			case 21:m21(); break;
			case 22:m22(); break;
			case 23:m23(); break;
			case 24:m24(); break;
			case 25:m25(); break;
			case 26:m26(); break;
			case 27:m27(); break;
			case 28:m28(); break;
			case 29:m29(); break;
			case 30:m30(); break;
			case 31:m31(); break;
			case 32:m32(); break;
			case 33:m33(); break;
			case 34:m34(); break;
			case 35:m35(); break;
			case 36:m36(); break;
			case 37:m37(); break;
			case 38:m38(); break;
			case 39:m39(); break;
			case 40:m40(); break;
			case 41:m41(); break;
			case 42:m42(); break;
			case 43:m43(); break;
			case 44:m44(); break;
			case 45:m45(); break;
			case 46:m46(); break;
			case 47:m47(); break;
			case 48:m48(); break;
			case 49:m49(); break;
			case 50:m50(); break;
			case 51:m51(); break;
			case 52:m52(); break;
			case 53:m53(); break;
			case 54:m54(); break;
			case 55:m55(); break;
			case 56:m56(); break;
			}
		}
		while(a!=0);
	}



}