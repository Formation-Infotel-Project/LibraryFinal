package com.formation.infotel.dao;

import com.formation.infotel.entity.Editor;
import com.formation.infotel.interfaces.EditorDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EditorDaoImpl implements EditorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertEditor(Editor editor) {
        sessionFactory.getCurrentSession().save(editor);
    }

    @Override
    public Editor getEditorById(int editorId) {
        return (Editor) sessionFactory.getCurrentSession().get(Editor.class, editorId);
    }

    @Override
    public Editor getEditor(String editorname) {
        Query<Editor> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Editor where name = :editorname"));
        query.setParameter("Editorname", editorname);
        return (Editor) query.list().get(0);
    }

    @Override
    public List<Editor> getEditors() {
        List<Editor> editors = sessionFactory.getCurrentSession().createQuery(String.format("FROM Editor as editors")).list();
        return editors;
    }
}
