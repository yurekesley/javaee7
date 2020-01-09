package br.com.yurekesley.feature.event;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import br.com.yurekesley.model.TipoDesligamento;

@Target({ TYPE, FIELD, METHOD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Desligamento {
    TipoDesligamento value() default TipoDesligamento.APOSENTADORIA;
}
