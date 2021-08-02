package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="notes")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Note {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name="User")
    private  String user;

    @Column(name="Note")
    private String note;

    @Column(name="Date")
    private  String date;

    public Note(String user, String note, String date) {
        this.user = user;
        this.note = note;
        this.date = date;
    }

    public Note() {

    }
}
