package com.ghosh.sanjay.repositories;

import com.ghosh.sanjay.beans.BookItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCatalogueRepository extends CrudRepository<BookItem, Long> {

    BookItem findById(long id);

    BookItem findByBarcode(String barcode);

}
