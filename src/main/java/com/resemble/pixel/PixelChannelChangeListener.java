package com.resemble.pixel;

public interface PixelChannelChangeListener<T extends Number> {

    /**
     * Called on a channel after value is changed by {@link PixelChannel#setValue(java.lang.Number) }.
     *
     * @param source channel executing callback
     * @param oldValue previous value (new one can be obtained with {@link PixelChannel#getValue() })s
     */
    void valueChanged(PixelChannel<T> source, T oldValue);
}
