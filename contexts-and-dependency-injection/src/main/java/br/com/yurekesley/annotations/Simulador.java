package br.com.yurekesley.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

import br.com.yurekesley.model.PlanoDeCargos;

@Target({ TYPE, FIELD, METHOD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Simulador {
    PlanoDeCargos planoDeCargos() default PlanoDeCargos.VERSAO_2005;
    boolean planoAprovado() default true;
    @Nonbinding boolean enviarNotificacao() default false;
}
