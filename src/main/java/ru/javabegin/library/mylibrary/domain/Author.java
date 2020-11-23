package ru.javabegin.library.mylibrary.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
//name = "author" для примера, в данном случае можно не указывать, т.к. имя таблицы совпадает с именем класса
//@Table(name = "author", catalog = "library")
//@Table(name = "author", schema ="library")
@Table(name = "author", schema ="library")
//создаем hash код по id
@EqualsAndHashCode(of = "id")
@Getter @Setter
//нужны для того, когда мы будем вставлять новые объекты (или обновлять)
// он будет использовать только те поля которые изменились
@DynamicUpdate
@DynamicInsert
//нужны для того, когда hibernate мог проверить перед Update нужно ли объект обновлять
//т.е перд Update он будет вызывать select и проверять нужен ли этот Update
@SelectBeforeUpdate
public class Author {
    //Эта аннотация говорит чято поле будет автоинкремент
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String fio;

    private Date birthday;

    //т.к. таблица book ссылется на author - то мы делаем двухстороннюю связь, также прописываем эту связь в
    //    таблице book (см класс book)
    //т.е. для каждого автора мы можем найти все его книги, а для каждой книги мы ище одного автора
    //FetchType.LAZY - означает ленивая инициализация, т.е. если нам books не нужен то эта коллекция подтягиваться
    // не будет для каждого автора, а будет подтягиваться тольк ов том случаем если мы специально вызовем запрос на
    //    получение всех книг для автора
    @Basic(fetch = FetchType.LAZY)  //IDEA говорит что это надо удалить
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    //это делаем для того чтобы выводить фамилию автора, пригодится когда будем делать frontend
    @Override
    public String toString() {
        return fio;
    }

}
