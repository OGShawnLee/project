package org.project.business;

import java.time.LocalDateTime;

public class ProjectDTO {
    private final String name;
    private final String methodology;
    private final String state;
    private final String sector;
    private final LocalDateTime createdAt;

    public ProjectDTO(Builder builder) {
        this.name = builder.name;
        this.methodology = builder.methodology;
        this.state = builder.state;
        this.sector = builder.sector;
        this.createdAt = builder.createdAt;
    }

    public String getName() {
        return name;
    }

    public String getMethodology() {
        return methodology;
    }

    public String getStateproyect() {
        return state;
    }

    public String getSector() {
        return sector;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static abstract class Builder {
        protected String name;
        protected String methodology;
        protected String state;
        protected String sector;
        protected LocalDateTime createdAt;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMethodology(String methodology) {
            this.methodology = this.methodology;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setSector(String sector) {
            this.sector = sector;
            return this;
        }


        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ProjectDTO build() {
            return new ProjectDTO(this);
        }
    }
}
