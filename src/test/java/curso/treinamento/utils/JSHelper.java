package curso.treinamento.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import curso.treinamento.setup.Hooks;

public class JSHelper {
	
	/* 
	 * Descrição: Realiza scroll na página
	 * Parametros: O X representa o scroll horizontal e o Y o vertical
	 * 		O X negativo move para a esquerda, O Y negativo move para cima
	 */
	public static void scroll_pagina(int x, int y) { 
	
		JavascriptExecutor js = (JavascriptExecutor) Hooks.getDriver();
		
		String scriptJS = "window.scrollBy(" + x + ", "+ y +")";	
		js.executeScript(scriptJS);				
	}
	
	/* 
	 * Descrição: Realiza scrool até o WebElement
	 */	
	public static void scroll_ate_elemento(WebElement elemento) { 
		
		JavascriptExecutor js = (JavascriptExecutor) Hooks.getDriver();
		
		String scriptJS = "arguments[0].scrollIntoView();";		
		js.executeScript(scriptJS, elemento);
	}	
	
	/* 
	 * Descrição: Realiza scroll em "SubPáginas" usando CSS
	 * Parametros: O X representa o scroll horizontal e o Y o vertical
	 * 		O X negativo move para a esquerda, O Y negativo move para cima
	 */
	public static void scroll_elemento(String css, int x, int y) { 
				
		String scriptJS = "document.querySelector('"+ css +"').scrollBy("+ x +"," + y + ");";
		 
		JavascriptExecutor jsExec = (JavascriptExecutor)Hooks.getDriver();	
		jsExec.executeScript(scriptJS);
	}
}