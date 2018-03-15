package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Editor;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.interfaces.EditorDao;
import com.formation.infotel.services.interfaces.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorServiceImpl implements EditorService{

    @Autowired
    private EditorDao editorDao;
    @Autowired
    private Dao dao;

    @Override
    public void insertEditor(Editor editor) {
        dao.save(editor);
    }

    @Override
    public void deleteEditor(Editor editor) {
        dao.delete(editor);
    }

    @Override
    public void updateEditor(Editor editor) {
        dao.saveOrUpdate(editor);
    }

    @Override
    public Editor getEditor(int editorId) {
        return dao.get(Editor.class, editorId);
    }

    @Override
    public List<Editor> getAllEditors() {
        return dao.getAll(Editor.class);
    }

    @Override
    public Editor getEditorByName(String name) {
        return editorDao.getEditor(name);
    }
}
