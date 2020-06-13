package br.com.yurekesley.feature.event.observers;

import java.io.Serializable;

public interface EventObserver<T extends Serializable> {
    
    public void listen(T target);

}
