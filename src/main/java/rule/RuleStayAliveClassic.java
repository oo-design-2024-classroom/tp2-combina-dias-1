package rule;

import cell.ClassicCell;
import cell.CellType;
import factory.cell.CellFactory;
import game.GameType;

import java.util.List;

public class RuleStayAliveClassic extends Rule {
    public RuleStayAliveClassic(List<Integer> neighboursToCheck, CellFactory cellFactory) {
        super(neighboursToCheck, cellFactory);
        if(neighboursToCheck.size() != 2)
            throw new IllegalArgumentException("neighboursToCheck.size() != 2");
    }
    public boolean isTrue(ClassicCell classicCell, int neighbours) {
        return classicCell.isAlive() && (neighbours == neighboursToCheck.get(0) || neighbours == neighboursToCheck.get(1));
    }
    public ClassicCell execute() {
        return new ClassicCell(CellType.ALIVE);
    }
}
