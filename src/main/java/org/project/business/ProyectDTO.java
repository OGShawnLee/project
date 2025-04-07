package Business;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProyectDTO extends Proyect{
    private String id;

    public ProyectDTO(SBuilder builder) {
        super(builder);
        this.id = builder.id;
    }

    public ProyectDTO(ResultSet resultSet) throws SQLException {
        super(
                new SBuilder()
                        .setID(resultSet.getString("id_project"))
                        .setNameproyect(resultSet.getString("name"))
                        .setMethodology(resultSet.getString("methodology"))
                        .setStateproyect(resultSet.getString("state"))
                        .setSector(resultSet.getString("sector"))
        );
        this.id = resultSet.getString("id_student");
    }

    public String getID() {
        return id;
    }

    public static class SBuilder extends PBuilder<SBuilder> {
        private String id;

        public SBuilder setID(String id) {
            this.id = id;
            return this;
        }

        @Override
        public ProyectDTO build() {
            return new ProyectDTO(this);
        }
    }
}
