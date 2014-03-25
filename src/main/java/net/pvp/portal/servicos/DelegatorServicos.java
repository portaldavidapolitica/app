package net.pvp.portal.servicos;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DelegatorServicos {

	private static DelegatorServicos me;
	private ApplicationContext appContext;

	public DelegatorServicos(){
		this.appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
	}

	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		this.appContext = applicationContext;
	}


	public static DelegatorServicos getInstance(){
		if(DelegatorServicos.me == null){
			DelegatorServicos.me = new DelegatorServicos();
		}
		return DelegatorServicos.me;
	}


	public UsuarioServ getUsuarioServ(){
		return(UsuarioServ) this.appContext.getBean("usuario");
	}

	public PermissaoServ getPermissaoServ(){
		return (PermissaoServ) this.appContext.getBean("permissao");
	}

}
