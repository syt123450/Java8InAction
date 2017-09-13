package com.java8.chapter8.process;

/**
 * Created by ss on 2017/9/13.
 */
public abstract  class ProcessingObject<T> {

    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {

        T result = handleWord(input);
        if (successor != null) {
            return successor.handle(result);
        }

        return result;
    }

    abstract protected T handleWord(T input);
}
