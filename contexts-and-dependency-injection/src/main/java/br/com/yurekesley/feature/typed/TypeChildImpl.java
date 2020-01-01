package br.com.yurekesley.feature.typed;

import javax.enterprise.inject.Typed;

/**
 * É bean candidato, apenas para tipo definido na anotacao
 */
@Typed(TypeChildImpl.class)
public class TypeChildImpl extends TypedParentImpl {

}
