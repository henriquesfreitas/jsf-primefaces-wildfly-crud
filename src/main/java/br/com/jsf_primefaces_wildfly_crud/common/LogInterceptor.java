package br.com.agendamento_simples.common;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@AroundInvoke
    public Object intercepta(InvocationContext contex) throws Exception {

        long millis = System.currentTimeMillis();

        Object o = contex.proceed();

        String nomeClasse = contex.getTarget().getClass().getSimpleName();
        String nomeMetodo = contex.getMethod().getName();

        System.out.println("[INFO] " + nomeClasse + "->" + nomeMetodo);

        System.out.println("[INFO] Total: "
                + (System.currentTimeMillis() - millis) + "ms");

        return o;

    }

}
