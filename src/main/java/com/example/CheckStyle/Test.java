/**
 * @Description : TODO 請描述此檔案的作用
 * @ClassName : Test.java
 * @Copyright : Copyright (c) 2024 HiTRUST All Rights Reserved.
 * @author    : jerrychen
 * @ModifyHistory : 
 *  v1.0.0, 2024/05/29, jerrychen
 *   1) First Release.
 */

package com.example.CheckStyle;

public class Test {

	public int TTTTTTT(int x) { //會被檢查出錯誤,因方法使用超過指定數目的大寫字母
		System.out.println("This is an example method.");
		return x;
	}
	
	public int TTTTT(int x) { //會被檢查出錯誤,因單行長度超過100個字
		System.out.println("This is an example mThis isample masethodThis is an example mas.");
		return x;
	}
	
	public void test1(int x) { //OK
		System.out.println("This is an example method.");
	}
	
	public void _test1(int x) { //會被檢查出錯誤,因方法前有下底線
		System.out.println("This is an example method.");
	}
	
	public void Test2__(int x) { //會被檢查出錯誤,因方法前有下底線
		System.out.println("This is an example method.");
	}

	public void testMethodOver15word(int x) { //會被檢查出錯誤,因方法命名超過15字
		System.out.println("This is an example method.");
	}
	
	/**
	 * @Description : TODO 請描述此方法的功能/作用
	 * @author : jerrychen
	 * @since v1.0.0
	 */
	public void testMethodNotOk(int x) { //會被檢查出錯誤,因注釋未包含return參數值
		System.out.println("This is an example method.");
	}
	/**
	 * 
	 * @Description : TODO 請描述此方法的功能/作用
	 * @param x
	 * @author : jerrychen
	 * @since v1.0.0
	 */
	public void testMethodOk(int x) { //OK
		System.out.println("This is an example method.");
	}

	static final int ALWAYSYOUNGAGE = 18; //OK
	static final int YOUNGage = 18; //會被檢查出錯誤,常數必須全大寫

	//會被檢查出錯誤,因為catch exception後不能空白,應該要印log或做其他處理,或寫註解
	public String abcd(String a) throws Exception {
		try {
			
		} catch (Exception e) {
			
		}
		return a;
	}
	
	/**
	 * @Description : TODO 請描述此方法的功能/作用
	 * @param a
	 * @return String
	 * @throws Exception
	 * @author : jerrychen
	 * @since v1.0.0
	 */
	public String abc(String a) throws Exception {
		int jerryAge = 18;
		int arickAge = 19;
		int stillYoung = jerryAge+arickAge; //會顯示出錯誤,計算符號前後需要有空格
		
		return a;
	}
	
	public boolean stringCompare() {
		String yjcLastName = "YANG";
		String yjcFirstName = "JC";
		if (yjcLastName == "JC") { //會顯示出錯誤,字串比對需使用.equals
			System.out.println("字串比對應使用.equals");
		}
		
		if (yjcLastName.equals(yjcFirstName)) {
			return true;
		} else {
			return false;
		}
	}
}
