package letscode.sarafan.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ust")
@EqualsAndHashCode(of = {"id"})
public class User implements Serializable {
    @Id
    @JsonView(Views.IdName.class)
    private String id;

    @JsonView(Views.IdName.class)
    private String userpic;
    private String name;
    private String email;

    @JsonView(Views.FullProfile.class)
    private String gender;

    @JsonView(Views.FullProfile.class)
    private String locale;

    @JsonView(Views.FullProfile.class)
    private LocalDateTime lastVisit;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    /**
     * JsonIdentityInfo говорит о том что первое вхождение объекта будет как обеъект,
     * а последующие - как id первого вхождения, то есть не будет дубляжа (будут только
     * ссылки на первое вхождение)
     */



    @JsonView(Views.FullProfile.class)
    @OneToMany(
            mappedBy = "subscriber",
            orphanRemoval = true
    )
    private Set<UserSubscription> subscriptions = new HashSet<>();



    @JsonView(Views.FullProfile.class)
    @OneToMany(
            mappedBy = "channel",
            orphanRemoval = true,
            cascade = CascadeType.ALL

    )
    private Set<UserSubscription> subscribers = new HashSet<>();;

    public Set<UserSubscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<UserSubscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Set<UserSubscription> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<UserSubscription> subscribers) {
        this.subscribers = subscribers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public LocalDateTime getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
    }

}
