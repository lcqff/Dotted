package dotted.schedule.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum DayOfWeek {

    Mon(1),
    Tue(2),
    Wed(3),
    Thu(4),
    Fri(5),
    Sat(6),
    Sun(7);

    private int value;

    DayOfWeek(int value) {
        this.value = value;
    }
}