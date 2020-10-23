package com.resemble.pixel.impl;

public class BytePixelChannelImpl extends AbstractPixelChannelImpl<Integer> {

    private static final Integer MIN_VALUE = 0;
    private static final Integer MAX_VALUE = 255;

    public BytePixelChannelImpl(Channel channel, Integer value) {
        super(channel, value);
    }

    public BytePixelChannelImpl(Channel channel) {
        super(channel);
    }

    @Override
    protected boolean checkValueRange(Integer value) {
        return (value >= MIN_VALUE && value <= MAX_VALUE);
    }

    @Override
    protected boolean checkSimilarity(Integer thisValue, Integer bValue, Integer tolValue) {
        return (Math.abs(thisValue - bValue) <= tolValue);
    }

    @Override
    protected Integer getMinValue() {
        return MIN_VALUE;
    }

    @Override
    protected Integer getMaxValue() {
        return MAX_VALUE;
    }
    
    @Override
    protected Integer fromString(String string) {
		return Integer.parseInt(string);
	}
}
