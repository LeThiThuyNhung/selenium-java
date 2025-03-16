package org.example;

public enum Rating {
    XUAT_SAC(9.0, "Xuất sắc"),
    GIOI(8.0, "Giỏi"),
    KHA(6.5, "Khá"),
    TRUNG_BINH(5.0, "Trung bình"),
    YEU(0.0, "Yếu");
    ;
    private final double score;
    private final String description;
    Rating(double score, String description) {
        this.score = score;
        this.description = description;
    }

    public static Rating getRating(double score) {
        for (Rating rating : Rating.values()) {
            if (score >= rating.score) {
                return rating;
            }
        }
        return null;
    }

    public String getDescription() {
        return description;
    }
}