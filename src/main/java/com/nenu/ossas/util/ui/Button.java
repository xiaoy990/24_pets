package com.nenu.ossas.util.ui;

public class Button {
    String href;
    String value;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Button{" +
                "href='" + href + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
