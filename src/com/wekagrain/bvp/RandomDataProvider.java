//sg
/*
    "Copyright 2011 CSE DEPTT. BVCOE  <http://bvcoend.ac.in/Deptt_CSE.asp>"
    
     This file is part of Weka Grain.

    Weka Grain is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Weka Grain is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Weka Grain.  If not, see <http://www.gnu.org/licenses/>.*/
package com.wekagrain.bvp;

import java.util.Random;

public class RandomDataProvider {

	String namesTaken[];
	int lengthNamesTaken;
	RandomDataProvider()
	{
		namesTaken=new String[100000]; //virtual Limit of 1 lac records
		lengthNamesTaken=0;
	}
	public String getRandomDept()
	{
		String dept[]={"CSE","IT","EEE","ECE","ICE"};
		Random r=new Random();
		int d=(r.nextInt(10000))%dept.length;
		
		
		return dept[d];
	}
	public String getYesNo()
	{
		String yn[]={"Yes","No"};
		Random r=new Random();
		int d=(r.nextInt(10000))%2;
		return yn[d];
	}
	
	public String getTrueFalse()
	{
		String yn[]={"True","False"};
		Random r=new Random();
		int d=(r.nextInt(10000))%2;
		return yn[d];
	}
	public String getGender()
	{
		String yn[]={"Male","Female"};
		Random r=new Random();
		int d=(r.nextInt(10000))%2;
		return yn[d];
	}
	public String getRandomComputerLanguage()
	{
		String lang[]={"C","C++","C#","Java","Python","php","asm","VHDL","Shell","JavaScript","ASP","Lua"};
		Random r=new Random();
		int index=(r.nextInt(10000))%lang.length;
		return lang[index];
	}
	public String getRandomGroceryItem()
	{
	String grocery[]={"Milk","Bread","Honey","Butter","Biscuits","Nuts","Pie","Cake","Juice","Eggs","Fruit"
			,"IceCream","Coffee","Tea"};
	Random r=new Random();
	int index=(r.nextInt(10000))%grocery.length;
	return grocery[index];

	}

	//sg
	public String getRandomName()
	{
		String surnames[]={ "Acharya", "Adiga", "Agarwal", "Ahluwalia", "Ahuja", "Arora", "Bandopadhyay", "Banerjee", "Bharadwaj", "Bhatt","Khan","Husain","Bisram","Peer","Mattoo",
				"Bhattacharya", "Mahajan","Yadav","Ranjan","Sachdeva","Chaturvedi", "Chattopadhyay", "Chopra", "Desai", "Deshpande", "Devar", "Dhawan", "Dubashi", "Dutta", "Dwivedi", 
				"Gandhi", "Gill", "Gowda", "Guha", "Guneta", "Gupta", "Iyer", "Iyengar", "Jain", "Jha", "Johar", "Joshi", "Kakkar", "Kapoor", "Kaul", 
				"Kaur", "Khanna", "Khatri", "Kocchar", "Mahajan", "Malik", "Menon", "Mehra", "Mishra", "Mukhopadhyay", "Nair", "Nehru", "Pandey", 
				"Patel", "Pilla", "Prajapati","Choudhary", "Rana","Batra","Chabra","Bhatt", "Reddy", "Saini","John","Mathews","Agarwal","Dewan","Verma","Chawla",
				"Anand","Katich","Maran","Krishnan","Sethi", "Shah", "Sharma", "Shukla", "Singh", "Sinha", "Tagore", "Talwar", "Tandon", "Trivedi", "Varrier", "Varma", "Verma"};
		
		Random r=new Random();
		int sname=r.nextInt(100)%26+65;
		int l=surnames.length; 
		
		int index=r.nextInt(1000)%l;
		String name; 
		boolean available=true;
		char fn=(char)sname;
		int decide=r.nextInt(1000)%2;
		if(decide==1)
		{
			sname=r.nextInt(100)%26+65;
			char fn1=(char)sname;
			name=fn + ". " +fn1+" "+surnames[index];
				
		}
		else
		{
		name=fn + ". " +surnames[index];
		}
		
		/* May be slow*/
		//check if the name is already taken
		for(int i=0;i<this.lengthNamesTaken;i++)
		{
		if(name.equals(namesTaken[i]))
		{
			available=false;
			break;
		}
		}
		
		if(available)
		{
			namesTaken[this.lengthNamesTaken]=name;

			this.lengthNamesTaken++;
			return name;
		}
		else
			return getRandomName();
		
	}
	public String getRandomPhone()
	{
		long starting[]={8800000000l,9958000000l,9910000000l,9891000000l,8211000000l,9800000000l,9811000000l,8801000000l,7799000000l};
		Random r=new Random();
		long remaining=r.nextLong()%10000000;
		int index=r.nextInt(1000)%starting.length;
		Long nu=starting[index]+remaining;
		return nu.toString();
	}
	public String getRandomStateUT()
	{
		String state[]={"Andra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir",
				"Jharkhand","Karnataka","Kerala","Madya Pradesh","Maharashtra",
				"Manipur","Meghalaya","Mizoram","Nagaland","Orissa","Punjab","Rajasthan","Sikkim","Tamil Nadu","Tripura","Uttaranchal",
				"Uttar Pradesh","West Bengal","Delhi","Chandigarh","Dadra and Nagar Haveli","Lakshwadeep","Andaman and Nicobar","Daman and Diu","Pondicherry"};
		Random r=new Random();
		int index=(r.nextInt(10000))%state.length;
		return state[index];

	}
	public String getRandomWeather()
	{
		String weather[]={"Windy","Cloudy","Sunny","Chilly"};
		Random r=new Random();
		int index=(r.nextInt(10000))%weather.length;
		return weather[index];
		
	}
	public String getRandomMarks()
	{
		//use gaussian distribution
		Random r=new Random();
		Integer res = null;
		switch(r.nextInt(10000)%10)
		{
		case 0:
		case 1:
		
			res=r.nextInt(10000)%40+5; //4-44
			break;
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			res=r.nextInt(10000)%45+45; //45-89
			break;
	
		case 10:
		case 2:
			res=r.nextInt(10000)%11+90; //90-100
			break;
		}
		return res.toString();
	}

}
