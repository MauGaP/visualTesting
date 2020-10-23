package com.resemble.pixel.impl;

import com.resemble.pixel.Pixel;
import com.resemble.pixel.PixelChannel;
import com.resemble.pixel.PixelChannelChangeListener;
import com.resemble.pixel.PixelChannelNeededListener;

public abstract class AbstractPixelChannelImpl<T extends Number> implements PixelChannel<T> {

    private final Channel channel;
    private T value;
    private boolean available;
    private PixelChannelChangeListener<T> changeListener;
    private PixelChannelNeededListener<T> neededListener;
    private boolean listenerCalled = false;

    protected AbstractPixelChannelImpl(Channel channel, T value) {
        this.channel = channel;
        this.value = value;
        this.available = true;
    }

    protected AbstractPixelChannelImpl(Channel channel) {
        this.channel = channel;
        this.available = false;
    }

    @Override
    public String toString() {
        return "" + channel + "=" + (available ? String.valueOf(value) : "???");
    }

    @Override
    public boolean isSame(PixelChannel<T> b) {
        if (this == b) {
            return true;
        }
        T thisValue = getValue();
        T bValue = (T) b.getValue();
        return (thisValue == bValue);
    }

    @Override
    public boolean isColorSimilar(PixelChannel<T> b, Pixel tolerance) {
        if (this == b) {
            return true;
        }
        if (getChannel() != b.getChannel()) {
            throw new IllegalArgumentException(String.format("Channel mismatch this.channel=%s and b.channel=%s",
                    getChannel(), b.getChannel()));
        }

        T thisValue = getValue();
        T bValue = (T) b.getValue();
        if (thisValue == bValue) {
            return true;
        }

        T tolValue = (T) tolerance.get(getChannel()).getValue();
        return checkSimilarity(thisValue, bValue, tolValue);
    }

    @Override
    public T getValue() throws IllegalStateException {
        if (!isAvailable()) {
            if (neededListener != null) {
                neededListener.valueNeeded(this);
            }
            if (!isAvailable()) {
                throw new IllegalStateException("Channel " + channel + " is not available");
            }
        }
        return value;
    }
    
    @Override
    public String getStringValue() throws IllegalStateException {
		return String.valueOf(getValue());
	}

	@Override
    public void setValue(String string) throws IllegalArgumentException {
		T value;
		try {
			value = fromString(string);
		} catch (Throwable e) {
			throw new IllegalArgumentException(String.format(
				"Could not convert string '%s' value into %s channel %s",
					string, getClass().getSimpleName(), getChannel()), e);
		}
		setValue(value);
	}

    @Override
    public void setValue(T value) throws IllegalArgumentException {
        if (!checkValueRange(value)) {
            throw new IllegalArgumentException(String.format("Value of %s is out of range [%s .. %s] for channel %s",
                    value, getMinValue(), getMaxValue(), channel));
        }
        T oldValue = this.value;
        this.value = value;
        if (changeListener != null && !listenerCalled) {
            listenerCalled = true;
            changeListener.valueChanged(this, oldValue);
            listenerCalled = false;
        }
        this.available = true;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public PixelChannel setChangedListener(PixelChannelChangeListener<T> listener) {
        this.changeListener = listener;
        return this;
    }

    @Override
    public PixelChannel setNeededListener(PixelChannelNeededListener<T> neededListener) {
        this.neededListener = neededListener;
        return this;
    }

    protected abstract boolean checkValueRange(T value);

    protected abstract boolean checkSimilarity(T thisValue, T bValue, T tolValue);

    protected abstract T getMinValue();

    protected abstract T getMaxValue();
    
    protected abstract T fromString(String string);

}
