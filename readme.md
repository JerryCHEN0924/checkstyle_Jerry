# CheckStyle
## 簡介
Checkstyle 是一個用於 Java 程式碼的靜態代碼分析工具，主要用來檢查 Java 程式碼是否符合特定的編碼規範（Coding Standards）。它可以幫助開發者自動檢查代碼中的潛在問題，並保持代碼的一致性和可讀性。Checkstyle 可以集成到多種開發環境和持續集成系統中，如 Maven、Gradle、Ant、Eclipse 和 IntelliJ IDEA。
[官方文件](https://checkstyle.org/index.html)

**Checkstyle 的主要功能**
代碼風格檢查：檢查代碼是否符合特定的風格規範，如縮排、括號使用、變量命名等。
代碼質量檢查：檢查代碼中的潛在問題，如未使用的變量、過多的複雜度、過長的方法等。
報告生成：生成詳細的檢查報告，方便開發者修正代碼中的問題。
### 安裝和配置 Checkstyle
一.	Maven
1.在POM檔中加入plugin
```
<!-- checkstyle程式碼規範檢查 -->
			 <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-checkstyle-plugin</artifactId>
            <version>3.3.1</version>
            <configuration>
                <configLocation>src/main/resources/checkstyle.xml</configLocation>
                <consoleOutput>true</consoleOutput>
			<!-- true:如果有錯誤就會編譯失敗,false:顯示 -->
                <failsOnError>false</failsOnError>
                <failOnViolation>false</failOnViolation>
            </configuration>
            <executions>
                <execution>
					<id>validate</id>
                    <phase>validate</phase>
                    <goals>
                        <goal>check</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
```

**Maven Plugin的3.3.1版本，對應checkstyle的版本為9.3,適用java8以上**

2.根目錄中加入checkstyle.xml 文件，並添加你的檢查規範。
springboot專案，若是儲存在/src/main/resources/checkstyle.xml中
在POM檔需指定checkstyle.xml位置
如:`<configLocation>src/main/resources/checkstyle.xml</configLocation>`
```
<!DOCTYPE module PUBLIC
  "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN"
  "https://checkstyle.org/dtds/configuration_1_3.dtd">

<!-- 這是 Checker 模塊，所有檢查模塊的根節點 -->
<module name="Checker">

	<!-- 輸出層級為warning -->
	<property name="severity" value="warning"/>
	
	<!-- 使用正則表達式,檢查是否包含了標頭內容 -->
	<module name="RegexpHeader">
		<property name="headerFile"
			value="src/main/resources/header.txt" />
		<property name="fileExtensions" value="java" />
	</module>


	<!-- TreeWalker 處理 Java 源代碼樹的主要模塊 -->
	<module name="TreeWalker">
		<!-- 驗證標識符名稱中的縮寫（連續大寫字母）長度，它還允許強制實施駝峰式命名。 -->
		<module name="AbbreviationAsWordInName">
			<!-- 連續大寫字母長度最多五個字。 -->
			<property name="allowedAbbreviationLength" value="5" />
		</module>

		<!-- 檢查是否導入了沒有使用的類別 -->
		<module name="UnusedImports" />
		
		<!-- 檢查字串比對時是否有使用.equals。 -->
		<module name="StringLiteralEquality" />

		<!-- 檢查方法是否包含了參數、回傳值 -->
		<module name="JavadocMethod">
			<!-- 要檢查的封裝範圍 -->
			<property name="accessModifiers"
				value="public, protected, package, private" />
			<!-- 是否忽略對於參數的檢查 -->
			<property name="allowMissingParamTags" value="false" />
			<!-- 是否忽略對於回傳值的檢查 -->
			<property name="allowMissingReturnTag" value="false" />
			<!-- 是否忽略對於throws的檢查 -->
			<property name="validateThrows" value="false" />
		</module>


	</module>

	<!-- 檢查是否有超過指定長度的行 -->
	<module name="LineLength">
		<property name="max" value="100" />
	</module>


</module>

```
 
3.建立一個.java後建立一些案例，
即可使用MAVEN執行checkstyle:check，即啟動檢查。
例如:
```
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

	/**
	 * @Description : TODO 請描述此方法的功能/作用
	 * @author : jerrychen
	 * @since v1.0.0
	 */

	public void exampleMethod() {
		System.out.println("This is an example method.");
	}

	public int XOOOOOOO(int x) {
		System.out.println("This is an example method.");
		return x;
	}

	/**
	 * 
	 * @Description : TODO 請描述此方法的功能/作用
	 * @param a
	 * @return String
	 * @throws Exception
	 * @author : jerrychen
	 * @since v1.0.0
	 */
	public static String abc(String a) throws Exception {

		return a;
	}
}
```
二.	集成到IDE中如:Eclipse Plugin、IntelliJ IDEA
1.打開Eclipse Marketplace搜尋Checkstyle並安裝插件
2. 配置 Checkstyle：安裝後，可以在 "Window" -> "Preferences" -> "Checkstyle" 中配置 Checkstyle，添加自定義的配置文件。

三.	下載JAR用命令行的方式執行(不推薦)
範例:`java -jar “checkstyle的jar檔” -c “規範風格的xml檔” “要掃描的對象”`
使用:`java -jar checkstyle-X.XX-all.jar -c /google_checks.xml MyClass.java`

參考資料:
https://www.zhaowenyu.com/maven-doc/maven-checkstyle-plugin.html
https://blog.csdn.net/qq_34595352/article/details/117363833


