package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "note_type")
public class NoteType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    int typeId;

    @Column(name = "name")
    String type;

    @Column(name = "description_note")
    String description;

    public NoteType() {
    }

    public NoteType(int typeId, String type, String description) {
        this.typeId = typeId;
        this.type = type;
        this.description = description;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
