package racingcar.domain;

import org.assertj.core.util.Lists;

import java.util.*;

public class Cars {
    private List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<>();
    }

    public void add(Car car) {
        carList.add(car);
    }

    public int numberOfCar() {
        return carList.size();
    }

    public boolean move() {
        boolean atLeastOneMove = false;
        for (Car car : carList) {
            boolean move = car.move();
            atLeastOneMove = atLeastOneMove || move;
        }
        return atLeastOneMove;
    }

    public WinnerCars calcWinner() {
        Map<Integer, List<Car>> map = new HashMap<>();
        int winnerPosition = -1;
        for (Car car : carList) {
            int position = car.getPosition();
            List<Car> candidate = map.getOrDefault(position, Lists.newArrayList());
            map.putIfAbsent(position, candidate);
            candidate.add(car);
            winnerPosition = Math.max(winnerPosition, position);
        }
        return new WinnerCars(map.get(winnerPosition));
    }

    public String toStatusString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.toStatusString()).append("\n");
        }
        return sb.toString();
    }
}
