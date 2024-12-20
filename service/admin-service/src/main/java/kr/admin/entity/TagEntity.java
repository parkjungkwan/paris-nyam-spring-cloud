package kr.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tags")
public class TagEntity {

    @Id
    private String name;

    @Enumerated(EnumType.STRING)
    private TagCategory tagCategory;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    @JsonIgnore
    @Builder.Default
    private List<PostTagEntity> postTags = new ArrayList<>();

    public TagEntity(String name, TagCategory tagCategory) {
        this.name = name;
        this.tagCategory = tagCategory;
    }

}
