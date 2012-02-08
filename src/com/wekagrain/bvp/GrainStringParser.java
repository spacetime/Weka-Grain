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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GrainStringParser {
	private String grain;
	File f;
	private Integer numberOfAttributes,numberOfRecords;
	private String attributeList[];
	private int attribInfo[];
	RandomDataProvider rdp;
	int typeOfFile;
	private static final int  ID=1,DEPT=2,YES_NO=3,TRUE_FALSE=4,GENDER=5,PHONE=6,NAME=7,COMPLANG=8,GROCERY=9,STATE=10,MARKS=11,WEATHER=12;
	GrainStringParser(String grain,int numberOfRecords,int typeOfFile,File f)
	{
	rdp=new RandomDataProvider();
		this.f=f;
		this.typeOfFile=typeOfFile;
		this.numberOfRecords=numberOfRecords;
		this.grain=grain;
		parseGrainString();
		if(this.typeOfFile==0)
		{
			arffWriter();
		}
		else
		{
		CSVWriter();
		}
	}
	private void parseGrainString()
	{
		int i=0;
		String attribs[]= grain.split(";");
		this.numberOfAttributes=attribs.length;
		attributeList=new String[this.numberOfAttributes];
		attribInfo=new int[this.numberOfAttributes]; 
		for(String attrib:attribs)
		{
			String nameType[]=attrib.split(":");
			attributeList[i]=nameType[0];
			if(nameType[1].equalsIgnoreCase("int_id"))
			{
				attribInfo[i]=ID;
			}
			else if(nameType[1].equalsIgnoreCase("dept"))
			{
				attribInfo[i]=DEPT;
			}
			else if(nameType[1].equalsIgnoreCase("yn"))
			{
				attribInfo[i]=YES_NO;
			}
			else if(nameType[1].equalsIgnoreCase("tf"))
			{
				attribInfo[i]=TRUE_FALSE;
			}
			else if(nameType[1].equalsIgnoreCase("gender"))
			{
				attribInfo[i]=GENDER;
			}
			else if(nameType[1].equalsIgnoreCase("ph"))
			{
				attribInfo[i]=PHONE;
			}
			else if(nameType[1].equalsIgnoreCase("name"))
			{
				attribInfo[i]=NAME;
			}

			else if(nameType[1].equalsIgnoreCase("clang"))
			{
				attribInfo[i]=COMPLANG;
			}
			else if(nameType[1].equalsIgnoreCase("grocery"))
			{
				attribInfo[i]=GROCERY;
			}
			else if(nameType[1].equalsIgnoreCase("state"))
			{
				attribInfo[i]=STATE;
			}
			else if(nameType[1].equalsIgnoreCase("marks"))
			{
				attribInfo[i]=MARKS;
			}
			else if(nameType[1].equalsIgnoreCase("weather"))
			{
				attribInfo[i]=WEATHER;
			}
			System.out.println(this.attributeList[i]);
			i++;	
		
		}
	}
	//sg
	private void arffWriter()
	{
		String filePath=f.getAbsolutePath();
		try {
			PrintWriter pw=new PrintWriter(filePath);
			// ####################HEADER PRINTER ########################
			//generate Header Section
			pw.write("%sg\n");
			pw.write("@RELATION SG1\n");
			String name="",type="";
			//now write all the attributes with types
			for(Integer i=0;i<this.numberOfAttributes;i++)
			{
				switch(attribInfo[i])
				{
				case ID:
					name="ID_"+i.toString();
					type="numeric";
					break;
				case PHONE:
					name="PHONE_";
					type="numeric";
					break;
				case DEPT:
					name="DEPARTMENT_"+i.toString();
					type="{\"CSE\",\"IT\",\"EEE\",\"ECE\",\"ICE\"}";
					break;
				case YES_NO:
					type="{\"Yes\",\"No\"}";
					name="Yes-No_"+i.toString();
					break;
				case TRUE_FALSE:
					type="{\"True\",\"False\"}";
					name="TrueFalse_"+i.toString();
					break;
				case GENDER:
				
					type="{\"Male\",\"Female\"}";
					name="Gender_"+i.toString();
					break;
				case NAME:
					name="NAME_"+i.toString();
					type="string";
					break;
				case COMPLANG:
					type="{\"C\",\"C++\",\"C#\",\"Java\",\"Python\",\"php\",\"asm\",\"VHDL\",\"Shell\",\"JavaScript\",\"ASP\"}";
					name="ComputerLanguage_"+i.toString();
					break;
				case GROCERY:
					type="{\"Milk\",\"Bread\",\"Honey\",\"Butter\",\"Biscuits\",\"Nuts\",\"Pie\",\"Cake\",\"Juice\",\"Eggs\",\"Fruit\",\"IceCream\",\"Coffee\",\"Tea\"}";
					name="GroceryItem_"+i.toString();
					break;
				case STATE:
					name="STATE_"+i.toString();
					type="string";
					break;
				case WEATHER:
					name="WEATHER_"+i.toString();
					type="{\"Windy\",\"Cloudy\",\"Sunny\",\"Chilly\"}";
					break;
					case MARKS:
					name="MARKS_"+i.toString();
					type="numeric";
					break;
				}
				pw.write("@ATTRIBUTE "+name+" "+type+"\n");
				
			}
			//##################### HEADER DONE ########################
			
			//##########NOW WRITE DATA SECTION #########################
			pw.write("@data\n");
			writeCSVData(pw);
			pw.flush();
			pw.close();
			
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	private void CSVWriter()
	{
		System.out.println("WRITING "+this.numberOfRecords.toString()+" RECORDS WITH "+this.numberOfAttributes +"ATTRIBUTES");
		try{
			String filePath=f.getAbsolutePath();
			PrintWriter pw=new PrintWriter(filePath);
			for(int i=0;i<this.numberOfAttributes;i++)
			{
				if(i==this.numberOfAttributes-1){
				pw.write(this.attributeList[i]+"\n");
			}
				else
				{
					pw.write(this.attributeList[i]+",");
				}
			}
		writeCSVData(pw);	
		pw.flush();
		pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
			void writeCSVData(PrintWriter pw)
			{
			String attribVal=null;
			for(int i=0;i<this.numberOfRecords;i++)  //for each row
			{
				for(int j=0;j<this.numberOfAttributes;j++) //for each record
				{
					switch(attribInfo[j])
					{
					case ID:
						Integer id=i+1;
						attribVal=id.toString();
						break;
					case DEPT:
						attribVal=rdp.getRandomDept();
						break;
					case YES_NO:
						attribVal=rdp.getYesNo();
						break;
					case TRUE_FALSE:
						attribVal=rdp.getTrueFalse();
						break;
					case GENDER:
						attribVal=rdp.getGender();
						break;
					case PHONE:
						attribVal=rdp.getRandomPhone();
						break;
					case NAME:
						attribVal="\""+rdp.getRandomName()+"\"";
						break;
					case COMPLANG:
						attribVal=rdp.getRandomComputerLanguage();
						break;
					case GROCERY:
						attribVal=rdp.getRandomGroceryItem();
						break;
					case STATE:
						attribVal="\""+rdp.getRandomStateUT()+"\"";
						break;
					case WEATHER:
						attribVal=rdp.getRandomWeather();
						break;
					case MARKS:
						attribVal=rdp.getRandomMarks();
						break;
					}  //got the value for attribute,now write it 
			
					if(j==(this.numberOfAttributes-1))
					{
						pw.write(attribVal+"\n");
						//System.out.println(attribVal);
					}
					else
					{
						pw.write(attribVal+",");
						//System.out.print(attribVal+",");
							
					}
					
				}
			}
		
		}


}

