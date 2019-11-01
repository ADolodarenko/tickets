package org.dav.ndw.interview.tickets.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ticket")
public class Ticket {
    private static final String ERROR_DATE_MESSAGE = "Некорректная дата.";
    private static final String ERROR_PRICE_MESSAGE = "Некорректная стоимость.";

    private int id;
    private Date date;
    private double price;
    private Client client;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = ERROR_DATE_MESSAGE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "price")
    @NotNull(message = ERROR_PRICE_MESSAGE)
    @DecimalMin(value = "0.0", message = "")
    //@NumberFormat(style = NumberFormat.Style.CURRENCY)
    //@Type(type = "org.hibernate.type.BigDecimalType")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                Double.compare(ticket.price, price) == 0 &&
                Objects.equals(date, ticket.date) &&
                Objects.equals(client, ticket.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, price, client);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", date=" + date +
                ", price=" + price +
                ", client=" + client +
                '}';
    }
}
