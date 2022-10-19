package fr.vinbeau;

public class MyBillboard implements Billboard {
    final int height;
    final int width;
    final String text;

    public MyBillboard(int height, int width, String text) {
        this.height = height;
        this.width = width;
        this.text = text;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public String getText() {
        return text;
    }
}
