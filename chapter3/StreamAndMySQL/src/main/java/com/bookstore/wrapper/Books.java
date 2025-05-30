package com.bookstore.wrapper;

import com.bookstore.dto.BookDto;
import com.bookstore.entity.Book;
import org.springframework.data.util.Streamable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Books implements Streamable<Book> {
    private final Streamable<Book> streamable;

    public Books(Streamable<Book> streamable) {
        this.streamable = streamable;
    }

    public Map<Boolean, List<Book>> partitionByPrice(int price) {
        return streamable.stream()
                .collect(Collectors.partitioningBy((Book a) -> a.getPrice() >= price));
    }

    public int sumPrices() {
        return streamable.stream()
                .map(Book::getPrice)
                .reduce(0, Integer::sum);
    }

    public List<BookDto> toBookDto() {
        return streamable
                .map(b -> new BookDto(b.getPrice(), b.getTitle()))
                .toList();
    }

    @Override
    public Iterator<Book> iterator() {
        return streamable.iterator();
    }
}
