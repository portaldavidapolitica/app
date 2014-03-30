package net.pvp.portal.bo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDelegator {

	private static BeanDelegator me;
	private ApplicationContext appContext;

	public BeanDelegator(){
		this.appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
	}

	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		this.appContext = applicationContext;
	}


	public static BeanDelegator getInstance(){
		if(BeanDelegator.me == null){
			BeanDelegator.me = new BeanDelegator();
		}
		return BeanDelegator.me;
	}


	public UsuarioBO getUsuarioBO(){
		return(UsuarioBO) this.appContext.getBean("usuario");
	}

	public PermissaoBO getPermissaoBO(){
		return (PermissaoBO) this.appContext.getBean("permissao");
	}

}
