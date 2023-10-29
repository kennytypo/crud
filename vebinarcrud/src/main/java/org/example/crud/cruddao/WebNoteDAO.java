package org.example.crud.cruddao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import org.example.crud.models.WebNote;

@Component
public class WebNoteDAO {
    private static int NOTES_COUNT;
    private List<WebNote> notes;

    public WebNoteDAO() {
        notes = new ArrayList<WebNote>();

        notes.add(new WebNote(++NOTES_COUNT, "Note 1"));
        notes.add(new WebNote(++NOTES_COUNT, "Note 2"));
        notes.add(new WebNote(++NOTES_COUNT, "Note 3"));
        notes.add(new WebNote(++NOTES_COUNT, "Note 4"));
        notes.add(new WebNote(++NOTES_COUNT, "Note 5"));
    }

    public List<WebNote> index() {
        return notes;
    }

    public WebNote show(int id) {
        return notes.stream().filter(n -> n.getId() == id).findAny().orElse(null);
    }

    public void save(WebNote webNote) {
        webNote.setId(++NOTES_COUNT);
        notes.add(webNote);
    }

    public void update(int id, WebNote updatedNote) {
        WebNote toUpdateNote = show(id);
        toUpdateNote.setNote(updatedNote.getNote());
    }

    public void delete(int id) {
        notes.removeIf(n -> n.getId() == id);
    }
}

