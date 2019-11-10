package repository;

import model.Terminal;
import model.Zone;
import java.util.List;

public class TerminalRepository extends AbstractRepository<Terminal> {

    public Terminal searchByZone(Zone zone) {
        List<Terminal> terminals = findAll();

        for (Terminal terminal: terminals) {
            if (terminal.showZone().equals(zone)) return terminal;
        }

        return null;
    }
}
