package com.swifty.service.education.education.service.entity;

import com.fasterxml.jackson.annotation.*;
import com.swifty.service.education.education.service.entity.Course;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId", scope = Long.class)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_COURSE",
                joinColumns = @JoinColumn(name = "userId"),
                inverseJoinColumns = @JoinColumn(name = "courseId")
    )
    @JsonIdentityReference(alwaysAsId = true)
    private List<Course> courseList;
}
