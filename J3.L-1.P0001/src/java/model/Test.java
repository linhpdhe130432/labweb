/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author DuongDT
 */
public class Test {
    private Users user;
    private long endTime;
    private List<Question> listQuestion;
    private long remainTime;

    public Test(Users user, long endTime, List<Question> listQuestion) {
        this.user = user;
        this.endTime = endTime;
        this.listQuestion = listQuestion;
    }

    public Users getUser() {
        return user;
    }



    public long getEndTime() {
        return endTime;
    }

    public List<Question> getListQuestion() {
        return listQuestion;
    }

    public long getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(long remainTime) {
        this.remainTime = remainTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

   
}