package org.dav.ndw.interview.tickets.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    private int id;
    private String login;
    private String password;
    private String fullName;
    private boolean sex;
    private Set<Ticket> tickets = new HashSet<>();

    public Client() {}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "login")
    @NotBlank(message = "Некорректный логин.")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    @NotBlank(message = "Некорректный пароль.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "fullname")
    @NotBlank(message = "Некорректное ФИО.")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "sex")
    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                sex == client.sex &&
                Objects.equals(login, client.login) &&
                Objects.equals(password, client.password) &&
                Objects.equals(fullName, client.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, fullName, sex);
    }

    @Override
    public String toString() {
        return "Client: login=" + login +
                ", password=" + password +
                ", FIO=" + fullName +
                ", Man=" + sex;
    }
}
