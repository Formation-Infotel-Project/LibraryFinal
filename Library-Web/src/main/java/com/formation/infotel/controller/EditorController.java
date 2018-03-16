package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.EditorDto;
import com.formation.infotel.entity.Book;
import com.formation.infotel.entity.Editor;
import com.formation.infotel.services.interfaces.BookService;
import com.formation.infotel.services.interfaces.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class EditorController {

    @Autowired
    EditorService editorService;
    @Autowired
    BookService bookService;

    @PutMapping(value = "editor/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addEditor(@RequestBody EditorDto editorDto){

        Editor editor = new Editor(editorDto.getName(), editorDto.getEditorAddress());
        Set<Book> books = new HashSet<>();
        for(int i=0;i<editorDto.getBooksId().size();i++){
            books.add(bookService.getBookById(editorDto.getBooksId().get(i)));
        }
        editor.setBooks(books);

        editorService.insertEditor(editor);
    }

    @PostMapping(value = "editor/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEditor(@RequestBody EditorDto editorDto, @PathVariable(value="id") int id){

        Editor editor = editorService.getEditor(id);
        editor.setName(editorDto.getName());
        editor.setEditorAddress(editorDto.getEditorAddress());
        Set<Book> books = new HashSet<>();
        for(int i=0;i<editorDto.getBooksId().size();i++){
            books.add(bookService.getBookById(editorDto.getBooksId().get(i)));
        }
        editor.setBooks(books);

        editorService.updateEditor(editor);
    }

    @DeleteMapping(value = "editor/delete/{id}")
    public void deleteEditor(@PathVariable(value="id") int id){

        Editor editor = editorService.getEditor(id);

        editorService.deleteEditor(editor);
    }

    @RequestMapping("editor/get/{id}")
    public EditorDto getEditor(@PathVariable(value="id") int id){
        Editor editor = editorService.getEditor(id);
        List<Integer> booksId = new ArrayList<>();
        editor.getBooks().forEach(b -> {
            booksId.add(b.getIsbn());
        });
        EditorDto viewEditor = new EditorDto(editor.getName(), editor.getEditorAddress(), booksId);
        return viewEditor;
    }

    @RequestMapping("editor/get")
    public List<EditorDto> getEditors(){
        List<EditorDto> viewEditors = new ArrayList<>();
        List<Editor> editors = editorService.getAllEditors();
        List<Integer> booksId = new ArrayList<>();
        editors.forEach(e -> {
            e.getBooks().forEach(b -> booksId.add(b.getIsbn()));
            viewEditors.add(new EditorDto(e.getName(), e.getEditorAddress(), booksId));
        });
        return viewEditors;
    }
}
