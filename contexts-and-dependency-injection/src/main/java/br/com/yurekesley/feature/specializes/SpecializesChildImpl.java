package br.com.yurekesley.feature.specializes;

import javax.enterprise.inject.Specializes;

/**
 * Specializing bean may not declare a bean name if it is declared by specialized bean
Se o parent tem a anotação @Named, não se pode sobrescrever o nome do bean
para evitar erros em JSP, ou JSF, que usam o nome do beam parent
mas a instancia que resolve-rá será a unica anotada com @Specializes

 @Named("pecializesChild")
 */
@Specializes
public class SpecializesChildImpl extends SpecializesParentImpl {

}
