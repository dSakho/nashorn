package com.examples.nashorn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Nashorn supports the invocation of javascript functions 
 * defined in your script files directly from java code. 
 * You can pass java objects as function arguments and 
 * return data back from the function to the calling java method.
 */
public class BasicFunctions {

	private String filePath;
	private File scriptFile;
	
	public BasicFunctions() {
		filePath = "com/examples/nashorn/basicFunctions.js";
		scriptFile = new File(getClass().getClassLoader().getResource(filePath).getFile());
	}
	
	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
		
		BasicFunctions app = new BasicFunctions();
		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader(app.getScriptFile()));

		// In order to call a function you first have to cast 
		// the script engine to Invocable. The Invocable interface is 
		// implemented by the NashornScriptEngine implementation 
		// and defines a method invokeFunction to call a javascript 
		// function for a given name.
		
		// Calling the function print pipes the result to System.out, 
		// so we see the javascript message first.
		Invocable invocable = (Invocable) engine;

		Object result = invocable.invokeFunction("fun1", "Daouda");
		System.out.println(result);
		System.out.println(result.getClass());
		
		// Java objects can be passed without loosing any type 
		// information on the javascript side. 
		// Since the script runs natively on the JVM we can 
		// utilize the full power of the Java API or external libraries on nashorn.
		invocable.invokeFunction("fun2", new Date());
		invocable.invokeFunction("fun2", LocalDateTime.now());
		invocable.invokeFunction("fun2", new ConcurrentHashMap<>());		
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
