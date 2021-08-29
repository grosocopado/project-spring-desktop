/**
 * 
 */
package com.devpredator.projectspringdesktop.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.devpredator.projectspringdesktop.dao.DisqueraDAO;
import com.devpredator.projectspringdesktop.dao.impl.DisqueraDAOImpl;

/**
 * @author pablo
 *Clase de prueba unitaria que permite realizar pruebas con el 
 *framework SPRING
 */
class SpringDesktopTest {

	@Test
	void testContext() {
		// en que directorio del proyecto se encuentra el application context
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		assertNotNull(context);//verificar que el context llegue con informacion
		
		DisqueraDAO disqueraDao=(DisqueraDAO) context.getBean("disqueraDAO");
		// getBean nos va a permitir utilizar un bean que se encuentre dentro del xml del applicationContext o del contexto de Spring
		
		//no tengo que hacer un new de este objeto, lo hago a traves de getBean
		
		//es la forma por la cual se genera un bean a través del applicationContext
		
		assertNotNull(disqueraDao);//un parámetro pasado no debe ser null, si es nulo 
		//el caso de prueba falla
		
		DisqueraDAO disqueraDaoNuevo=(DisqueraDAO) context.getBean("disqueraDAO");
		
		DisqueraDAO disqueraDaoSinSpring = new DisqueraDAOImpl();
		DisqueraDAO disqueraDaoSinSpringNuevo = new DisqueraDAOImpl();
		
		System.out.println("Context cargado exitosamente");
		System.out.println(disqueraDao);// singleton
		System.out.println(disqueraDaoNuevo);//singleton
		
		System.out.println(disqueraDaoSinSpring);// instancia comun
		System.out.println(disqueraDaoSinSpringNuevo);//instancia comun
		
		//PROPERTIES
		
		Properties properties=(Properties)context.getBean("properties");
		//va el mismo nombre que está en el id del application context
		System.out.println(properties.get("spring-username"));
		//nos va a dar el resultado de esa variable
		
	}

}
