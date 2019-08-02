package com.stackroute.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="track")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    @Id
    @Column(name="id")
    @JsonProperty("id")
    private int id;
    @Column(name="name")
    @JsonProperty("name")
    private String name;
    @Column(name="comment")
    @JsonProperty("artist")
    private String comment;
}