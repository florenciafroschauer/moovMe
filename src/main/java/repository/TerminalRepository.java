package repository;

import model.Terminal;
import model.Zone;
import java.util.ArrayList;
import java.util.List;

public class TerminalRepository extends AbstractRepository<Terminal> {

    private static TerminalRepository terminalRepository;

    private TerminalRepository() {
        create(new Terminal(new Zone("Pilar", 5), "Terminal en Pilar"));
    }

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

    public static TerminalRepository getInstance() {
        if (terminalRepository != null) {
            return terminalRepository;
        } else {
            terminalRepository = new TerminalRepository();
        }

        return terminalRepository;
    }
}
