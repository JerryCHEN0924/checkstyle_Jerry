/**
 * @ClassName : TestBean.java
 * @Copyright : Copyright (c) 2024 HiTRUST All Rights Reserved.
 * @author    : jerrychen
 * @ModifyHistory : 
 *  v1.0.0, 2024/06/03, jerrychen
 *   1) First Release.
 */

// 上面的標頭注釋，因少了@Description，未符合正則表達式所規範，所以顯示出錯誤。
package com.example.CheckStyle;

import java.applet.*;
/*
 *  會被檢查出錯誤,因為有未使用的import
 *  其實還可以更仔細的限制禁止引用所有類別底下的import,也就是禁止.*
 */
import javax.xml.XMLConstants;

public class TestBean {
	/**
	 * 會員名稱
	 */
	String member; //OK 有正確的注釋方式。注意要2個*才是注釋,否則只是多行註解
	
	//年紀
	int age; //會被檢查出錯誤,因為使用錯誤的注釋方式
	
	/*
	 * 你猜猜看這是做什麼用的啊?
	 */
	int guessWhat;//會被檢查出錯誤,因為使用錯誤的注釋方式
}
