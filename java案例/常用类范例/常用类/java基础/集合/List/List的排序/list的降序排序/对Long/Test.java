package cn.scxh.servlet.package2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Test implements Comparator<Long>{
	public static void main(String[] args) {
		Test test=new Test();
		List<Long> longList=test.getAllUser();
		//Collections.sort(longList,test);
		Collections.sort(longList,new Comparator<Long>(){

			public int compare(Long o1, Long o2) {
				
				return -o1.compareTo(o2);
			}
			
		});
		for (Long l :longList ) {
			System.out.println(l);
		}
		
	}
	
	public List<Long> getAllUser(){
		List<Long> longList=new ArrayList<Long>();
		Random r=new Random();
		for(int i=0;i<10;i++){
			longList.add((long)(r.nextInt(100)));
		}
		return longList;
	}
	

	public int compare(Long o1, Long o2) {
		
		return (int)(o1-02);
	}

}
