package repository;

import model.Zone;

public class ZoneRepository extends AbstractRepository<Zone> {

    private static ZoneRepository zoneRepository;

    private ZoneRepository() {
        create(new Zone("Tigre", 15));
    }

    public static ZoneRepository getInstance() {
        if (zoneRepository != null) {
            return zoneRepository;
        } else {
            zoneRepository = new ZoneRepository();
        }

        return zoneRepository;
    }
}
