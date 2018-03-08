package com.formation.infotel.interfaces;

import java.util.List;

import com.formation.infotel.entity.Borrow;

public interface BorrowDao {
	
    void createBorrow(Borrow borrow);

    Borrow  getBorrowById(int borrowId);

    Borrow  getBorrow(String BorrowId);

    List<Borrow > Borrow ();

}
