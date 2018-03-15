package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Catalog;

public interface CatalogDao {

    Catalog getCatalogByName(String catalogName);
}
