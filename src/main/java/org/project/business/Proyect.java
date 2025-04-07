package Business;

import java.time.LocalDateTime;

public abstract class Proyect {
    private final String nameproyect;
    private final String methodology;
    private final String stateproyect;
    private final String sector;
    private final LocalDateTime createdAt;

    public Proyect(PBuilder<?> builder) {
        this.nameproyect = builder.nameproyect;
        this.methodology = builder.methodology;
        this.stateproyect = builder.stateproyect;
        this.sector = builder.sector;
        this.createdAt = builder.createdAt;
    }

    public String getNameproyect() {
        return nameproyect;
    }

    public String getMethodology() {
        return methodology;
    }

    public String getStateproyect() {
        return stateproyect;
    }

    public String getSector() {
        return sector;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static abstract class PBuilder<T extends PBuilder<T>> {
        protected String nameproyect;
        protected String methodology;
        protected String stateproyect;
        protected String sector;
        protected LocalDateTime createdAt;

        public T self() {
            return (T) this;
        }

        public T setNameproyect(String nameproyect) {
            this.nameproyect = nameproyect;
            return self();
        }

        public T setMethodology(String methodology) {
            this.methodology = methodology;
            return self();
        }

        public T setStateproyect(String stateproyect) {
            this.stateproyect = stateproyect;
            return self();
        }

        public T setSector(String sector) {
            this.sector = sector;
            return self();
        }


        public T setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return self();
        }

        public abstract Proyect build();
    }
}
