package Lab;

import java.util.Iterator;
import java.util.List;

public class Library  implements Iterable<Book>{
    private Book[] books;

    public Library(Book ... books) {
        this.books =books;
    }
    public int size(){
        return books.length;
    }
    public Book get(int index){
        return books[index];
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    private  class  LibraryIterator implements Iterator<Book>{
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index<size();
        }

        @Override
        public Book next() {
            Book book = get(index);
            index++;
            return book;
        }
    }
}
