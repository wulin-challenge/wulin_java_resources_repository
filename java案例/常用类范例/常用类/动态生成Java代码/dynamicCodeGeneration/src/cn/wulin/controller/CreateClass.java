package cn.wulin.controller;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class CreateClass {
	
		private static String CLASS_NAME = "CreateClassTest";
		private static String CLASS_FILE = CLASS_NAME + ".java";
		private static String CLASS_PATH = "/src/dynamic/path/";

		public static void main(String args[]) {
		CreateClass mtc = new CreateClass();
		mtc.createClass();
		System.out.println("javac " + CLASS_FILE);
		mtc.compileClass();
		System.out.println("java " + CLASS_NAME);
		mtc.runClass();
		}

		public void createClass() {
		try {
		String path =Thread.currentThread().getContextClassLoader().getResource("./").getPath();
		int lastIndex = path.lastIndexOf("/bin");
		path = path.substring(0,lastIndex)+CLASS_PATH;
		
		System.out.println("path: " +path);
		new File(path+CLASS_FILE).delete();
		FileWriter aWriter = new FileWriter(path+CLASS_FILE, true);
		aWriter.write("package dynamic.path;");
		aWriter.write("public class " + CLASS_NAME + "{");
		aWriter.write("public void println() {");
		//aWriter.write("System.out.println(\"=" + CLASS_NAME + "=\");");
		aWriter.write("System.out.println(\"haha\");");
		aWriter.write("}}");
		aWriter.flush();
		aWriter.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		}

		public void compileClass() {
		//String filePath = new File(CreateClass.class.getClassLoader().getResource("").getFile()).getAbsolutePath();
		String path =Thread.currentThread().getContextClassLoader().getResource("./").getPath();
		int lastIndex = path.lastIndexOf("/bin");
		path = path.substring(0,lastIndex)+CLASS_PATH;
		//System.out.println("===="+filePath);
		String[] source = { "-d", path, new String(CLASS_FILE) };
		//com.sun.tools.javac.Main.compile(source);
		//compile(source);
		System.out.println("javac out:"+ com.sun.tools.javac.Main.compile(source));
		}

		public void runClass() {
		try {
		Class params[] = {};
		Object paramsObj[] = {};
		Class testClass = Class.forName("dynamic.path."+CLASS_NAME);
		Object iClass = testClass.newInstance();
		Method thisMethod = testClass.getDeclaredMethod("println", params);
		thisMethod.invoke(iClass, paramsObj);
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		


}
