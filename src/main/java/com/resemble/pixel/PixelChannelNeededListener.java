package com.resemble.pixel;

public interface PixelChannelNeededListener<T extends Number> {

    /**
     * Called on a channel before value is returned in {@link PixelChannel#getValue() } if value is not available.
     *
     * @param source
     */
    void valueNeeded(PixelChannel<T> source);
}
