package cm.skysoft.Care_Health.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private boolean enabled;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_name" , referencedColumnName = "id")}
    )
    private Set<Role> roles;
}
