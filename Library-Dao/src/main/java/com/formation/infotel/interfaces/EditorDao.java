package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Editor;
import java.util.List;

public interface EditorDao {

    void insertEditor(Editor editor);

    Editor getEditorById(int editorId);

    Editor getEditor(String editorname);

    List<Editor> getEditors();
}
