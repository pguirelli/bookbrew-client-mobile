package com.example.bookbrew;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        recyclerView = findViewById(R.id.recyclerViewBooks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Book> books = createSampleBooks();
        adapter = new BookAdapter(books);
        adapter.setOnItemClickListener((book, position) -> {
            Intent intent = new Intent(BooksActivity.this, BookStyleActivity.class);
            intent.putExtra("book_position", position);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }

    private List<Book> createSampleBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Dom Casmurro", "Machado de Assis", "Um clássico da literatura brasileira"));
        books.add(new Book("1984", "George Orwell", "Uma distopia futurista"));
        books.add(new Book("O Senhor dos Anéis", "J.R.R. Tolkien", "Uma épica aventura fantástica"));
        books.add(new Book("Orgulho e Preconceito", "Jane Austen", "Um romance clássico"));
        books.add(new Book("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Uma história atemporal"));
        books.add(new Book("Cem Anos de Solidão", "Gabriel García Márquez", "Realismo mágico"));
        books.add(new Book("O Alquimista", "Paulo Coelho", "Uma jornada espiritual"));
        books.add(new Book("A Metamorfose", "Franz Kafka", "Uma obra surreal"));
        books.add(new Book("O Hobbit", "J.R.R. Tolkien", "A aventura que precedeu O Senhor dos Anéis"));
        books.add(new Book("Crime e Castigo", "Fiódor Dostoiévski", "Um thriller psicológico"));
        return books;
    }
}
