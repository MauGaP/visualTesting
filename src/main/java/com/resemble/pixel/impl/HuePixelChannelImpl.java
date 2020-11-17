package com.resemble.pixel.impl;

public class HuePixelChannelImpl extends AbstractPixelChannelImpl<Double> {

    private static final Double MIN_VALUE = 0.0;
    private static final Double MAX_VALUE = Double.MAX_VALUE;

    public HuePixelChannelImpl(Channel channel, Double value) {
        super(channel, value);
    }

    public HuePixelChannelImpl(Channel channel) {
        super(channel);
    }

    @Override
    protected boolean checkValueRange(Double value) {
        return (value >= MIN_VALUE && value <= MAX_VALUE);
    }

    @Override
    protected boolean checkSimilarity(Double thisValue, Double bValue, Double tolValue) {
        return (Math.abs(thisValue - bValue) <= tolValue);
    }

    @Override
    protected Double getMinValue() {
        return MIN_VALUE;
    }

    @Override
    protected Double getMaxValue() {
        return MAX_VALUE;
    }
    
    @Override
    protected Double fromString(String string) {
		return Double.parseDouble(string);
	}
}
