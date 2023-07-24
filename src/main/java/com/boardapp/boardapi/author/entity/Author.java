package com.boardapp.boardapi.author.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("author")
public class Author{
    @Id
    @Setter
    @Column("author_id")
    private Long authorId;

    @Column("author_name")
    private String authorName;

    @Setter
    @MappedCollection(idColumn = "author_id",keyColumn = "author_id")
    private List<AuthorRef> authorRefs = new ArrayList<>();

    public void addAuthorRef(AuthorRef authorRef) {
        this.authorRefs.add(authorRef);
    }
}
