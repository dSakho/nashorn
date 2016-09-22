package com.examples.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * This is what a simple Hello World progran looks like
 * when leveraging Nashorn
 */
public class HelloWord {
	
	public static void main(String[] args) throws ScriptException {
		
		//In order to evaluate javascript code from java, 
		//you first create a nashorn script engine by utilizing 
		//the javax.script package already known from 
		//Rhino (Javas legacy js engine from Mozilla).
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval("print('Hello World!');");
	}

}
