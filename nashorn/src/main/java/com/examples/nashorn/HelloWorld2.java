package com.examples.nashorn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class HelloWorld2 {
	
	private String filePath;
	private File scriptFile;
	
	public HelloWorld2() {
		filePath = "com/examples/nashorn/helloWorld.js";
		scriptFile = new File(getClass().getClassLoader().getResource(filePath).getFile());
	}

	public static void main(String[] args) throws FileNotFoundException, ScriptException {

		//Javascript code can either be evaluated directly by passing 
		//javascript code as a string as shown above. 
		//Or you can pass a file reader pointing to your .js script file:
		HelloWorld2 app = new HelloWorld2();
		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader(app.getScriptFile()));
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public File getScriptFile() {
		return scriptFile;
	}

	public void setScriptFile(File scriptFile) {
		this.scriptFile = scriptFile;
	}
}
