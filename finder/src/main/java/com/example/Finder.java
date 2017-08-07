package com.example;


import com.example.provider.Provider;

/**
 * Created by Administrator on 2016-07-27.
 */
public interface Finder<T> {
    /**
     *
     * @param host
     * @param source
     * @param provider
     */
    void inject(T host, Object source, Provider provider);
}
