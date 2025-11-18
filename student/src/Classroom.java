// Classroom.java

import java.io.Serializable;
import java.util.Objects;

public class Classroom implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String category;
    private int capacity;
    private int floor;
    private boolean hasProjector;
    private boolean available;

    public Classroom(int id, String name, String category, int capacity, int floor, boolean hasProjector, boolean available) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.floor = floor;
        this.hasProjector = hasProjector;
        this.available = available;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("Classroom{id=%d, name='%s', category='%s', capacity=%d, floor=%d, projector=%s, available=%s}",
                id, name, category, capacity, floor, hasProjector, available);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classroom that = (Classroom) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
