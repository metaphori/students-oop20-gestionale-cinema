package model;

import java.util.Optional;

public interface IdsGenerator {
    int getNewId();
    Optional<Integer> getLastGeneratedId();

}
