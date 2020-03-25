package diploma.autos.creation.dto;

import javax.persistence.*;

@Entity
@Table(name = "Author", schema = "catalog", catalog = "")
public class AuthorDTO {
    private int authorId;
    private String name;
    private String surname;

    @Id
    @Column(name = "authorID")
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorDTO authorDTO = (AuthorDTO) o;

        if (authorId != authorDTO.authorId) return false;
        if (name != null ? !name.equals(authorDTO.name) : authorDTO.name != null) return false;
        if (surname != null ? !surname.equals(authorDTO.surname) : authorDTO.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
