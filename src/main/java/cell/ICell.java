package cell;

public interface ICell {
    boolean equals(Object other);
    String toString();
    CellType type();
}