package com.example.last_project.common;

public class AskDTO {
    private String key , value; // AsyncTask실행시 name부분과 text부분을
                                //유동적으로 사용하고 더 편리하게 사용하기위함.

    public AskDTO(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
