package com.commun.application.entity;

import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Entity(name = "issue")
public class Issue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @Column(name = "reference", unique = true)
    private String reference;

    @Column(name = "summary")
    private String summary;

    @Column(name = "priority")
    private Integer priority;

    @Column(name="date_create")
    private Date dateCreate;

    @Column(name="date_update")
    private Date dateUpdate;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", summary='" + summary + '\'' +
                ", priority=" + priority +
                ", dateCreate=" + dateCreate +
                ", dateUpdate=" + dateUpdate +
                ", description='" + description + '\'' +
                '}';
    }
}
