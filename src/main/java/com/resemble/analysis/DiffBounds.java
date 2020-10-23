package com.resemble.analysis;

public class DiffBounds {

    private int top;
    private int left;
    private int bottom;
    private int right;

    @Override
    public String toString() {
        return "DiffBounds{" + "top=" + top + ", left=" + left + ", bottom=" + bottom + ", right=" + right + '}';
    }

    public void updateBound(int x, int y) {
        left = Math.min(x, left);
        right = Math.max(x, right);
        top = Math.min(y, top);
        bottom = Math.max(y, bottom);
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
