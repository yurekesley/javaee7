package br.com.yurekesley.feature.extensions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.util.AnnotationLiteral;

public class AnnotatedTypeControllerWrapper implements AnnotatedType {

    private AnnotatedType wrapped;

    AnnotatedTypeControllerWrapper(AnnotatedType original) {
	this.wrapped = original;
    }

    @Override
    public Set<Annotation> getAnnotations() {
	Set<Annotation> annotations = new HashSet<>(wrapped.getAnnotations());
	annotations.add(new AnnotationLiteral<Controller>() {
	    private static final long serialVersionUID = 1L;

	});
	return annotations;
    }

    @Override
    public Class getJavaClass() {
	return wrapped.getJavaClass();
    }

    public Type getBaseType() {
	return wrapped.getBaseType();
    }

    public Set<Type> getTypeClosure() {
	return wrapped.getTypeClosure();
    }

    public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
	return wrapped.getAnnotation(annotationType);
    }

    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
	return wrapped.isAnnotationPresent(annotationType);
    }

    public Set getConstructors() {
	return wrapped.getConstructors();
    }

    public Set getMethods() {
	return wrapped.getMethods();
    }

    public Set getFields() {
	return wrapped.getFields();
    }

}
