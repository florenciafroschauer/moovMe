package repository;

import model.Terminal;
import model.Zone;
import java.util.ArrayList;
import java.util.List;

public class TerminalRepository extends AbstractRepository<Terminal> {

    public List<Terminal> searchByZone(Zone zone) {
        List<Terminal> terminals = findAll();
        List<Terminal> terminalsInZone = new ArrayList<>();

        for (Terminal terminal: terminals) {
            if (terminal.showZone().equals(zone)) {
                terminalsInZone.add(terminal);
            }
        }

        return terminalsInZone;
    }

    public Terminal searchOneByZone(Zone zone) {
        List<Terminal> terminals = findAll();

        for (Terminal terminal: terminals) {
            if (terminal.showZone().equals(zone)) return terminal;
        }

        return null;
    }
}
