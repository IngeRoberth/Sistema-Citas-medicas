package model;

import java.util.Date;

public interface ISchedulable {

    void schedule(Date date, String time);

    void schedule(String date, String time);
}
