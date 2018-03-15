package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Editor;

import java.util.List;

public interface EditorService {

    void insertEditor(Editor editor);

    void deleteEditor(Editor editor);

    void updateEditor(Editor editor);

    Editor getEditor(int editorId);

    List<Editor> getAllEditors();

    Editor getEditorByName(String name);
}
