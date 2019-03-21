package com.hogwarts.register.db.beans;

public enum GradeYear {

    FRESHMAN("Freshman"),
    SOPHOMORE("Sophomore"),
    JUNIOR("Junior"),
    SENIOR("Senior");

    private final String text;

    GradeYear(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
